import java.util.*;
import java.util.stream.Collectors;

final public class Graph {

    final public static class Edge implements Comparable{
        private int cost;
        private Vertex from, to;

        public Edge(int cost,Vertex from, Vertex to) {
            this.cost = cost;
            this.from = from;
            this.to = to;
        }

        public int getCost() {
            return cost;
        }

        public Vertex getFrom() {
            return this.from;
        }

        public Vertex getTo() {
            return to;
        }

        @Override
        public int compareTo(Object o) {
            Edge other = (Edge) o;
            return Integer.compare(this.getCost(), other.getCost());
        }

        @Override
        public String toString() {
            return  this.getFrom() + "->" + this.getTo() + ", " + this.getCost();
        }
    }



    final public static class Vertex{
        private String name;
        private List<Edge> edges;

        public Vertex(String name) {
            this.name = name;
            this.edges = new LinkedList<>();
        }

        public void addEdge(Edge edge){
            this.edges.add(edge);
        }

        public Edge getEdgeToVertex(Vertex vertex){
            return this.edges.stream().filter(edge -> edge.getTo() == vertex).collect(Collectors.toList()).get(0);
        }

        public List<Vertex> getNeighbours(){
            return this.edges.stream().map(Edge::getTo).collect(Collectors.toList());
        }
        public List<Edge> getEdges(){
            return this.edges;
        }

        public String getName() {
            return this.name;
        }


        @Override
        public String toString() {
            return this.name;
        }
    }


    private HashMap<String, Vertex> vertices;

    Graph(){
        this.vertices = new HashMap<>();
    }

    public void addVertex(String nameOfVertex){
        Vertex vertex = new Vertex(nameOfVertex);
        this.vertices.put(nameOfVertex, vertex);
    }

    public void addVertex(Vertex vertex){
        this.vertices.put(vertex.getName(), vertex);
    }

    public Vertex getVertex(String nameOfVertex){
        return this.vertices.get(nameOfVertex);
    }

    public void addEdge(String nameOfFromVertex, String nameOfToVertex, int cost){
        Vertex from = this.vertices.get(nameOfFromVertex);
        Vertex to = this.vertices.get(nameOfToVertex);
        Edge newEdge = new Edge(cost, from, to);
        from.addEdge(newEdge);
        to.addEdge(newEdge);
    }

    public HashSet<Vertex> getVertices(){
        return (HashSet<Vertex>) this.vertices.values();
    }

    private List<Edge> getEdges(){
        List<Edge> allEdges = new LinkedList<>();
        for(Vertex vertex:this.vertices.values()){
            allEdges.addAll(vertex.getEdges());
        }
        return allEdges;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "edges=" + this.getEdges() +
                ", vertices=" + vertices.values() +
                '}';
    }
}
