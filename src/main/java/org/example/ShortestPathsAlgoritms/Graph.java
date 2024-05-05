package org.example.ShortestPathsAlgoritms;

import java.io.IOException;
import java.util.*;

public class Graph {
    private ArrayList<ArrayList<Pair<Integer, Integer>>> adjList;
    private  int vertices;
    private ArrayList<edge> edgeList;

    public Graph (String filePath) throws IOException {
        GraphFileReader graphFileReader = new GraphFileReader();
//        initialize edgeList
        graphFileReader.read(filePath, this);
//        initialize adj list
        initAdjList();
    }

    public Graph (int vertices, ArrayList<edge> edgeList) {
        this.vertices = vertices;
//        initialize edgeList
        this.edgeList = edgeList;
//        initialize adj list
        initAdjList();
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public void setEdgeList(ArrayList<edge> edgeList) {
        this.edgeList = edgeList;
    }

    //    get number of nodes
    public int getSize()
    {
        return vertices;
    }

//    initialize adj list
    private void initAdjList()
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        int size= edgeList.size();
        for (edge edge : edgeList) {
            int from = edge.getFrom();
            int to = edge.getTo();
            int cost = edge.getWeight();
            Pair<Integer, Integer> myPair = new Pair<>(to, cost);
            adjList.get(from).add(myPair);
        }
    }
//    initialize dijkstra or bellman ford
    public void initDijkstraOrBellman (int[] parents, int[]costs) {
        //fill the parents -2 for all initially, costs IntMax initially
        Arrays.fill(parents, -2);
        Arrays.fill(costs, Integer.MAX_VALUE);
    }

    public void initALLDijkstraOrBellman (int[][] parents, int[][] costs) {
        //fill the parents -2 for all initially, costs IntMax initially
        Arrays.stream(parents).forEach(a -> Arrays.fill(a, -2));
        Arrays.stream(costs).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
    }

//    Dijkstra from source to destinations
    public void Dijkstra(int source, int[] parents,int[]costs)
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
            int size= adjList.get(entry[0]).size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> neighbor= adjList.get(entry[0]).get(i);
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

//    Dijkstra between all pairs
    public void getAllDijkstra(int [][]parents,int[][]costs)  // dijkstra all sources to all destinations
    {
        for (int i = 0; i < vertices; i++) {
            Dijkstra(i,parents[i],costs[i]);
        }
    }

//    BellmanFord from source to destinations
   public boolean BellmanFord(int source,int []parents, int[]costs)
   {
        costs[source]=0;
        parents[source]=-1;
        for(int i=1;i<vertices;i++)  //V-1  relaxations
        {
            for (edge x:edgeList) {
                if(costs[x.getFrom()]!=Integer.MAX_VALUE&&costs[x.getTo()]>costs[x.getFrom()]+x.getWeight())
                {
                    costs[x.getTo()]=costs[x.getFrom()]+x.getWeight();
                    parents[x.getTo()]=x.getFrom();
                }

            }
        }
        // A once more relaxation to check
       boolean flag=true;
       for (edge x:edgeList) {
           if(costs[x.getFrom()]!=Integer.MAX_VALUE&&costs[x.getTo()]>costs[x.getFrom()]+x.getWeight())
           {
                  flag=false;
                  break;
           }
       }
       return flag;
   }

//   BellmanFord between all pairs
   public boolean getAllBellmanFord(int[][]parents,int[][]costs)
   {
       boolean AllFlag=true;
       for (int i = 0; i < vertices; i++) {

               AllFlag=AllFlag&&BellmanFord(i,parents[i],costs[i]);
       }
       return AllFlag;
   }

//   Check negative cycle bellman ford
   public boolean checkNegativeCycleBellmanFord() {
       boolean[] visited = new boolean[vertices];
       Arrays.fill(visited, false);
       int[] costs;

       for (int counter=0;counter<vertices;counter++)
       {
           if(visited[counter])
               continue;

       int picked = counter;
       costs = new int[vertices];
       Arrays.fill(costs, Integer.MAX_VALUE);
       costs[picked] = 0;
       visited[picked] = true;
       for (int i = 1; i < vertices; i++)  //V-1  relaxations
       {
           for (edge x : edgeList) {
               if (costs[x.getFrom()] != Integer.MAX_VALUE && costs[x.getTo()] > costs[x.getFrom()] + x.getWeight()) {
                   costs[x.getTo()] = costs[x.getFrom()] + x.getWeight();
                   visited[x.getTo()] = true;
               }

           }
       }
       //Another pass to check
       for (edge x : edgeList) {
           if (costs[x.getFrom()] != Integer.MAX_VALUE && costs[x.getTo()] > costs[x.getFrom()] + x.getWeight()) {
               return false;
           }
       }
   }
       return true;
   }
//   Dijkstra or bellman findPath
    public StringBuilder DijkstraOrBellmanFindPath (int destination,int[]parents)
    {
        StringBuilder path= new StringBuilder();
        int temp=destination;

        if(parents[destination]==-1)
        {
            path.append(destination);
            return path;
        }

        if(parents[temp]>=parents.length||parents[temp]<0)
            return null;
        Stack<Integer>SPath= new Stack<>();
        Set<Integer>distinctnodes=new HashSet<>();
        while (parents[temp]!=-1)
        {
            SPath.add(temp);
            int prev=distinctnodes.size();
            distinctnodes.add(temp);
            int current=distinctnodes.size();
            if(current-prev!=1)
                return null;
            temp=parents[temp];
        }
        SPath.add(temp);
        int prev=distinctnodes.size();
        distinctnodes.add(temp);
        int current=distinctnodes.size();
        if(current-prev!=1)
            return null;
        while (SPath.size()>1)
        {
            path.append(SPath.pop()).append(" -> ");
        }
        path.append(SPath.pop());
        return path;
    }

