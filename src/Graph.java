import java.util.HashSet;
import java.util.stream.Collectors;

final public class Graph {
    final private static class Edge{
        private int cost;
        private Vertex from, to;

        public int getCost() {
            return cost;
        }

        public Vertex getFrom() {
            return from;
        }

        public Vertex getTo() {
            return to;
        }
    }
    final static  private class Vertex{
        private String name;
        private HashSet<Edge> edges;

        public Vertex(String name) {
            this.name = name;
            edges = new HashSet<>();
        }

        private Edge getEdgeToVertex(Vertex vertex){
            return this.edges.stream().filter(edge -> edge.getTo() == vertex).collect(Collectors.toList()).get(0);
        }
        private HashSet<Vertex> getNeighbours(){
            return (HashSet<Vertex>) this.edges.stream().map(Edge::getTo).collect(Collectors.toSet());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    private HashSet<Edge> edges;
    private HashSet<Vertex> vertices;
}
