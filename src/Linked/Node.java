package Linked;

public class Node<Type extends Comparable>{
    Type data;
    Node next;

    Node(Type data){
        this.data=data;
    }

    @Override
    public String toString() {
        return ""+data ;
    }
}
