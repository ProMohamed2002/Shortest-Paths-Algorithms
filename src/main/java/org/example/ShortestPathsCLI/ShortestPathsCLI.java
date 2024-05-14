package org.example.ShortestPathsCLI;

import org.example.ShortestPathsAlgoritms.Graph;
import org.example.ShortestPathsAlgoritms.GraphFileReader;
import org.example.ShortestPathsAlgoritms.edge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestPathsCLI extends Emojis implements IShortestPathsCLI {
//    source node
    private int source;
//    costs
    private int[] costs;
//    parents
    private int[] parents;
//    all costs
    private int[][] allCosts;
//    all parents
    private int[][] allParents;
//    all next
    private int[][] next;

//    graph
    private Graph graph;

    private boolean isValid (int end, int choice) {
        return choice >= 1 && choice <= end;
    }

    @Override
    public void intro() {
        System.out.println(I+I+I+" Welcome in Shortest Paths Algorithms Program "+I+I+I);
    }

    @Override
    public void prelude() throws IOException {
        while (true) {
            System.out.println("\n1-Read graph file path " + F);
            System.out.println("2-Exit " + exit);
            System.out.print("Input number from 1 " + to + " 2: ");

            Scanner sc = new Scanner(System.in);
            int choice0 = sc.nextInt();

            if (isValid(2, choice0)) {
                if (choice0 == 2) {
                    System.out.println("\nBye bye " + bye);
                    System.exit(0);
                }
//            read file
                read_file();
            } else
                System.out.println("\nChoice not valid" + ex);
        }
    }

    private void read_file() throws IOException {
        System.out.println("\nInput graph file path " + F + " :");
        Scanner sc = new Scanner(System.in);
//        get graph file path
        String filePath = sc.nextLine();
//        make object of graph
        graph = new Graph(filePath);
//        go to main menu
        main_menu();
    }


    @Override
    public void main_menu() {
        while (true) {
//        main menu
            System.out.println("\n1-Shortest path from node to all other nodes " + A);
            System.out.println("2-Shortest path between all pairs " + B);
            System.out.println("3-Check negative cycles " + C);
            System.out.println("4-Go back " + back);
            System.out.print("Input number from 1 " + to + " 4: ");

            Scanner sc = new Scanner(System.in);
            int choice1 = sc.nextInt();

//            check is valid choice
            if (isValid(4, choice1)) {
                if(choice1 == 4)
                    return;

                first_sub_menu(choice1);
            }
            else
                System.out.println("\nChoice not valid" + ex);
        }

    }

    @Override
    public void first_sub_menu(int choice1) {
        Scanner sc = new Scanner(System.in);
        int choice2;
        switch (choice1) {
            case 1 -> {
                System.out.print("\nInput source node " + S + " : ");
//                   Source node
                source = sc.nextInt();

                System.out.println("\n1-Dijkstra " + fast);
                System.out.println("2-Bellman-Ford " + intermediate);
                System.out.println("3-Floyd-Warshall " + slow);
                System.out.println("4-Go back " + back);
                System.out.print("Input number from 1 " + to + " 4: ");
                choice2 = sc.nextInt();
                if (isValid(4, choice2)) {
                    if (choice2 == 4)
                        return;

                    switch (choice2) {
                        case 1 -> {
                            parents = new int[graph.getSize()];
                            costs = new int[graph.getSize()];
//                            initialize parents and costs
                            graph.initDijkstraOrBellman(parents, costs);


//                            apply algorithm
                            graph.Dijkstra(source, parents, costs);
                            System.out.println(Arrays.toString(costs));
                        }
                        case 2 -> {
                            parents = new int[graph.getSize()];
                            costs = new int[graph.getSize()];
//                            initialize parents and costs
                            graph.initDijkstraOrBellman(parents, costs);
//                            apply algorithm
                            graph.BellmanFord(source, parents, costs);
                        }
                        case 3 -> {
                            next = new int[graph.getSize()][graph.getSize()];
                            allCosts = new int[graph.getSize()][graph.getSize()];
//                            initialize parents and costs
                            graph.initFloydWarshall(allCosts, next);
//                            apply algorithm
                            graph.floydWarshall(allCosts, next);
                        }
                    }

                    second_sub_menu(choice1, choice2);
                } else
                    System.out.println("\nChoice not valid" + ex);
            }
            case 2 -> {
                System.out.println("\n1-Dijkstra " + intermediate);
                System.out.println("2-Bellman-Ford " + slow);
                System.out.println("3-Floyd-Warshall " + fast);
                System.out.println("4-Go back " + back);
                System.out.print("Input number from 1 " + to + " 4: ");
                choice2 = sc.nextInt();
                if (isValid(4, choice2)) {
                    if (choice2 == 4)
                        return;
//                       apply algorithm
                    switch (choice2) {
                        case 1 -> {
                            allParents = new int[graph.getSize()][graph.getSize()];
                            allCosts = new int[graph.getSize()][graph.getSize()];
//                            initialize parents and costs
                            graph.initALLDijkstraOrBellman(allParents, allCosts);
//                            apply algorithm
                            graph.getAllDijkstra(allParents, allCosts);
                        }
                        case 2 -> {
                            allParents = new int[graph.getSize()][graph.getSize()];
                            allCosts = new int[graph.getSize()][graph.getSize()];
//                            initialize parents and costs
                            graph.initALLDijkstraOrBellman(allParents, allCosts);
//                            apply algorithm
                            graph.getAllBellmanFord(allParents, allCosts);
                        }
                        case 3 -> {
                            next = new int[graph.getSize()][graph.getSize()];
                            allCosts = new int[graph.getSize()][graph.getSize()];
//                            initialize parents and costs
                            graph.initFloydWarshall(next, allCosts);
//                            apply algorithm
                            graph.floydWarshall(allCosts, next);
                        }
                    }
                    second_sub_menu(choice1 ,choice2);
                } else
                    System.out.println("\nChoice not valid" + ex);
            }
            case 3 -> {
                System.out.println("\n1-Bellman-Ford " + intermediate);
                System.out.println("2-Floyd-Warshall " + fast);
                System.out.println("3-Go back " + back);
                System.out.print("Input number from 1 " + to + " 3: ");
                choice2 = sc.nextInt();
                if (isValid(3, choice2)) {
                    if (choice2 == 3)
                        return;
//                       apply algorithm
                    switch (choice2) {
                        case 1 -> {
                            if (graph.checkNegativeCycleBellmanFord())
                                System.out.println("Graph hasn't negative cycles");
                            else
                                System.out.println("Graph has negative cycles");
                        }
                        case 2 -> {
                            next = new int[graph.getSize()][graph.getSize()] ;
                            allCosts = new int[graph.getSize()][graph.getSize()];
//                            initialize parents and costs
                            graph.initFloydWarshall(allCosts, next);
                            if (graph.floydWarshall(allCosts, next))
                                System.out.println("Graph hasn't negative cycles");
                            else
                                System.out.println("Graph has negative cycles");
                        }
                    }
                } else
                    System.out.println("\nChoice not valid" + ex);
            }
        }
    }

    @Override
    public void second_sub_menu(int choice1, int choice2) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n1-Cost of path " + cost);
            System.out.println("2-Path " + path);
            System.out.println("3-Go back " + back);
            System.out.print("Input number from 1 " + to + " 3: ");

            int choice3 = sc.nextInt();
            if (isValid(3, choice3)) {
                if (choice3 == 3) {
                    System.out.println();
                    return;
                }
                second_sub_menu_handle(choice1, choice2, choice3);
            }
            else
                System.out.println("\nChoice not valid" + ex);
        }
    }

    private void second_sub_menu_handle(int choice1, int choice2, int choice3) {
        Scanner sc = new Scanner(System.in);
        switch (choice3) {
            case 1 -> {
                switch (choice1) {
                    case 1 -> {
                        System.out.print("\nInput destination node " + Des + " : ");
                        int destination = sc.nextInt();
                        if (choice2 == 3)
                            System.out.println("Cost from " + source + " to " + destination + " : " + graph.findCost(destination, allCosts[source]));
                        else
                            System.out.println("Cost from " + source + " to " + destination + " : " + graph.findCost(destination, costs));
                    }
                    case 2 -> {
                        System.out.print("\nInput source node " + S + " : ");
                        source = sc.nextInt();
                        System.out.print("\nInput destination node " + Des + " : ");
                        int destination = sc.nextInt();
                        System.out.println("Cost from " + source + " to " + destination + " : " + graph.findCost(destination, allCosts[source]));
                    }
                }
            }
            case 2 -> {
                switch (choice1) {
                    case 1 -> {
                        System.out.print("\nInput destination node " + Des + " : ");
                        int destination = sc.nextInt();
                        if (choice2 == 3)
                            System.out.println("Path from " + source + " to " + destination + " : " + graph.floydWarshallFindPath(source, destination, allCosts, next));
                        else
                            System.out.println("Path from " + source + " to " + destination + " : " + graph.DijkstraOrBellmanFindPath(destination, parents));
                    }
                    case 2 -> {
                        System.out.print("\nInput source node " + S + " : ");
                        source = sc.nextInt();
                        System.out.print("\nInput destination node " + Des + " : ");
                        int destination = sc.nextInt();
                        if (choice2 == 3)
                            System.out.println("Path from " + source + " to " + destination + " : " + graph.floydWarshallFindPath(source, destination, allCosts, next));
                        else
                            System.out.println("Path from " + source + " to " + destination + " : " + graph.DijkstraOrBellmanFindPath(destination, allParents[source]));
                    }
                }
            }
        }
    }

    @Override
    public void run() throws IOException {
        intro();
        prelude();
    }
}
