public class Main {
    public static void main(String[] args) {
        Vertex<String> vA = new Vertex<>("A");
        Vertex<String> vB = new Vertex<>("B");
        Vertex<String> vC = new Vertex<>("C");
        Vertex<String> vD = new Vertex<>("D");
        Vertex<String> vE = new Vertex<>("E");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(vA);
        graph.addVertex(vB);
        graph.addVertex(vC);
        graph.addVertex(vD);
        graph.addVertex(vE);

        graph.addEdge(vA, vB, 1);
        graph.addEdge(vA, vC, 4);
        graph.addEdge(vB, vC, 2);
        graph.addEdge(vB, vD, 5);
        graph.addEdge(vC, vD, 1);
        graph.addEdge(vD, vE, 3);

        Search<String> bfs = new BreadthFirstSearch<>();
        System.out.println("BFS path from A to E: " + bfs.search(vA, vE));

        Search<String> dijkstra = new DijkstraSearch<>();
        System.out.println("Dijkstra path from A to E: " + dijkstra.search(vA, vE));
    }
}
