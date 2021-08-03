package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    ArrayList<ArrayList<Integer>> graph;
    Graph(int vertices){
        graph = new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++){
            graph.add(new ArrayList<>());
        }
    }
    void add(int vertex1,int vertex2,boolean directed){
        graph.get(vertex1).add(vertex2);
        if(!directed)graph.get(vertex2).add(vertex1);
    }
    void printGraph(){
        for(int i=0;i<graph.size();i++){
            System.out.print(i+"->");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print(graph.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    void dfs(){
        boolean visited[] = new boolean[ graph.size()];
        for(int i=0;i< graph.size();i++){
            if(!visited[i])dfsHelper(visited,i);
        }
        System.out.println();
    }
    private void dfsHelper(boolean visited[],int i){
        visited[i]=true;
        System.out.print(i+" ");
        for(int j=0;j<graph.get(i).size();j++) {
            if (!visited[ graph.get(i).get(j) ]) dfsHelper(visited, graph.get(i).get(j));
        }
    }
    void bfs(){
        boolean visited[] = new boolean[ graph.size()];
        for(int i=0;i< graph.size();i++){
            if(!visited[i])bfsHelper(visited,i);
        }

    }

    private void bfsHelper(boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i]=true;
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x+" ");
            for(int j=0;j<graph.get(x).size();j++) {
                if (!visited[ graph.get(x).get(j) ]) {
                    q.add(graph.get(x).get(j));
                    visited[graph.get(x).get(j)]=true;
                }
            }
        }
    }


}
