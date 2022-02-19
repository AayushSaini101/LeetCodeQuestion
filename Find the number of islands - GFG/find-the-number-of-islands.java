// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
     public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean visited[][] = new boolean[n][m];
        int islandCount = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j, n, m);
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    public void bfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        
        if (i >= n || i < 0 || j >= m || j < 0 || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        bfs(grid, visited, i+1, j, n, m);
        bfs(grid, visited, i-1, j, n, m);
        bfs(grid, visited, i+1, j+1, n, m);
        bfs(grid, visited, i-1, j-1, n, m);
        bfs(grid, visited, i-1, j+1, n, m);
        bfs(grid, visited, i+1, j-1, n, m);
        bfs(grid, visited, i, j+1, n, m);
        bfs(grid, visited, i, j-1, n, m);
    }

}