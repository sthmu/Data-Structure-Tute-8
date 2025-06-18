package Interfaces;

public interface List<Type extends Comparable> {
    boolean isListEmpty();
    int listSize();
    void insertLast(Type item);
    void insertList(int position, Type item);
    Type retrieveList(int position);
    void deleteList(int position);
    void traverseList();
}