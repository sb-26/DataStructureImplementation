package com.company;

public class myLinkedList<T>{
    private Node head;
    private int size;
    myLinkedList(){
        head=null;
        size=0;
    }

    public void insert(T data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
        size++;
    }

    public void addFirst(T data){
        Node newNode = new Node(data);
        if (head != null) {
            Node temp = head;
            newNode.next = temp;
        }
        head=newNode;
        size++;
    }

    public void addLast(T data){
        insert(data);
        size++;
    }

    public int size(){
        return size;
    }

    public boolean contains(T data){
        Node temp = head;
        while(temp!=null){
            if(temp.data==data)return true;
            temp=temp.next;
        }
        return false;
    }

    public T get(int index){
        if(index<0) return null;
        if(index>=size){
            return null;
        }else{
            Node temp = head;
            while(temp!=null && index>0){
                temp=temp.next;
                index--;
            }
            return (T) temp.data;
        }
    }

    public void remove(T data){
        if(head.data==data){
            head=head.next;
            size--;
        }else{
            Node temp = head;
            while(temp.next!=null && temp.next.data!=data){
                temp=temp.next;
            }
            if(temp.next!=null){
                temp.next=temp.next.next;
                size--;
            }
        }
    }

    public void print(){
        Node temp = head;
        System.out.print("[ ");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public T removeFirst() {
        if(head==null)return null;
        else{
            T element = (T) head.data;
            head=head.next;
            size--;
            return element;
        }
    }
}
class Node<T>{
    T data;
    Node next;
    Node(T data){
        this.data=data;
    }
}
