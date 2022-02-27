package com.bagadt;
/**
 *
 *  @author Frank M. Carrano, Timothy M. Henry
 */

public class Node<T> {
    private T data;
    private Node<T> next;

    private Node(T dataPortion)
    {
        this(dataPortion, null);
    }//end constructor

    private Node(T dataPortion, Node<T> nextNode)
    {
        data= dataPortion;
        next = nextNode;
    }//end constructor

    private T getData()
    {
        return data;
    }//end getData

    private void setData(T newData)
    {
        data = newData;
    }//end setData

    private Node getNextNode()
    {
        return next;
    }//end getNextNode()

    private void setNextNode(Node nextNode)
    {
        next = nextNode;
    }//end setNextNode


}//end Node
