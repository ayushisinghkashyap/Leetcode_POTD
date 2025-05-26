import java.util.*; // Imports useful utility classes like List, ArrayList, etc.

class Solution {
    private List<List<Integer>> graph; // Represents the graph using an adjacency list.
    private String colors; // Stores the color of each node.
    private int[][] dp; // dp[i][c] stores the max count of color 'c' in a path starting from node 'i'.
    private int[] visited; // Tracks the state of nodes during DFS (0: unvisited, 1: visiting, 2: visited).

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length(); // Number of nodes in the graph.
        this.colors = colors; // Assign the input colors to the class variable.
        this.graph = new ArrayList<>(); // Initialize the graph's adjacency list.
        this.dp = new int[n][26]; // Initialize the DP table (26 colors - a to z).
        this.visited = new int[n]; // Initialize the 'visited' array.

        // Initialize the graph (adjacency list)
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // Add an empty list for each node in the graph.
        }

        // Populate the graph based on the input 'edges'
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1]; // 'u' -> 'v' is an edge.
            graph.get(u).add(v); // Add 'v' to the adjacency list of 'u'.
        }

        int maxColorValue = 0; // The result we're trying to find.
        for (int i = 0; i < n; i++) {
            // Only process unvisited nodes
            if (visited[i] == 0) {
                if (hasCycleAndUpdateDP(i)) {
                    return -1; // Cycle detected, return -1. \U0001f635‍\U0001f4ab
                }
            }

            // Iterate over all colors to find the maximum
            for (int c = 0; c < 26; c++) {
                maxColorValue = Math.max(maxColorValue, dp[i][c]); // Update maxColorValue
            }
        }
        return maxColorValue; // Return the maximum count of any single color in a valid path. \U0001f389
    }

    // DFS to detect cycles and update the DP table
    private boolean hasCycleAndUpdateDP(int node) {
        if (visited[node] == 1) return true; // Back edge detected - cycle! \U0001f6a8
        if (visited[node] == 2) return false; // Node already fully processed. ✅

        visited[node] = 1; // Mark node as "visiting" (in the current path).

        // Explore neighbors using DFS
        for (int neighbor : graph.get(node)) {
            if (hasCycleAndUpdateDP(neighbor)) {
                return true; // Cycle detected. ↩️
            }

            // Update the DP table based on the results from neighbors
            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], dp[neighbor][c]);
            }
        }

        // Increment count of current color for current node
        int currentColor = colors.charAt(node) - 'a';
        dp[node][currentColor]++; // Increase the count of this node's color in the dp table
        
        visited[node] = 2; // Mark the node as "visited" (fully processed).
        return false; // No cycle detected. \U0001f60c
    }
}