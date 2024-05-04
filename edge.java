public class edge {

    private int from;
    private int to;
    private int weight;

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
}
