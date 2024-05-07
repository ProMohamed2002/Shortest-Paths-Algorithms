package org.example;

import org.example.ShortestPathsAlgoritms.Graph;
import org.example.ShortestPathsAlgoritms.edge;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllDijkstraTest {
    @Test
    void testAllDijkstra() {
        int vertices = 3;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        Graph graph = new Graph(vertices, edges);

        int[][] dParents = new int[vertices][vertices];
        int[][] dCosts = new int[vertices][vertices];
        graph.initALLDijkstraOrBellman(dParents, dCosts);

        graph.getAllDijkstra(dParents, dCosts);


        assertEquals(0, dCosts[0][0]);
        assertEquals(1, dCosts[0][1]);
        assertEquals(3, dCosts[0][2]);
        assertEquals(-1, dParents[0][0]);
        assertEquals(0, dParents[0][1]);
        assertEquals(1, dParents[0][2]);
    }


    @Test
    void testAllDijkstra2() {
        int vertices = 6;
        ArrayList<edge> edges = new ArrayList<>();
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
        edges.add(new edge(5, 2, 1)); // additional edge for node 5
        Graph graph = new Graph(vertices, edges);

        int[][] dParents = new int[vertices][vertices];
        int[][] dCosts = new int[vertices][vertices];
        graph.initALLDijkstraOrBellman(dParents, dCosts);

        graph.getAllDijkstra(dParents, dCosts);


        assertEquals(0, dCosts[0][0]);
        assertEquals(4, dCosts[0][1]);
        assertEquals(5, dCosts[0][2]);
        assertEquals(5, dCosts[0][3]);
        assertEquals(7, dCosts[0][4]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][5]);
        assertEquals(-1, dParents[0][0]); // Parent of node 0 is itself
        assertEquals(0, dParents[0][1]);  // Parent of node 1 is 0
        assertEquals(1, dParents[0][2]);  // Parent of node 2 is 1
        assertEquals(0, dParents[0][3]);  // Parent of node 3 is 3
        assertEquals(3, dParents[0][4]);  // Parent of node 4 is 4
        assertEquals(-2, dParents[0][5]); // Node 5 is unreachable
    }


    @Test
    void testAllDijkstra8Vertices() {
        int vertices = 8;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        Graph graph = new Graph(vertices, edges);

        int[][] dParents = new int[vertices][vertices];
        int[][] dCosts = new int[vertices][vertices];
        graph.initALLDijkstraOrBellman(dParents, dCosts);
        graph.getAllDijkstra(dParents, dCosts);


        assertEquals(0, dCosts[0][0]);
        assertEquals(1, dCosts[0][1]);
        assertEquals(3, dCosts[0][2]);
        assertEquals(3, dCosts[0][3]);
        assertEquals(4, dCosts[0][4]);
        assertEquals(9, dCosts[0][5]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][6]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][7]);

        assertEquals(-1, dParents[0][0]);
        assertEquals(0, dParents[0][1]);
        assertEquals(1, dParents[0][2]);
        assertEquals(0, dParents[0][3]);
        assertEquals(3, dParents[0][4]);
        assertEquals(4, dParents[0][5]);
        assertEquals(-2, dParents[0][6]);
        assertEquals(-2, dParents[0][7]);
    }

    @Test
    void testAllDijkstra9Vertices() {
        int vertices = 9;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        Graph graph = new Graph(vertices, edges);

        int[][] dParents = new int[vertices][vertices];
        int[][] dCosts = new int[vertices][vertices];
        graph.initALLDijkstraOrBellman(dParents, dCosts);
        graph.getAllDijkstra(dParents, dCosts);


        assertEquals(0, dCosts[0][0]);
        assertEquals(1, dCosts[0][1]);
        assertEquals(3, dCosts[0][2]);
        assertEquals(3, dCosts[0][3]);
        assertEquals(4, dCosts[0][4]);
        assertEquals(9, dCosts[0][5]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][6]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][7]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][8]);

        assertEquals(-1, dParents[0][0]);
        assertEquals(0, dParents[0][1]);
        assertEquals(1, dParents[0][2]);
        assertEquals(0, dParents[0][3]);
        assertEquals(3, dParents[0][4]);
        assertEquals(4, dParents[0][5]);
        assertEquals(-2, dParents[0][6]);
        assertEquals(-2, dParents[0][7]);
        assertEquals(-2, dParents[0][8]);
    }

    @Test
    void testAllDijkstra10Vertices() {
        int vertices = 10;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        Graph graph = new Graph(vertices, edges);

        int[][] dParents = new int[vertices][vertices];
        int[][] dCosts = new int[vertices][vertices];
        graph.initALLDijkstraOrBellman(dParents, dCosts);
        graph.getAllDijkstra(dParents, dCosts);


        assertEquals(0, dCosts[0][0]);
        assertEquals(1, dCosts[0][1]);
        assertEquals(3, dCosts[0][2]);
        assertEquals(3, dCosts[0][3]);
        assertEquals(4, dCosts[0][4]);
        assertEquals(9, dCosts[0][5]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][6]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][7]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][8]);
        assertEquals(Integer.MAX_VALUE, dCosts[0][9]);

        assertEquals(-1, dParents[0][0]);
        assertEquals(0, dParents[0][1]);
        assertEquals(1, dParents[0][2]);
        assertEquals(0, dParents[0][3]);
        assertEquals(3, dParents[0][4]);
        assertEquals(4, dParents[0][5]);
        assertEquals(-2, dParents[0][6]);
        assertEquals(-2, dParents[0][7]);
        assertEquals(-2, dParents[0][8]);
        assertEquals(-2, dParents[0][9]);
    }
}
