package DSA.Graph;

import java.util.*;

public class isBipartiteDFS {
    
    // Function to check if the graph is bipartite using DFS
    boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] color = new int[V];
        Arrays.fill(color, -1); // Initialize all nodes as uncolored (-1)
        
        for (int i = 0; i < V; i++) { // Handle disconnected components
            if (color[i] == -1) { // If the node is uncolored, apply DFS
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    // DFS function to check bipartiteness
    boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col; // Assign the current node a color (0 or 1)

        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) { // If the neighbor is uncolored, color it with the opposite color
                if (!dfs(neighbor, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[neighbor] == col) { // If the neighbor has the same color, the graph is not bipartite
                return false;
            }
        }
        return true;
    }

    // Main function to take user input and check if the graph is bipartite
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // Since it's an undirected graph
        }

        isBipartiteDFS graph = new isBipartiteDFS();
        if (graph.isBipartite(adj, V)) {
            System.out.println("The graph is Bipartite.");
        } else {
            System.out.println("The graph is NOT Bipartite.");
        }

        sc.close();
    }
}
// 0 based index the nodes