package Linked;

import Interfaces.List;

public class LinkedList<Type extends Comparable<Type>> implements List<Type> {
    private Node<Type> head;
    private int count;
    Node<Type> sorted=null;
    public LinkedList()
    {
        head= null;
        count= 0;
    }

    public boolean isListEmpty()
    {
        return (head == null);
    }
    public int listSize ()
    {
        return (count);
    }
    public void insertLast(Type item){
        Node newItem= new Node(item);
        if(isListEmpty()){
            head =newItem;
        }
        else{
            //we have to interate through nodes by using n=n.next
            Node n=head;
            while(n.next!=null){
                n=n.next;
            }

            n.next=newItem;
        }
        count++;
    }


    public void insertList(int position,Type item){
        if(position>count){
            System.out.println("Failed attempt to insert a position not in the list");
        } else if (position == 0) {
            Node newNode=new Node<>(item);
            newNode.next=head.next;
            head=newNode;

        } else {
            Node newItem = new Node(item);
            Node n = head;
            Node previousToN = null;
            for (int i = 0; i < position && n.next != null; i++) {
                previousToN = n;
                n = n.next;
            }
            newItem.next = n.next;
            previousToN.next = newItem;


        }
    }

    public Type retrieveList(int p){
        if(isListEmpty()){
            System.out.println("the list is empty therefore cnnot be returned ");
        }else if(p>count || p<0){
            System.out.println("index out of bound");
        }else{
            Node n=head;
            for(int i=0;i<p;i++){
                n=n.next;
            }
            return (Type)n.data;
        }
        return null;
    }

    public void traverseList(){
        if(isListEmpty()){
            System.out.println("the list is empty");
        }else{
            Node n=head;
            int num=0;
            while(n!=null){
                System.out.println(num++ +")"+ n+ ", ");
                n=n.next;
            }
        }
    }

    public void deleteList(int position){
        if(isListEmpty()){
            System.out.println("the list is empty therefore cannot be deleted");
        }else if(position>count || position<0){
            System.out.println("index out of bound");
        }else{
            Node n=head;
            Node previousToN=null;
            for(int i=0;i<position && n.next!=null;i++){
                previousToN=n;
                n=n.next;
            }
            if(previousToN==null){
                head=n.next;
            }else{
                previousToN.next=n.next;
            }
            count--;
        }
    }


    public void selectionSort(){
        L1:for(int i=listSize()-1;i>=0;i--){
            //finding the max index
            int maxIndex=0;
            for(int j=0;j<=i;j++){
                if(retrieveList(j).compareTo(retrieveList(maxIndex))>0){
                    maxIndex=j;
                }
                if(maxIndex==i){
                    continue L1;
                }
            }
            Type temp=retrieveList(i);
            insertList(i,retrieveList(maxIndex));
            insertList(maxIndex,temp);

        }
    }

    public LinkedList<Type> sequentialSearch(Type item){
        Node n=head;
        LinkedList<Type> searchResults=new LinkedList<>();
        int indexOfFirst=-1;
        for(int i=0;n.next!=null;i++){
            if(n.data.compareTo(item)==0){
                indexOfFirst=i;
                break;
            }
            n=n.next;
        }
        if(indexOfFirst>=0){
            for(int j=indexOfFirst;j<listSize();j++){
                if(retrieveList(j).compareTo(item)!=0){
                    break;
                }
                searchResults.insertLast(retrieveList(j));
            }
        }
        return searchResults;

    }

}

