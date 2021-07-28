package com.company;

public class myStack <T>{
    private myLinkedList<T> stackHead = new myLinkedList<>();

    public void push(T data){
        stackHead.addFirst(data);
    }
    public T pop(){
        if(stackHead.size()==0)return null;
        else{
            T topElement = stackHead.removeFirst();
            return topElement;
        }
    }
    public T peek(){
        if(stackHead.size()==0)return null;
        else{
            T topElement = stackHead.get(0);
            return topElement;
        }
    }
    boolean isEmpty(){
        return stackHead.size()==0;
    }
    int size(){
        return stackHead.size();
    }
    public void print(){
        for(int i=0;i<stackHead.size();i++){
            System.out.print(stackHead.get(i)+" ");
        }
        System.out.println();
    }

}
