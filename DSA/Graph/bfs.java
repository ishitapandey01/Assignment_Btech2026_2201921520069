package DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initializing adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(4);
        adj.get(3).add(4);

        bfs obj = new bfs();
        ArrayList<Integer> bfsResult = obj.bfsOfGraph(V, adj);

        // Print BFS traversal
        System.out.println("BFS Traversal: " + bfsResult);
    }
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int visited[]=new int[V];
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue <Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=1;
        
        while(!q.isEmpty())
        {
            int cur=q.poll();
            bfs.add(cur);
            
            for(int i:adj.get(cur))
            {
                if(visited[i]!=1)
                {
                    visited[i]=1;
                   q.add(i);
                }
            }
        }
        return bfs;
    }
    
}
