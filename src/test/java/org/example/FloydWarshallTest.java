package org.example;

import org.example.ShortestPathsAlgoritms.Graph;
import org.example.ShortestPathsAlgoritms.edge;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FloydWarshallTest {
    @Test
    void testFloydWarshall() {
        int vertices = 3;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 2, 3));
        edges.add(new edge(2, 0, 4));
        edges.add(new edge(1, 0, 2));
        edges.add(new edge(2, 1, 1));
        Graph graph = new Graph(vertices, edges);
        int[][] distances = new int[vertices][vertices];
        int[][] next = new int[vertices][vertices];
        graph.initFloydWarshall(distances,next);
        boolean result = graph.floydWarshall(distances, next);
        assertTrue(result);
        assertEquals(0, distances[0][0]);
        assertEquals(1, distances[0][1]);
        assertEquals(3, distances[0][2]);

        StringBuilder path = graph.floydWarshallFindPath(0, 2, distances, next);
        assertNotNull(path);
        assertEquals("0 -> 2", path.toString()); // Updated expected path due to added edges
    }

    @Test
    void testFloydWarshall2() {
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

        int[][] distances = new int[vertices][vertices];
        int[][] next = new int[vertices][vertices];
        graph.initFloydWarshall(distances,next);

        boolean result = graph.floydWarshall(distances, next);

        assertTrue(result);
        assertEquals(0, distances[0][0]);
        assertEquals(4, distances[0][1]);
        assertEquals(5, distances[0][2]);
        assertEquals(5, distances[0][3]);
        assertEquals(7, distances[0][4]);
        assertEquals(Integer.MAX_VALUE, distances[0][5]); // distance to unreachable node 5 should be MAX_VALUE

        StringBuilder path = graph.floydWarshallFindPath(4, 2, distances, next);
        assertNotNull(path);
        assertEquals("4 -> 3 -> 2", path.toString());
    }


    @Test
    void testFloydWarshall8Vertices() {
        int vertices = 8;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        Graph graph = new Graph(vertices, edges);

        int[][] distances = new int[vertices][vertices];
        int[][] next = new int[vertices][vertices];
        graph.initFloydWarshall(distances,next);

        boolean result = graph.floydWarshall(distances, next);

        assertTrue(result);
        assertEquals(0, distances[0][0]);
        assertEquals(1, distances[0][1]);
        assertEquals(3, distances[0][2]);
        assertEquals(3, distances[0][3]);
        assertEquals(4, distances[0][4]);
        assertEquals(9, distances[0][5]);
        assertEquals(Integer.MAX_VALUE, distances[0][6]);
        assertEquals(Integer.MAX_VALUE, distances[0][7]);

        StringBuilder path = graph.floydWarshallFindPath(0, 5, distances, next);
        assertNotNull(path);
        assertEquals("0 -> 3 -> 4 -> 5", path.toString());
    }


    @Test
    void testFloydWarshall9Vertices() {
        int vertices = 9;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        Graph graph = new Graph(vertices, edges);

        int[][] distances = new int[vertices][vertices];
        int[][] next = new int[vertices][vertices];
        graph.initFloydWarshall(distances,next);

        boolean result = graph.floydWarshall(distances, next);

        assertTrue(result);
        assertEquals(0, distances[0][0]);
        assertEquals(1, distances[0][1]);
        assertEquals(3, distances[0][2]);
        assertEquals(3, distances[0][3]);
        assertEquals(4, distances[0][4]);
        assertEquals(9, distances[0][5]);
        assertEquals(Integer.MAX_VALUE, distances[0][6]);
        assertEquals(Integer.MAX_VALUE, distances[0][7]);
        assertEquals(Integer.MAX_VALUE, distances[0][8]);

        StringBuilder path = graph.floydWarshallFindPath(0, 5, distances, next);
        assertNotNull(path);
        assertEquals("0 -> 3 -> 4 -> 5", path.toString());
    }

    @Test
    void testFloydWarshall10Vertices() {
        int vertices = 10;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(0, 3, 3));
        edges.add(new edge(2, 3, 2));
        edges.add(new edge(3, 4, 1));
        edges.add(new edge(4, 5, 5));
        Graph graph = new Graph(vertices, edges);

        int[][] distances = new int[vertices][vertices];
        int[][] next = new int[vertices][vertices];
        graph.initFloydWarshall(distances,next);

        boolean result = graph.floydWarshall(distances, next);

        assertTrue(result);
        assertEquals(0, distances[0][0]);
        assertEquals(1, distances[0][1]);
        assertEquals(3, distances[0][2]);
        assertEquals(3, distances[0][3]);
        assertEquals(4, distances[0][4]);
        assertEquals(9, distances[0][5]);
        assertEquals(Integer.MAX_VALUE, distances[0][6]);
        assertEquals(Integer.MAX_VALUE, distances[0][7]);
        assertEquals(Integer.MAX_VALUE, distances[0][8]);
        assertEquals(Integer.MAX_VALUE, distances[0][9]);

        StringBuilder path = graph.floydWarshallFindPath(0, 5, distances, next);
        assertNotNull(path);
        assertEquals("0 -> 3 -> 4 -> 5", path.toString());
    }

    @Test
    void testFloydWarshallWithDisconnectedGraph() {
        int vertices = 4;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(2, 3, 3));
        Graph graph = new Graph(vertices, edges);

        int[][] distances = new int[vertices][vertices];
        int[][] next = new int[vertices][vertices];
        graph.initFloydWarshall(distances,next);

        boolean result = graph.floydWarshall(distances, next);

        assertTrue(result);
        assertEquals(0, distances[0][0]);
        assertEquals(1, distances[0][1]);
        assertEquals(3, distances[0][2]);
        assertEquals(6, distances[0][3]);

        StringBuilder path = graph.floydWarshallFindPath(0, 2, distances, next);
        assertNotNull(path);
        assertEquals("0 -> 1 -> 2", path.toString());
    }

    @Test
    void testFloydWarshallWithNegativeWeightCycle() {
        int vertices = 3;
        ArrayList<edge> edges = new ArrayList<>();
        edges.add(new edge(0, 1, 1));
        edges.add(new edge(1, 2, 2));
        edges.add(new edge(2, 0, -5)); // introducing a negative weight cycle
        Graph graph = new Graph(vertices, edges);

        int[][] distances = new int[vertices][vertices];
        int[][] next = new int[vertices][vertices];
        graph.initFloydWarshall(distances,next);

        boolean result = graph.floydWarshall(distances, next);

        assertFalse(result); // Negative weight cycle detected
    }
}
