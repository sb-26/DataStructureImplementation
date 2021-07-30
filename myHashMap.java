package com.company;

import java.util.ArrayList;

public class myHashMap<K,V> {

    private ArrayList<hashNode<K,V>> bucket;
    myHashMap(int size){
        bucket = new ArrayList<>(size);
        for(int i=0;i<size;i++)bucket.add(null);
    }

    private int hashKey(K key){
        int hashKey = key.hashCode()%bucket.size();
        return hashKey;
    }
    public void put(K key,V value){
        int hashCode = hashKey(key);
        hashNode head = bucket.get(hashCode);
        if(head==null){
            hashNode<K,V> newNode = new hashNode(key,value);
            head=newNode;
            bucket.set(hashCode,head);
            return;
        }
        hashNode tmp = head;
        while(tmp.next!=null){
            if(tmp.key==key){
                tmp.value=value;
                return;
            }
            tmp=tmp.next;
        }
        if(tmp.key==key){
            tmp.value=value;
        }else{
            hashNode<K,V> newNode = new hashNode(key,value);
            tmp.next = newNode;
        }
        return;
    }

    public V get(K key){
        int hashCode = hashKey(key);
        hashNode head = bucket.get(hashCode);
        if(head==null){
            return null;
        }
        hashNode tmp = head;
        while(tmp!=null){
            if(tmp.key==key){
                return (V) tmp.value;
            }
            tmp=tmp.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int hashCode = hashKey(key);
        hashNode head = bucket.get(hashCode);
        hashNode tmp = head;
        while(tmp!=null){
            if(tmp.key==key)return true;
            tmp=tmp.next;
        }
        return false;
    }
    public void remove(K key){
        int hashCode = hashKey(key);
        hashNode head = bucket.get(hashCode);
        if(head==null)return;
        if(head.key==key){
            bucket.set(hashCode,head.next);
            return;
        }
        hashNode tmp = head;
        while(tmp.next!=null && tmp.next.key!=key){
            tmp=tmp.next;
        }
        if(tmp.next!=null)tmp.next=tmp.next.next;
    }

    public void print(){
        for(int i=0;i<bucket.size();i++){
            hashNode head = bucket.get(i);
            hashNode tmp = head;
            while(tmp!=null){
                System.out.println(tmp.key+" "+tmp.value);
                tmp=tmp.next;
            }
        }
    }
}
class hashNode<K,V>{
    K key;
    V value;
    hashNode next;
    hashNode(K key,V value){
        this.key=key;
        this.value=value;
    }
}
