package org.example;

import java.util.Scanner;

public class GraphCLI implements IGraphCLI{

//    emojis
//    intro
    private final String I = Character.toString(0x1F530);
//    file
    private final String F = Character.toString(0x1F4DD);
//    moon
    private final String A = Character.toString(0x1F314);
    private final String B = Character.toString(0x1F313);
    private final String C = Character.toString(0x1F312);
    private final String D = Character.toString(0x1F311);
//    exclamation mark
    private final String ex = Character.toString(0x203C);
//    to
    private final String to = Character.toString(0x27A1);
//    fast
    private final String fast = Character.toString(0x1F680);
//    intermediate
    private final String intermediate = Character.toString(0x2708);
//    slow
    private final String slow = Character.toString(0x1F682);
//    path
    private final String path = Character.toString(0x1F6E3);
//    cost
    private final String cost = Character.toString(0x1F4B0);
//    back
    private final String back = Character.toString(0x1F519);
//    bye
    private final String bye = Character.toString(0x1F44B);

//    source
    private final String S = Character.toString(0x1F697);

//    destination
    private final String Des = Character.toString(0x1F3E0);



//        source node
    private int source;

    private boolean isValid (int end, int choice) {
        return choice >= 1 && choice <= end;
    }

    @Override
    public void intro() {
        System.out.println(I+I+I+" Welcome in Shortest Paths Algorithms Program "+I+I+I);
    }

    private void read_file() {
        System.out.println("\nInput graph file path " + F + " :");
        Scanner sc = new Scanner(System.in);
//        get graph file path
        String pathFile = sc.nextLine();
//        read file

    }


    @Override
    public void main_menu() {
        while (true) {
//        main menu
            System.out.println("\n1-Shortest path from node to all other nodes " + A);
            System.out.println("2-Shortest path between all pairs " + B);
            System.out.println("3-Check negative cycles " + C);
            System.out.println("4-Exit " + D);
            System.out.print("Input number from 1 " + to + " 4: ");

            Scanner sc = new Scanner(System.in);
            int choice1 = sc.nextInt();

//            check is valid choice
            if (isValid(4, choice1)) {
//                Exit
                if(choice1 == 4) {
                    System.out.println("\nBye bye" + bye);
                    System.exit(0);
                }
                first_sub_menu(choice1);
            }
            else
                System.out.println("Choice not valid" + ex);
        }

    }

    @Override
    public void first_sub_menu(int choice) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int choice2;
        switch (choice) {
            case 1 -> {
                System.out.print("Input source node " + S + " : ");
//                   Source node
                source = sc.nextInt();
//               initialize two arrays;
                System.out.println("1-Dijkstra " + fast);
                System.out.println("2-Bellman-Ford " + intermediate);
                System.out.println("3-Floyd-Warshall " + slow);
                System.out.println("4-Go back " + back);
                System.out.print("Input number from 1 " + to + " 4: ");
                choice2 = sc.nextInt();
                if (isValid(4, choice2)) {
                    if (choice2 == 4)
                        return;
//                       apply algorithm
                    second_sub_menu(choice);
                } else
                    System.out.println("Choice not valid" + ex);
            }
            case 2 -> {
//               initialize two matrices;
                System.out.println("1-Dijkstra " + intermediate);
                System.out.println("2-Bellman-Ford " + slow);
                System.out.println("3-Floyd-Warshall " + fast);
                System.out.println("4-Go back " + back);
                System.out.print("Input number from 1 " + to + " 4: ");
                choice2 = sc.nextInt();
                if (isValid(4, choice2)) {
                    if (choice2 == 4)
                        return;
//                       apply algorithm
                    second_sub_menu(choice);
                } else
                    System.out.println("Choice not valid" + ex);
            }
            case 3 -> {
                System.out.println("1-Bellman-Ford " + intermediate);
                System.out.println("2-Floyd-Warshall " + fast);
                System.out.println("3-Go back " + back);
                System.out.print("Input number from 1 " + to + " 3: ");
                choice2 = sc.nextInt();
                if (isValid(3, choice2)) {
                    if (choice2 == 3) {
                        System.out.println();
                        return;
                    }
//                       apply algorithm
                    System.out.println("print there exist negative cycle or not");
                } else
                    System.out.println("Choice not valid" + ex);
            }
        }
    }

    @Override
    public void second_sub_menu(int choice) {
        System.out.println();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1-Cost of path " + cost);
            System.out.println("2-Path " + path);
            System.out.println("3-Go back " + back);
            System.out.print("Input number from 1 " + to + " 3: ");

            int choice3 = sc.nextInt();
            if (isValid(3, choice3)) {
                if (choice3 == 3) {
                    System.out.println();
                    return;
                }
                second_sub_menu_handle(choice, choice3);
            }
            else
                System.out.println("Choice not valid" + ex);
        }
    }

    private void second_sub_menu_handle(int choice1, int choice3) {
        Scanner sc = new Scanner(System.in);
        if (choice1 == 2) {
            System.out.print("Input source node " + S + " : ");
            source = sc.nextInt();
        }
        System.out.print("Input destination node " + Des + " : ");
        int destination = sc.nextInt();
        switch (choice3) {
            case 1 -> {
                System.out.println("print cost of path from source to destination");
            }
            case 2 -> {
                System.out.println("print path from source to destination");
            }
        }

    }

    @Override
    public void run() {
        intro();
        read_file();
        main_menu();
    }
}
