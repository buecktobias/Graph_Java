import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PrimDijkstraAlgorithm {
    public static Graph primDijkstraAlgorithm(Graph graph, Graph.Vertex startVertex){
        Graph spanningTree = new Graph();
        spanningTree.addVertex(startVertex.getName()); // copy
        PriorityQueue<Graph.Edge> allPossibleEdges = new PriorityQueue<>(startVertex.getEdges());

        List<Graph.Vertex> verticesAlreadyAdded = new LinkedList<>();
        verticesAlreadyAdded.add(startVertex);

        while(!haveTwoListsTheSameElements(graph.getVertices(), spanningTree.getVertices())){
            Graph.Edge minimalEdge = allPossibleEdges.poll();
            assert minimalEdge != null;
            Graph.Vertex vertexNotInSpanningTree = getTheVertexOfTheMinimalEdgeWhichIsNotInTheSpanningTree(minimalEdge, verticesAlreadyAdded);
            assert vertexNotInSpanningTree != null;


            addVertexToSpanningTree(vertexNotInSpanningTree, spanningTree, verticesAlreadyAdded);
            spanningTree.addEdge(minimalEdge);
            addAllEdgesToPossibleEdgesWhichVerticesAreNotAlreadyInTheSpanningTree(vertexNotInSpanningTree, spanningTree, allPossibleEdges);

        }

        return spanningTree;
    }

    public static void addVertexToSpanningTree(Graph.Vertex vertex, Graph spanningTree, List<Graph.Vertex> verticesAlreadyAdded){
        spanningTree.addVertex(vertex.getName());
        verticesAlreadyAdded.add(vertex);
    }
    public static void addAllEdgesToPossibleEdgesWhichVerticesAreNotAlreadyInTheSpanningTree(Graph.Vertex vertexNotInSpanningTree, Graph spanningTree, PriorityQueue<Graph.Edge> allPossibleEdges){
        for(Graph.Edge edge: vertexNotInSpanningTree.getEdges()){
            List<Graph.Vertex> verticesOfEdge = edge.getVertices();
            if(!spanningTree.getVertices().contains(verticesOfEdge.get(0)) && !spanningTree.getVertices().contains(verticesOfEdge.get(1))){
                allPossibleEdges.add(edge);
            }
        }
    }
    public static Graph.Vertex getTheVertexOfTheMinimalEdgeWhichIsNotInTheSpanningTree(Graph.Edge edge, List<Graph.Vertex> verticesAlreadyAdded){
        for(Graph.Vertex vertex: edge.getVertices()){
            if( ! verticesAlreadyAdded.contains(vertex)){
                return vertex;
            }
        }
        return null;
    }
    public static void addVerticesToSpanningTree(List<Graph.Vertex> vertices, Graph spanningTree){
        for(Graph.Vertex vertex: vertices){
            spanningTree.addVertex(vertex);
        }
    }
    public static boolean haveTwoListsTheSameElements(List<Graph.Vertex> list1,List<Graph.Vertex> list2){
        return list1.size() == list2.size();

    }

}
