
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");

        graph.addEdge("v1","v2",10);
        graph.addEdge("v1","v3",4);

        System.out.println(graph);
    }
}
