package org.example;

import org.example.ShortestPathsAlgoritms.Graph;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {
//    test negative cycle between bellman ford and floyd warshall
    @Test
    void compareBellmanFordAndFloydWarshallNegativeCycle1 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph test1.txt");
        int[][] next = new int[graph.getSize()][graph.getSize()];
        int[][] costs = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(costs, next);

        assertEquals(graph.checkNegativeCycleBellmanFord(), graph.floydWarshall(costs, next));
    }

    @Test
    void compareBellmanFordAndFloydWarshallNegativeCycle2 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph test2.txt");
        int[][] next = new int[graph.getSize()][graph.getSize()];
        int[][] costs = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(costs, next);

        assertEquals(graph.checkNegativeCycleBellmanFord(), graph.floydWarshall(costs, next));
    }

    @Test
    void compareBellmanFordAndFloydWarshallNegativeCycle3 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph test3.txt");
        int[][] next = new int[graph.getSize()][graph.getSize()];
        int[][] costs = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(costs, next);

        assertEquals(graph.checkNegativeCycleBellmanFord(), graph.floydWarshall(costs, next));
    }

    @Test
    void compareBellmanFordAndFloydWarshallNegativeCycle4 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph test4.txt");
        int[][] next = new int[graph.getSize()][graph.getSize()];
        int[][] costs = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(costs, next);

        assertEquals(graph.checkNegativeCycleBellmanFord(), graph.floydWarshall(costs, next));
    }

//    test costs between dijkstra, bellman ford, floyd warshall
    @Test
    void compareDijkstraBellmanFordFloydWarshallCosts () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph1.txt");
        int[][] fwNext = new int[graph.getSize()][graph.getSize()];
        int[][] fwCosts = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(fwCosts, fwNext);

        int[] dParents = new int[graph.getSize()];
        int[] dCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(dParents, dCosts);

        int[] bfParents = new int[graph.getSize()];
        int[] bfCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(bfParents, bfCosts);

        graph.Dijkstra(0, dParents, dCosts);
        graph.BellmanFord(0, bfParents, bfCosts);
        graph.floydWarshall(fwCosts, fwNext);

        assertEquals(graph.findCost(5, dCosts), graph.findCost(5, bfCosts), graph.findCost(5, fwCosts[0]));
    }

    @Test
    void compareDijkstraBellmanFordFloydWarshallCosts2 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph6.txt");
        int[][] fwNext = new int[graph.getSize()][graph.getSize()];
        int[][] fwCosts = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(fwCosts, fwNext);

        int[] dParents = new int[graph.getSize()];
        int[] dCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(dParents, dCosts);

        int[] bfParents = new int[graph.getSize()];
        int[] bfCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(bfParents, bfCosts);

        graph.Dijkstra(2, dParents, dCosts);
        graph.BellmanFord(2, bfParents, bfCosts);
        graph.floydWarshall(fwCosts, fwNext);

        assertEquals(graph.findCost(10, dCosts), graph.findCost(10, bfCosts), graph.findCost(10, fwCosts[2]));
    }

    @Test
    void compareDijkstraBellmanFordFloydWarshallCosts3 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph11.txt");
        int[][] fwNext = new int[graph.getSize()][graph.getSize()];
        int[][] fwCosts = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(fwCosts, fwNext);

        int[] dParents = new int[graph.getSize()];
        int[] dCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(dParents, dCosts);

        int[] bfParents = new int[graph.getSize()];
        int[] bfCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(bfParents, bfCosts);

        graph.Dijkstra(11, dParents, dCosts);
        graph.BellmanFord(11, bfParents, bfCosts);
        graph.floydWarshall(fwCosts, fwNext);

        assertEquals(graph.findCost(17, dCosts), graph.findCost(17, bfCosts), graph.findCost(17, fwCosts[11]));
    }

    //    test paths between dijkstra, bellman ford, floyd warshall
    @Test
    void compareDijkstraBellmanFordFloydWarshallPaths () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph1.txt");
        int[][] fwNext = new int[graph.getSize()][graph.getSize()];
        int[][] fwCosts = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(fwCosts, fwNext);

        int[] dParents = new int[graph.getSize()];
        int[] dCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(dParents, dCosts);

        int[] bfParents = new int[graph.getSize()];
        int[] bfCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(bfParents, bfCosts);

        graph.Dijkstra(0, dParents, dCosts);
        graph.BellmanFord(0, bfParents, bfCosts);
        graph.floydWarshall(fwCosts, fwNext);

        assertEquals(graph.DijkstraOrBellmanFindPath(5, dParents).toString(), graph.DijkstraOrBellmanFindPath(5, bfParents).toString(), graph.floydWarshallFindPath(0, 5, fwCosts, fwNext).toString());
    }
    @Test
    void compareDijkstraBellmanFordFloydWarshallPaths2 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph6.txt");
        int[][] fwNext = new int[graph.getSize()][graph.getSize()];
        int[][] fwCosts = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(fwCosts, fwNext);

        int[] dParents = new int[graph.getSize()];
        int[] dCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(dParents, dCosts);

        int[] bfParents = new int[graph.getSize()];
        int[] bfCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(bfParents, bfCosts);

        graph.Dijkstra(2, dParents, dCosts);
        graph.BellmanFord(2, bfParents, bfCosts);
        graph.floydWarshall(fwCosts, fwNext);

        assertEquals(graph.DijkstraOrBellmanFindPath(10, dParents).toString(), graph.DijkstraOrBellmanFindPath(10, bfParents).toString(), graph.floydWarshallFindPath(2, 10, fwCosts, fwNext).toString());
    }
    @Test
    void compareDijkstraBellmanFordFloydWarshallPaths3 () throws IOException {
        Graph graph = new Graph("randomGraphs\\graph11.txt");
        int[][] fwNext = new int[graph.getSize()][graph.getSize()];
        int[][] fwCosts = new int[graph.getSize()][graph.getSize()];
        graph.initFloydWarshall(fwCosts, fwNext);

        int[] dParents = new int[graph.getSize()];
        int[] dCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(dParents, dCosts);

        int[] bfParents = new int[graph.getSize()];
        int[] bfCosts = new int[graph.getSize()];
        graph.initDijkstraOrBellman(bfParents, bfCosts);

        graph.Dijkstra(11, dParents, dCosts);
        graph.BellmanFord(11, bfParents, bfCosts);
        graph.floydWarshall(fwCosts, fwNext);

        assertEquals(graph.DijkstraOrBellmanFindPath(17, dParents).toString(), graph.DijkstraOrBellmanFindPath(17, bfParents).toString(), graph.floydWarshallFindPath(11, 17, fwCosts, fwNext).toString());
    }
}
