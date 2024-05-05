import java.util.ArrayList;
import java.util.Arrays;

public class TestDijkstra {
    public static void main(String[] args) {
        int vertices = 3;
        ArrayList<edge> edges = new ArrayList<>();

        // Manually create 50 edges between 20 vertices
        edges.add(new edge(0, 1, 5));
        edges.add(new edge(0, 2, 4));
        edges.add(new edge(2, 1, 1));
//        edges.add(new edge(1, 3, 5));
//        edges.add(new edge(1, 5, 2));
//        edges.add(new edge(2, 1, 10));
//        edges.add(new edge(2, 4, 1));
//        edges.add(new edge(3, 5, 3));
//        edges.add(new edge(4, 3, 2));
//        edges.add(new edge(4, 6, 1));
//        edges.add(new edge(5, 4, 1));
//        edges.add(new edge(5, 6, 4));


        // Create a graph and run Dijkstra's algorithm from source node 0
        Graph graph = new Graph(vertices, edges, "Dijkstra");

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        Arrays.fill(costs, Integer.MAX_VALUE); // Initialize costs to infinity
        Arrays.fill(parents, -2); // Initialize parents

//        for (int i = 0; i < vertices; i++) {
//            Arrays.fill(parents[i],-2);
//            Arrays.fill(costs[i],Integer.MAX_VALUE);
//        }
        // Run Dijkstra from source node 0
        graph.Dijkstra(0,parents,costs);
//        System.out.println(x);
        // Print the expected results for parents and costs
        System.out.println("Parents array: " + Arrays.toString(parents));
        System.out.println("Costs array: " + Arrays.toString(costs));

    }
}