package org.example;

import org.example.ShortestPathsCLI.IShortestPathsCLI;
import org.example.ShortestPathsCLI.ShortestPathsCLI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IShortestPathsCLI shortestPathsCLI = new ShortestPathsCLI();
        shortestPathsCLI.run();
    }
}