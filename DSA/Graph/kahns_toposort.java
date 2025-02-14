package DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kahns_toposort {
    public static void main(String[] args) {
        // Example graph edges (Directed)
        int[][] edges = {
            {5, 0}, {5, 2}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };
        
        int V = 6; // Number of vertices
        ArrayList<Integer> topoOrder = BFSKahnTopo(edges, V);
        
        // Output the topological order if no cycle
        if (topoOrder.isEmpty()) {
            System.out.println("The graph has a cycle and topological sort is not possible.");
        } else {
            System.out.println("Topological Sort: " + topoOrder);
        }
    }

    public static ArrayList<Integer> BFSKahnTopo(int[][]edges, int V)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[V];
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
          int u=edge[0];
          int v=edge[1];
          adj.get(u).add(v);
          indegree[v]++;
        }
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
               q.add(i);
            }
        }
        ArrayList<Integer> topoOrder=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.poll();
            topoOrder.add(node);
            for(int edge:adj.get(node))
            {
               indegree[edge]--;
               if(indegree[edge]==0)
               q.offer(edge);
            }
        }
        if (topoOrder.size() != V) {
            System.out.println("The graph has a cycle.");
            return new ArrayList<>();
        }

          return topoOrder;

    }
}
