package ContigousList;

import Interfaces.List;
import Linked.LinkedList;

public class ContigousList<Type extends Comparable<Type>> implements List<Type> {
    private int maxSize ;
    private int position;
    private Type[] ListEntry;
    public ContigousList(int size)
    {
        maxSize = size;
        ListEntry = (Type[])new Comparable[maxSize];
        position= -1;
    }

    public boolean isListEmpty()
    {
        return (position==-1);
    }
    boolean isListFull()
    {
        return (position== maxSize-1);
    }
    public int listSize()
    {
        return (position+1);
    }
    public void insertLast(Type x)
    {
        if (isListFull())
            System.out.println("Attempt to insert at the end of a full list");
        else
            ListEntry[++position] = x;
    }
    public void insertList(int p, Type element)
    { int i;
        if (isListFull())
            System.out.println("Attempt to insert an entry into a full list");
        else if (p < 0 || p > listSize())
            System.out.println("attempt to insert a position not in the list");
        else
        {
            for(i = listSize(); i >p; i--)
                ListEntry[i] = ListEntry[i-1];
            ListEntry[p] = element;
            position++;
        }
    }
    public Type retrieveList(int p ){
        Type element = null;
        if (isListEmpty()){
            System.out.println("Attempt to retrieve an entry from an empty list");
        }
        else if (p < 0 || p >= listSize()){
            System.out.println("attempt to retrieve an entry at a position not in the list");
        }
        else{
            element = ListEntry[p];
        }
        return element;

    }
    public void deleteList(int p){
        int i;
        if (isListEmpty()){
            System.out.println("Attempt to delete an entry from an empty list");
        }
        else if (p < 0 || p >= listSize()){
            System.out.println("attempt to delete an entry at a position not in the list");
        }
        else{
            for(i = p; i < listSize()-1; i++)
                ListEntry[i] = ListEntry[i+1];
            position--;
        }
    }



    public void traverseList()
    {
        int i;
        for (i=0; i<position+1; i++)
            System.out.print(ListEntry[i] +", ");
        System.out.print("\b\n");
    }


    public void heapSort()
    {
        int n = ListEntry.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            InsertHeap(n, i);
        for (int i = n - 1; i >= 0; i--) {
            Type temp = ListEntry[0];
            ListEntry[0] = ListEntry[i];
            ListEntry[i] = temp;
            InsertHeap(i, 0);
        }
    }

    void InsertHeap(int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
// If left child is larger than root
        if (left < n && ListEntry[left].compareTo(ListEntry[largest])>0)
            largest = left;
// If right child is larger than root
        if (right < n && ListEntry[right].compareTo(ListEntry[largest])>0)
            largest = right;
// If root is not largest
        if (largest != i) {
// swap a[i] with a[largest]
            Type temp = ListEntry[i];
            ListEntry[i] = ListEntry[largest];
            ListEntry[largest] = temp;
            InsertHeap( n, largest); }
    }

    public LinkedList<Type> binarySearch(Type comparingItem ) {
        int startCurser = 0;
        int endCurser = listSize()-1;
        while (comparingItem.compareTo(retrieveList((endCurser + startCurser) / 2))!=0 && endCurser!=startCurser) {
            if (retrieveList((endCurser + startCurser) / 2 ).compareTo(comparingItem)<0 ) {
                startCurser=(endCurser + startCurser)/2;
            }
            else{
                endCurser=(endCurser + startCurser)/2;
            }
        }



        //choose a linked list to avoid unnecessary computation
        LinkedList<Type> outPutList=new LinkedList<>();
        //go back to see if there are matching ones
        for(int i=(endCurser+startCurser)/2;i>startCurser;i--){
            if(comparingItem.compareTo(retrieveList(i))==0){
                startCurser=i;
            }
        }
        //put each one from start to finish into output list
        while(comparingItem.compareTo(retrieveList(startCurser))==0){
            outPutList.insertLast(retrieveList(startCurser));
            startCurser++;
        }


        return outPutList;


    }



}

