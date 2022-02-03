package com.codingtest.codeup.tree;

public class GraphNode {
    int vertex;     //정점 번호
    int weight;     //가중치


    public GraphNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}