    public void initFloydWarshall (int [][]costs, int[][]next) {
//        initialize costs
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++) {
                if(i == j)
                    costs[i][j] = 0;
                else
                    costs[i][j] = Integer.MAX_VALUE;
            }
        }

        for (edge edge : edgeList) {
            costs[edge.getFrom()][edge.getTo()] = edge.getWeight();
        }

//        initialize next
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                if(costs[i][j] != Integer.MAX_VALUE)
                    next[i][j] = j;
                else
                    next[i][j] = -1;
            }
        }
    }

//   floyd warshall between all pairs
    public boolean floydWarshall(int [][]costs, int[][]next){
        for(int k = 0; k < vertices; k++){
            for(int i = 0; i < vertices; i++){
                for(int j = 0; j < vertices; j++){
                    if((costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE) && (costs[i][k] + costs[k][j] < costs[i][j])) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        return !checkNegativeCycleFloydWarshall(costs, next);
    }

//    cost from source to destination
    public int findCost(int destination, int[] costs){
        return costs[destination];
    }

//    floyd warshall path from source to destination
    public StringBuilder floydWarshallFindPath(int source, int destination, int[][] costs, int[][]next){
        StringBuilder path = new StringBuilder();
        if(next[source][destination] == -1 || costs[source][destination] == Integer.MIN_VALUE || costs[source][destination] == Integer.MAX_VALUE)
            return null;

        int nextNode = source;
        while(nextNode != destination){
            path.append(nextNode);
            path.append(" -> ");
            nextNode = next[nextNode][destination];
            if(nextNode == -1)
                return null;
        }
        if(next[nextNode][destination] == -1)
            return null;

        path.append(nextNode);
        return path;
    }
//    Check negative cycle floyed warshall
    private boolean checkNegativeCycleFloydWarshall(int[][] costs, int[][]next){
        boolean negativeCycle = false;
        for(int k = 0; k < vertices; k++){
            for(int i = 0; i < vertices; i++){
                for(int j = 0; j < vertices; j++){
                    if((costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE) && (costs[i][k] + costs[k][j] < costs[i][j])) {
                        costs[i][j] = Integer.MIN_VALUE;
                        next[i][j] = -1;
                        negativeCycle = true;
                    }
                }
            }
        }
        return negativeCycle;
    }

}
