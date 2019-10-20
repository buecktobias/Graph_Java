import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTester {
    @Test
    public void testAddVertex(){
        Graph graph = new Graph();
        graph.addVertex("v1");
        assertEquals(graph.getVertex("v1").getName(), "v1");
        assertEquals(1, graph.getVertices().size(),"Graph getVertices() method should return a list with size 1");
    }

    @Test
    public void testAddEdge(){
        Graph graph = new Graph();
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addEdge("v1","v2",10);
        assertEquals(1, graph.getVertex("v1").getEdges().size());
        assertEquals(1, graph.getVertex("v2").getEdges().size());
    }
}