import java.util.*;

public class Graph {
    ArrayList<ArrayList<Pair<Integer, Integer>>> adjlist;
    private long[][] adjMatrix;
    private final int vertices;
    private final ArrayList<edge>edges;
    public Graph(int vertices,ArrayList<edge>edges,String way)
    {
        this.vertices = vertices;
        this.edges = edges;
         if(way.equals("Dijkstra"))
         {
             creategraph1();
         }
         else if(way.equals("Floyd"))
             graphInitialize();
        /*If we need bellman ford we will use the edge list only*/
    }
    public int getSize()
    {
        return vertices;
    }
    private void creategraph1()
    {
        adjlist=new ArrayList<ArrayList<Pair<Integer, Integer>>>();
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
    public void getAllDijkstra(int [][]parents,int[][]costs)  // dijkstra all sources to all destinations
    {
        for (int i = 0; i < vertices; i++) {
            Dijkstra(i,parents[i],costs[i]);
        }
    }

   public boolean BellmanFord(int source,int []parents, int[]costs)
   {
        costs[source]=0;
        parents[source]=-1;
        for(int i=1;i<vertices;i++)  //V-1  relaxations
        {
            for (edge x:edges) {
                if(costs[x.getFrom()]!=Integer.MAX_VALUE&&costs[x.getTo()]>costs[x.getFrom()]+x.getWeight())
                {
                    costs[x.getTo()]=costs[x.getFrom()]+x.getWeight();
                    parents[x.getTo()]=x.getFrom();
                }

            }
        }
        // A once more relaxation to check
       boolean flag=true;
       for (edge x:edges) {
           if(costs[x.getFrom()]!=Integer.MAX_VALUE&&costs[x.getTo()]>costs[x.getFrom()]+x.getWeight())
           {
                  flag=false;
                  break;
           }
       }
       return flag;
   }

   public boolean getAllBellmanFord(int[][]parents,int[][]costs)
   {
       boolean AllFlag=true;
       for (int i = 0; i < vertices; i++) {

               AllFlag=AllFlag&&BellmanFord(i,parents[i],costs[i]);
       }
       return AllFlag;

   }

   public boolean Check_NegativeCycle_BellmanFord() {
       boolean[] visited = new boolean[vertices];
       Arrays.fill(visited, false);
       int[] costs;

       for (int counter=0;counter<vertices;counter++)
       {
           if(visited[counter]==true)
               continue;

       int picked = counter;
       costs = new int[vertices];
       Arrays.fill(costs, Integer.MAX_VALUE);
       costs[picked] = 0;
       visited[picked] = true;
       for (int i = 1; i < vertices; i++)  //V-1  relaxations
       {
           for (edge x : edges) {
               if (costs[x.getFrom()] != Integer.MAX_VALUE && costs[x.getTo()] > costs[x.getFrom()] + x.getWeight()) {
                   costs[x.getTo()] = costs[x.getFrom()] + x.getWeight();
                   visited[x.getTo()] = true;
               }

           }
       }
       //Another pass to check
       for (edge x : edges) {
           if (costs[x.getFrom()] != Integer.MAX_VALUE && costs[x.getTo()] > costs[x.getFrom()] + x.getWeight()) {
               return false;
           }
       }
   }
       return true;
   }

    public boolean floyd_warshall(long[][]distances, int[][]next){
        initiate(distances, next);
        for(int k = 0; k < vertices; k++){
            for(int i = 0; i < vertices; i++){
                for(int j = 0; j < vertices; j++){
                    if((distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) && (distances[i][k] + distances[k][j] < distances[i][j])) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        return negativeCycleCheck(distances, next);
    }
    public long floydWarshallFindDistance(int source, int destination, long[][]distances){
        return distances[source][destination];
    }
    public ArrayList<Integer> floydWarshallFindPath(int source, int destination, long[][] distances, int[][]next){
        if(next[source][destination] == -1 || distances[source][destination] == Integer.MIN_VALUE || distances[source][destination] == Integer.MAX_VALUE)
            return null;

        ArrayList<Integer> path = new ArrayList<>();
        int nextNode = source;
        while(nextNode != destination){
            path.add(nextNode);
            nextNode = next[nextNode][destination];
            if(nextNode == -1)
                return null;
        }
        if(next[nextNode][destination] == -1)
            return null;

        path.add(nextNode);
        return path;
    }
    private boolean negativeCycleCheck(long[][] distances, int[][]next){
        boolean negativeCycle = false;
        for(int k = 0; k < vertices; k++){
            for(int i = 0; i < vertices; i++){
                for(int j = 0; j < vertices; j++){
                    if((distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) && (distances[i][k] + distances[k][j] < distances[i][j])) {
                        distances[i][j] = Integer.MIN_VALUE;
                        next[i][j] = -1;
                        negativeCycle = true;
                    }
                }
            }
        }
        return negativeCycle;
    }
    private void initiate(long[][]distances, int[][]next){
        distances = adjMatrix;
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                if(distances[i][j] != Integer.MAX_VALUE)
                    next[i][j] = j;
                else
                    next[i][j] = -1;
            }
        }
    }
    private void graphInitialize(){
        adjMatrix = new long[vertices][vertices];
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++) {
                if(i == j)
                    adjMatrix[i][j] = 0;
                else
                    adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for (edge edge : edges) {
            adjMatrix[edge.getFrom()][edge.getTo()] = edge.getWeight();
        }
    }
    public String generateOnePath(int source,int destination,int[]parents)
    {
        String path="";
        int temp=destination;

        if(parents[temp]>=parents.length||parents[temp]<0)
            return "NO PATH FROM THIS SOURCE TO THAT DESTINATION";
        Stack<Integer>Spath=new Stack<Integer>();
        while (parents[temp]!=-1)
        {
            Spath.add(temp);
            temp=parents[temp];
        }
        Spath.add(temp);
        while (Spath.size()>1)
        {
            path=path+Spath.pop()+" -> ";
        }
          path=path+Spath.pop();
        return path;
    }


}
