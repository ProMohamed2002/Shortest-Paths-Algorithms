package org.example.Analysis;

import org.example.ShortestPathsAlgoritms.Graph;
import org.example.ShortestPathsAlgoritms.edge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBetweenAllPairs {
    static double sum_of_dijkstra_time=0;
    static double sum_of_bellman_time=0;
    static double sum_of_floyd_time=0;
    public static void main(String[] args) throws IOException {
        for (int i=1;i<=5;i++) {
            String filePath = "randomGraphs\\graph"+i+".txt";
            Graph graph = new Graph(filePath);
            System.out.println("-------------------------------start test"+i+"--------------------------------------");
            runAllDijkstra(graph);
            runAllBellmanFord(graph);
            runFloydWarshall(graph);
            System.out.println("-------------------------------finish test"+i+"-------------------------------------");
            if(i%5==0) {
                System.out.println("average time of execution for nodes = " + graph.getSize() + " is ");
                getAverage(5);
                sum_of_bellman_time=0;
                sum_of_dijkstra_time=0;
                sum_of_floyd_time=0;
            }
        }

    }
    //    run all dijkstra
    private static void runAllDijkstra(Graph graph) {
        int[][] parents = new int[graph.getSize()][graph.getSize()];
        int[][] costs = new int[graph.getSize()][graph.getSize()];
        graph.initALLDijkstraOrBellman(parents, costs);
//        start time
        long startTime = System.nanoTime();
        graph.getAllDijkstra(parents, costs);
//        end time
        long endTime = System.nanoTime();
//        time between all pairs
        long duration = (endTime - startTime);
        sum_of_dijkstra_time+=duration;
        System.out.println("Dijkstra's Algorithm Execution Time: " + duration + " ns");

    }
    //run bellman ford
    private static void runAllBellmanFord(Graph graph) {
        int[][] parents = new int[graph.getSize()][graph.getSize()];
        int[][] costs = new int[graph.getSize()][graph.getSize()];
        graph.initALLDijkstraOrBellman(parents, costs);
//        start time
        long startTime = System.nanoTime();
        graph.getAllBellmanFord(parents, costs);
//        end time
        long endTime = System.nanoTime();
//        time between all pairs
        long duration = (endTime - startTime);
        sum_of_bellman_time+=duration;
        System.out.println("Bellman-Ford Algorithm Execution Time: " + duration + " ns");
    }
    private static void runFloydWarshall(Graph graph) {
        int[][] distances = new int[graph.getSize()][graph.getSize()];
        int[][] next = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(distances, next);
//        start time
        long startTime = System.nanoTime();
        graph.floydWarshall(distances, next);
//        end time
        long endTime = System.nanoTime();
//        time between all pairs
        long duration = (endTime - startTime);

        sum_of_floyd_time+=duration;
        System.out.println("Floyd-Warshall Algorithm Execution Time: " + duration + " ns");
    }
    private static void getAverage(double num_of_files)
    {
        System.out.println("Dijkstra's Algorithm Execution Time per graph : " + sum_of_dijkstra_time/num_of_files+ " ns");
        System.out.println("Bellman's Algorithm Execution Time per graph : " + sum_of_bellman_time/num_of_files + " ns");
        System.out.println("Floyd's Algorithm Execution Time per graph : " + sum_of_floyd_time/num_of_files + " ns");


    }
}
