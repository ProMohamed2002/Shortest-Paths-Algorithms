package org.example.ShortestPathsAlgoritms;

public class edge {

    private final int from;
    private final int to;
    private final int weight;

    public edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }


    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }
}
