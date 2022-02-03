package com.codingtest.codeup.tree;

import java.util.*;

public class Graph {

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


    List<List<GraphNode>> graph;
    boolean []visit;

    public Graph(int n) {
        graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<GraphNode>());

        visit=new boolean[n];
    }


    //간선 연결
    public void addEdge(int fromEdge,int toEdge,int weight){
        //엣지 연결
        graph.get(fromEdge-1).add(new GraphNode(toEdge,weight));
        graph.get(toEdge-1).add(new GraphNode(fromEdge,weight));
    }

    //그래프 출력
    public void printGraph(){
        for (int i = 0; i < graph.size(); i++) {
            List<GraphNode> graphNodes = graph.get(i);
            System.out.printf("%d번 노드 연결 ->   ",i+1);
            for (GraphNode graphNode : graphNodes) {
                System.out.print(" (vertext : " + graphNode.getVertex()+ ", 가중치 : "+ graphNode.getWeight()+"),  ");
            }

            System.out.println("\n");

        }
    }

    public void bfs(int startVertex){
        Arrays.fill(visit,false);
        Queue<GraphNode> queue=new LinkedList<>();
        System.out.print(startVertex + " ");

        do{
            List<GraphNode> graphNodes = this.graph.get(startVertex -1);
            visit[startVertex-1]=true;  //방문
            graphNodes.sort((GraphNode v1, GraphNode v2) -> Integer.compare(v1.getVertex(), v2.getVertex()));    //오름차순 정렬

            for (GraphNode graphNode : graphNodes) {
                int vertex = graphNode.getVertex();
                if (!visit[vertex-1])
                    queue.offer(graphNode);
            }

            if(!queue.isEmpty()) {
                int vertex = queue.poll().getVertex();
                startVertex = vertex;
            }

            if(!visit[startVertex-1])   //방문하지 않았으면 찍어라
                System.out.print(startVertex + " ");

        }while (!queue.isEmpty());
    }

    public void dfs(int startVertex){
        Stack<GraphNode> stack= new Stack<>();
        System.out.print(startVertex + " ");

        do{
            List<GraphNode> graphNodes = graph.get(startVertex-1);
            visit[startVertex-1]=true;  //방문
            graphNodes.sort((GraphNode v1, GraphNode v2) -> Integer.compare(v2.getVertex(), v1.getVertex()));    //내림차순 정렬

            for (GraphNode graphNode : graphNodes) {
                int vertex = graphNode.getVertex();
                if (!visit[vertex-1])
                    stack.push(graphNode);
            }

            if(!stack.isEmpty()) {
                int vertex = stack.pop().getVertex();
                startVertex = vertex;
            }

            if(!visit[startVertex-1])   //방문하지 않았으면 찍어라
                System.out.print(startVertex + " ");

        }while (!stack.isEmpty());
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String vertexs = sc.nextLine();
        String[] s = vertexs.split(" ");

        int n = Integer.parseInt(s[0]); //정점
        int m=Integer.parseInt(s[1]);   //간선
        int v=Integer.parseInt(s[2]);   //시작할 정점 번호
        Graph graph=new Graph(n);

        for (int i = 0; i < m; i++) {
            int fvt = sc.nextInt();
            int tvt = sc.nextInt();

            graph.addEdge(fvt,tvt,10);  //간선 연결
        }

        //graph.printGraph();

        graph.dfs(v);
        System.out.println("");
        graph.bfs(v);
    }
}
