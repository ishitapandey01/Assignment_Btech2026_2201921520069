package DSA.Graph;

import java.util.*;

public class detectcycleundirected {
    
    // Function to detect cycle in the undirected graph
    boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];  // To track visited nodes
        int[] recurstack = new int[n];  // To track nodes in the recursion stack
        
        // Check every node for a cycle
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {  // If the node hasn't been visited
                if (dfs(i, adj, vis, recurstack, -1)) {  // Start DFS from node i
                    return true;  // Cycle detected
                }
            }
        }
        return false;  // No cycle detected
    }

    // DFS function to detect cycle
    boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] recurstack, int parent) {
        vis[i] = 1;  // Mark the node as visited
        recurstack[i] = 1;  // Add the node to the recursion stack
        
        // Explore the adjacent nodes
        for (int neighbor : adj.get(i)) {
            // If the neighbor hasn't been visited, recurse
            if (vis[neighbor] == 0) {
                if (dfs(neighbor, adj, vis, recurstack, i)) {
                    return true;  // Cycle detected
                }
            }
            // If the neighbor is already visited and is not the parent, cycle detected
            else if (recurstack[neighbor] == 1 && neighbor != parent) {
                return true;  // Cycle detected
            }
        }
        
        // Remove the node from the recursion stack after exploring its neighbors
        recurstack[i] = 0;
        return false;  // No cycle detected for this node
    }
    
    // Main method for testing
    public static void main(String[] args) {
        detectcycleundirected cycleDetect = new detectcycleundirected();
        
        int n = 4;  // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Example graph (0-1, 1-2, 2-3, 3-0 forms a cycle)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);
        
        // Detect cycle in the graph
        if (cycleDetect.isCycle(n, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
    }
}
