package org.example.ShortestPathsAlgoritms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphFileReader {
    public static int source;
    public void read (String filePath, Graph graph) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String[] arrayList = reader.readLine().split(" ");
        graph.setVertices(Integer.parseInt(arrayList[0]));
        int edges = Integer.parseInt(arrayList[1]);

        ArrayList<edge> edgeList = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            String[] edgeData = reader.readLine().split(" ");
            int from = Integer.parseInt(edgeData[0]);
            int to = Integer.parseInt(edgeData[1]);
            int weight = Integer.parseInt(edgeData[2]);
            edgeList.add(new edge(from, to, weight));
        }
        reader.close();
        source=edgeList.get(0).getFrom();
        graph.setEdgeList(edgeList);
    }
}
