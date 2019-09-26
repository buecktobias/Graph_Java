import java.util.HashSet;
import java.util.PriorityQueue;

public class PrimDijkstraAlgorithm {
    public Graph primDijkstraAlgorithm(Graph graph, Graph.Vertex startVertex){
        Graph spanningTree = new Graph();
        spanningTree.addVertex(startVertex);
        PriorityQueue<Graph.Edge> edgesPriorityQueue = new PriorityQueue<>(startVertex.getEdges());

        while(spanningTree.getVertices() != graph.getVertices()){
            Graph.Edge edgeWithLowestCost = edgesPriorityQueue.poll();
            assert edgeWithLowestCost != null;
            Graph.Vertex newVertex = edgeWithLowestCost.getTo();
            spanningTree.addVertex(newVertex);
            edgesPriorityQueue.addAll(newVertex.getEdges());
        }
        return spanningTree;
    }
}
