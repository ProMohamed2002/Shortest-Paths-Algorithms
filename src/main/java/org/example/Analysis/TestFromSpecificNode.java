package org.example.Analysis;

import org.example.ShortestPathsAlgoritms.Graph;
import org.example.ShortestPathsAlgoritms.GraphFileReader;
import org.example.ShortestPathsAlgoritms.edge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class TestFromSpecificNode {
    static double sum_of_dijkstra_time=0;
    static double sum_of_bellman_time=0;
    static double sum_of_floyd_time=0;

    public static void main(String[] args) throws IOException {
        for (int i=51;i<=60;i++) {
            String filePath = "randomGraphs\\graph"+i+".txt";
            Graph graph = new Graph(filePath);
            System.out.println("-------------------------------start test"+i+"--------------------------------------");
            runDijkstra(graph);
            runBellmanFord(graph);
            runFloydWarshall(graph);
            System.out.println("-------------------------------finish test"+i+"-------------------------------------");
            if(i==60) {
                System.out.println("average time of execution for nodes = " + graph.getSize() + " is ");
                getAverage(10);
                sum_of_bellman_time=0;
                sum_of_dijkstra_time=0;
                sum_of_floyd_time=0;

            }
        }
    }
//    run dijkstra
    private static void runDijkstra(Graph graph) {
        int[] parents = new int[graph.getSize()];
        int[] costs = new int[graph.getSize()];
        graph.initDijkstraOrBellman(parents, costs);
//        start time
        long startTime = System.nanoTime();
        graph.Dijkstra(GraphFileReader.source, parents, costs);
//        end time
        long endTime = System.nanoTime();
//        time from source to all destinations
        long duration = (endTime - startTime);
        sum_of_dijkstra_time+=duration;
        System.out.println("Dijkstra's Algorithm Execution Time: " + duration + " ns");

    }
    //run bellman ford
    private static void runBellmanFord(Graph graph) {
        int[] parents = new int[graph.getSize()];
        int[] costs = new int[graph.getSize()];
        graph.initDijkstraOrBellman(parents, costs);

//        start time
        long startTime = System.nanoTime();
        graph.BellmanFord(GraphFileReader.source, parents, costs);
//        end time
        long endTime = System.nanoTime();
//        time from source to all destinations
        long duration = (endTime - startTime) ;

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

        long duration = (endTime - startTime) ;
//        avg time from source to all destinations
        duration/=graph.getSize();
        sum_of_floyd_time+=duration ;
        System.out.println("Floyd-Warshall Algorithm Execution Time per one pair : " + duration + " ns");
    }
    private static void getAverage(double num_of_files)
    {
        System.out.println("Dijkstra's Algorithm Execution Time per graph : " + sum_of_dijkstra_time/num_of_files + " ns");
        System.out.println("Bellman's Algorithm Execution Time per graph : " + sum_of_bellman_time/num_of_files + " ns");
        System.out.println("Floyd's Algorithm Execution Time per graph : " + sum_of_floyd_time/num_of_files + " ns");


    }

}
