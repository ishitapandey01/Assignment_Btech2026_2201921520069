package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {

    public boolean isBipartite(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adj.get(i).add(neighbor);
            }
        }

        int[] color=new int[n];
        Arrays.fill(color,-1);
       for (int i = 0; i < n; i++)
        {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;
        
          while(!q.isEmpty())
            {
            int cur=q.poll();
            color[0]=0;
            for(int neighbours:adj.get(cur))
            {

                if(color[neighbours]==-1)
                {
                    color[neighbours]=1-color[cur];
                    q.offer(neighbours);
                }
                else if(color[neighbours]==color[cur])
                return false;
              
            }
         }
        }
      }
        return true;
    }
    public static void main(String args[])
        {
           isBipartite solution = new isBipartite();
            
            // Test case 1
            int[][] graph1 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
            };
            System.out.println("Graph 1 is bipartite: " + solution.isBipartite(graph1));
    
            // Test case 2
            int[][] graph2 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
            };
            System.out.println("Graph 2 is bipartite: " + solution.isBipartite(graph2));
        }
    
}

