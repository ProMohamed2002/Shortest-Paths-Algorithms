import java.util.ArrayList;
import java.util.Arrays;

public class TestDijkstra {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<edge> edges = new ArrayList<>();

        // Manually create 50 edges between 20 vertices
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 1));
        edges.add(new edge(2, 3, 1));
        edges.add(new edge(3, 0, -1));
        edges.add(new edge(4, 5, 1));
        edges.add(new edge(5, 6, 1));
        edges.add(new edge(6, 4, -1));



        // Create a graph and run Dijkstra's algorithm from source node 0
        Graph graph = new Graph(vertices, edges, "Bellman");

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        Arrays.fill(costs, Integer.MAX_VALUE); // Initialize costs to infinity
        Arrays.fill(parents, -2); // Initialize parents

        // Run Dijkstra from source node 0
        boolean x=graph.Check_NegativeCycle_BellmanFord();
        System.out.println(x);
        // Print the expected results for parents and costs
        System.out.println("Parents array: " + Arrays.toString(parents));
        System.out.println("Costs array: " + Arrays.toString(costs));
    }
}