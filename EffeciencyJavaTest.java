import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EffecienceyJavaTest {
    static double sum_of_dijkstra_time=0;
    static double sum_of_bellman_time=0;
    static double sum_of_floyd_time=0;

    public static void main(String[] args) {
        for (int i=1;i<=25;i++) {
            String filePath = "randomgraphs\\graph"+i+".txt";
            try {
                System.out.println("-------------------------------start test"+i+"--------------------------------------");
                Graph graph = loadGraphFromFile(filePath, "Dijkstra");
                runDijkstra(graph);
                graph = loadGraphFromFile(filePath, "Bellman Ford");
                runBellmanFord(graph);
                graph = loadGraphFromFile(filePath, "Floyd Warshall");
                runFloydWarshall(graph);
                System.out.println("-------------------------------finish test"+i+"-------------------------------------");
            } catch (IOException e) {
                System.out.println("Error reading the graph file: " + e.getMessage());
            }
        }
        System.out.println("average time after execution ");
        getmidian();
    }

    private static Graph loadGraphFromFile(String filePath,String way) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int vertices = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());
        ArrayList<edge> edgeList = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            String[] edgeData = reader.readLine().split(" ");
            int from = Integer.parseInt(edgeData[0]);
            int to = Integer.parseInt(edgeData[1]);
            int weight = Integer.parseInt(edgeData[2]);
            edgeList.add(new edge(from, to, weight));
        }
        reader.close();


        return new Graph(vertices,edgeList,way);
    }

    private static void runDijkstra(Graph graph) {
        long startTime = System.nanoTime();
        int[] parents = new int[graph.getSize()];
        int[] costs = new int[graph.getSize()];
        Arrays.fill(parents, -2);
        Arrays.fill(costs, Integer.MAX_VALUE);
        graph.Dijkstra(0, parents, costs);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        sum_of_dijkstra_time+=duration;
        System.out.println("Dijkstra's Algorithm Execution Time: " + duration + " ms");

    }
    //run bellman all
    private static void runBellmanFord(Graph graph) {
        long startTime = System.nanoTime();
        int[][] bfParents = new int[graph.getSize()][graph.getSize()];
        int[][] bfCosts = new int[graph.getSize()][graph.getSize()];
        Arrays.stream(bfParents).forEach(a -> Arrays.fill(a, -2));
        Arrays.stream(bfCosts).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        graph.getAllBellmanFord(bfParents, bfCosts);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        sum_of_bellman_time+=duration;
        System.out.println("Bellman-Ford Algorithm Execution Time: " + duration + " ms");
    }
    private static void runFloydWarshall(Graph graph) {
        long startTime = System.nanoTime();
        long[][] distances = new long[graph.getSize()][graph.getSize()];
        int[][] next = new int[graph.getSize()][graph.getSize()];
        Arrays.stream(distances).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        graph.floyd_warshall(distances, next);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        sum_of_floyd_time+=duration;
        System.out.println("Floyd-Warshall Algorithm Execution Time: " + duration + " ms");
    }
    private static void getmidian()
    {
        System.out.println("Dijkstra's Algorithm Execution Time per graph : " + sum_of_dijkstra_time/25.0 + " ms");
        System.out.println("Bellman's Algorithm Execution Time per graph : " + sum_of_bellman_time/25.0 + " ms");
        System.out.println("Floyd's Algorithm Execution Time per graph : " + sum_of_floyd_time/25.0 + " ms");


    }

}
