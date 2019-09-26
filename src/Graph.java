import java.util.*;
import java.util.stream.Collectors;

final public class Graph {

    final public static class Edge implements Comparable{
        private int cost;
        private Vertex vertex1, vertex2;

        public Edge(int cost,Vertex vertex1, Vertex vertex2) {
            this.cost = cost;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        public int getCost() {
            return cost;
        }

        public List<Vertex> getVertices(){
            List<Vertex> vertices = new LinkedList<>();
            vertices.add(this.vertex1);
            vertices.add(this.vertex2);
            return vertices;
        }

        @Override
        public int compareTo(Object o) {
            Edge other = (Edge) o;
            return Integer.compare(this.getCost(), other.getCost());
        }

        @Override
        public String toString() {
            return  this.vertex1 + "< - >" + this.vertex2 + ", " + this.getCost();
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

    public void addEdge(Edge edge){
        for(Vertex vertex: edge.getVertices()){
            this.getVertex(vertex.getName()).addEdge(edge);
        }
    }

    public List<Vertex> getVertices(){
        return new LinkedList<>(this.vertices.values());
    }

    private HashSet<Edge> getEdges(){
        HashSet<Edge> allEdges = new HashSet<>();
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
