package DSA.Graph;

import java.util.*;

 class Edge{
    int src;
    int dest;
    Edge(int src, int dest)
    {
        this.src=src;
        this.dest=dest;
    }
}
public class adjlist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertex");
        int v=sc.nextInt();
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Edge>();
            System.out.println("enter vertices from " +i+" enter -1 -1 to stop");
            while (true) { 
                int src=sc.nextInt();
                int dest=sc.nextInt();

                if(src==-1 || dest==-1) 
                break;
            
            graph[i].add(new Edge(src, dest));
            }
        }
    }
    
}
