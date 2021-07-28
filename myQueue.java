package com.company;

public class myQueue <T>{
    private Node<T> frontEnd;
    private Node<T> rearEnd;
    private int size;


    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(frontEnd==null){
            frontEnd = newNode;
            rearEnd = newNode;
        }else{
            rearEnd.next = newNode;
            rearEnd=rearEnd.next;
        }
        size++;
    }

    public T poll(){
        if(frontEnd==null)return null;
        T data = frontEnd.data;
        frontEnd = frontEnd.next;
        size--;
        return data;
    }

    public T peek(){
        if(frontEnd==null)return null;
        T data = frontEnd.data;
        return data;
    }

    boolean isEmpty(){
        return size==0;
    }

    int size(){
        return size;
    }

    public void print(){
        Node temp = frontEnd;
        for(int i=0;i<size();i++){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
