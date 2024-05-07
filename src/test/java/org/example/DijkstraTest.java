package org.example;

import org.example.ShortestPathsAlgoritms.Graph;
import org.example.ShortestPathsAlgoritms.edge;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {
    //    dijkstra
    @Test
    void testDijkstra() {
        int vertices = 3;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        Graph graph = new Graph(vertices, edges);

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        graph.initDijkstraOrBellman(parents, costs);

        graph.Dijkstra(0, parents, costs);
        assertEquals(0, costs[0]);
        assertEquals(1, costs[1]);
        assertEquals(3, costs[2]);
        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
    }
    @Test
    void testDijkstra2() {
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

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        graph.initDijkstraOrBellman(parents, costs);
        graph.Dijkstra(0, parents, costs);

        assertEquals(0, costs[0]);
        assertEquals(4, costs[1]);
        assertEquals(5, costs[2]);
        assertEquals(5, costs[3]);
        assertEquals(7, costs[4]);
        assertEquals(Integer.MAX_VALUE, costs[5]);

        // Check parent array values
        assertEquals(-1, parents[0]); // Parent of node 0 is itself
        assertEquals(0, parents[1]);  // Parent of node 1 is 0
        assertEquals(1, parents[2]);  // Parent of node 2 is 1
        assertEquals(0, parents[3]);  // Parent of node 3 is 3============0-->3
        assertEquals(3, parents[4]);  // Parent of node 4 is 4
        assertEquals(-2, parents[5]); // Node 5 is unreachable
    }

    @Test
    void testDijkstra5Vertices() {
        int vertices = 5;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        Graph graph = new Graph(vertices, edges);

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        graph.initDijkstraOrBellman(parents, costs);
        graph.Dijkstra(0, parents, costs);

        assertEquals(0, costs[0]);
        assertEquals(1, costs[1]);
        assertEquals(3, costs[2]);
        assertEquals(Integer.MAX_VALUE, costs[3]);
        assertEquals(Integer.MAX_VALUE, costs[4]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
        assertEquals(-2, parents[3]);
        assertEquals(-2, parents[4]);
    }


    @Test
    void testDijkstra7Vertices() {
        int vertices = 7;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        Graph graph = new Graph(vertices, edges);

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        graph.initDijkstraOrBellman(parents, costs);
        graph.Dijkstra(0, parents, costs);

        assertEquals(0, costs[0]);
        assertEquals(1, costs[1]);
        assertEquals(3, costs[2]);
        assertEquals(Integer.MAX_VALUE, costs[3]);
        assertEquals(Integer.MAX_VALUE, costs[4]);
        assertEquals(Integer.MAX_VALUE, costs[5]);
        assertEquals(Integer.MAX_VALUE, costs[6]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
        assertEquals(-2, parents[3]);
        assertEquals(-2, parents[4]);
        assertEquals(-2, parents[5]);
        assertEquals(-2, parents[6]);
    }

    @Test
    void testDijkstra8Vertices() {
        int vertices = 8;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        edges.add(new edge(5, 6, 3));
        edges.add(new edge(6, 7, 2));
        Graph graph = new Graph(vertices, edges);

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        graph.initDijkstraOrBellman(parents, costs);
        graph.Dijkstra(0, parents, costs);

        assertEquals(0, costs[0]);
        assertEquals(1, costs[1]);
        assertEquals(3, costs[2]);
        assertEquals(3, costs[3]);
        assertEquals(4, costs[4]);
        assertEquals(9, costs[5]);
        assertEquals(12, costs[6]);
        assertEquals(14, costs[7]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
        assertEquals(0, parents[3]);
        assertEquals(3, parents[4]);
        assertEquals(4, parents[5]);
        assertEquals(5, parents[6]);
        assertEquals(6, parents[7]);
    }

    @Test
    void testDijkstra9Vertices() {
        int vertices = 9;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        edges.add(new edge(5, 6, 3));
        edges.add(new edge(6, 7, 2));
        edges.add(new edge(7, 8, 1));
        Graph graph = new Graph(vertices, edges);

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        graph.initDijkstraOrBellman(parents, costs);
        graph.Dijkstra(0, parents, costs);

        assertEquals(0, costs[0]);
        assertEquals(1, costs[1]);
        assertEquals(3, costs[2]);
        assertEquals(3, costs[3]);
        assertEquals(4, costs[4]);
        assertEquals(9, costs[5]);
        assertEquals(12, costs[6]);
        assertEquals(14, costs[7]);
        assertEquals(15, costs[8]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
        assertEquals(0, parents[3]);
        assertEquals(3, parents[4]);
        assertEquals(4, parents[5]);
        assertEquals(5, parents[6]);
        assertEquals(6, parents[7]);
        assertEquals(7, parents[8]);
    }

    @Test
    void testDijkstra10Vertices() {
        int vertices = 10;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        edges.add(new edge(5, 6, 3));
        edges.add(new edge(6, 7, 2));
        edges.add(new edge(7, 8, 1));
        edges.add(new edge(8, 9, 4));
        Graph graph = new Graph(vertices, edges);

        int[] parents = new int[vertices];
        int[] costs = new int[vertices];
        graph.initDijkstraOrBellman(parents, costs);
        graph.Dijkstra(0, parents, costs);

        assertEquals(0, costs[0]);
        assertEquals(1, costs[1]);
        assertEquals(3, costs[2]);
        assertEquals(3, costs[3]);
        assertEquals(4, costs[4]);
        assertEquals(9, costs[5]);
        assertEquals(12, costs[6]);
        assertEquals(14, costs[7]);
        assertEquals(15, costs[8]);
        assertEquals(19, costs[9]);

        assertEquals(-1, parents[0]);
        assertEquals(0, parents[1]);
        assertEquals(1, parents[2]);
        assertEquals(0, parents[3]);
        assertEquals(3, parents[4]);
        assertEquals(4, parents[5]);
        assertEquals(5, parents[6]);
        assertEquals(6, parents[7]);
        assertEquals(7, parents[8]);
        assertEquals(8, parents[9]);
    }

}
