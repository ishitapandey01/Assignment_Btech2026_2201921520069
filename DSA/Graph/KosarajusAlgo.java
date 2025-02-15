package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajusAlgo // to find strongly connected components of graph
{
    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st)
    {
      vis[node]=1;
      for(int neighbor:adj.get(node))
      {
        if(vis[neighbor]==0)
        dfs(neighbor,adj,vis, st);
      }
      st.push(node);
    }
    
    void dfsrev(int node, ArrayList<ArrayList<Integer>> adj, int[] vis)
    {
      vis[node]=1;
      for(int neighbor:adj.get(node))
      {
        if(vis[neighbor]==0)
        dfsrev(neighbor,adj,vis);
      }
   
    }
    public int KosarajusAlgoforSCC(ArrayList<ArrayList<Integer>> adj, int V)
    {
      int vis[]=new int[V];
      Arrays.fill(vis,0);
      Stack<Integer> st=new Stack<>();
      for(int i=0;i<V;i++)
      {
        if(vis[i]==0)
        {
            dfs(i,adj,vis,st);
        }
      }
      ArrayList<ArrayList<Integer>> revadj=new ArrayList<>();
      for(int i=0;i<V;i++)
      {
        revadj.add(new ArrayList<>());
      }
      for (int v = 0; v < V; v++) {
          vis[v]=0;
          for(int u:adj.get(v))
          {
            revadj.get(u).add(v);
          }
      }
      int scc=0;
      while(!st.isEmpty())
      {
        int node=st.pop();
        if(vis[node]==0)
        {
            scc++;
            dfsrev(node,revadj,vis);
        }
      }
      return scc;
    }
    
    public static void main (String[] args) {
        int n = 5;
        int[][] edges = {
            {1, 0}, {0, 2},
            {2, 1}, {0, 3},
            {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        KosarajusAlgo obj = new KosarajusAlgo();
        int ans = obj.KosarajusAlgoforSCC(adj,n);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}

