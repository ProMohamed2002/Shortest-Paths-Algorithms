import java.util.ArrayList;
import java.util.Arrays;

public class TestDijkstra {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<edge> edges = new ArrayList<>();

        // Manually create 50 edges between 20 vertices
        edges.add(new edge(0, 1, 4));
        edges.add(new edge(0, 3, 5));
        edges.add(new edge(1, 2, 1));
        edges.add(new edge(1, 4, 6));
        edges.add(new edge(2, 0, 2));
        edges.add(new edge(2, 3, 3));
        edges.add(new edge(3, 2, 1));
        edges.add(new edge(3, 4, 2));
        edges.add(new edge(4, 0, 1));
        edges.add(new edge(4, 3, 4));


        // Create a graph and run Dijkstra's algorithm from source node 0
        Graph graph = new Graph(vertices, edges, "Floyd Warshall");
        long[][]distance = new long[vertices][vertices];
        int[][]next = new int[vertices][vertices];
        System.out.println(graph.floyd_warshall(distance, next));
//        for(int i = 0; i < vertices; i++){
//            for(int j = 0; j < vertices; j++){
//                System.out.print(distance[i][j] + " ");
//            }
//            System.out.println();
//        }
        StringBuilder res = graph.floydWarshallFindPath(4, 2, distance, next);
        System.out.println(res);

//        int[] parents = new int[vertices];
//        int[] costs = new int[vertices];
//        Arrays.fill(costs, Integer.MAX_VALUE); // Initialize costs to infinity
//        Arrays.fill(parents, -2); // Initialize parents

//        for (int i = 0; i < vertices; i++) {
//            Arrays.fill(parents[i],-2);
//            Arrays.fill(costs[i],Integer.MAX_VALUE);
//        }
        // Run Dijkstra from source node 0
//        graph.BellmanFord(0,parents,costs);
//        System.out.println(graph.generateOnePath(0,3,parents));
////        System.out.println(x);
//        // Print the expected results for parents and costs
//        System.out.println("Parents array: " + Arrays.toString(parents));
//        System.out.println("Costs array: " + Arrays.toString(costs));

    }
}