import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graph {

    ArrayList<ArrayList<Pair<Integer, Integer>>> adjlist=new ArrayList<ArrayList<Pair<Integer, Integer>>>();
    public Graph(int vertices,ArrayList<edge>edges,String way)
    {
         if(way.equals("Dijkstra"))
         {
             creategraph1(vertices,edges);

         }
    }
    private void creategraph1(int vertices,ArrayList<edge> edges)
    {
        for (int i = 0; i < vertices; i++) {
            adjlist.add(new ArrayList<Pair<Integer,Integer>>());
        }
        int size=edges.size();
        for (int i = 0; i < size; i++) {
            int from=edges.get(i).getFrom();
            int to=edges.get(i).getTo();
            int cost=edges.get(i).getWeight();
            Pair<Integer,Integer> mypair=new Pair<>(to,cost);
            adjlist.get(from).add(mypair);
        }
    }
    public void Dijkstra(int source, int[] parents,int[]costs) //fill the parents -2 for all initially, costs IntMax initially
    {
        boolean []visited=new boolean[costs.length];
        costs[source]=0;
        parents[source]=-1; //first node
        Comparator<int[]> arrayComparator = (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]);
        int []InitialEntry={source,costs[source]};
        PriorityQueue<int[]>queue=new PriorityQueue<>(arrayComparator);
        queue.add(InitialEntry);
        while (!queue.isEmpty())
        {
            int [] entry= queue.poll();

            if (visited[entry[0]]) continue;   //if a node get inserted in queue more than once we will consider its minimum

            //it is guaranteed that a node will be out of queue first time when its right
            // else it will be out if we end our work then we will continue until we end

            int size=adjlist.get(entry[0]).size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> neighbor=adjlist.get(entry[0]).get(i);
                if (costs[neighbor.getFirst()]>costs[entry[0]]+neighbor.getSecond())
                {
                    costs[neighbor.getFirst()]=costs[entry[0]]+neighbor.getSecond();
                    parents[neighbor.getFirst()]=entry[0];
                }
               int[] newInsertion={neighbor.getFirst(),costs[neighbor.getFirst()]};
               queue.add(newInsertion);
            }
            visited[entry[0]]=true;
        }
    }


}
