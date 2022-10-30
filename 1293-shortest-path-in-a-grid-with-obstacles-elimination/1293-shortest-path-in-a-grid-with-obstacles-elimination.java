class Solution {
    int n, m, k;
    int[][] grid;
    
	// direction to go {down, right, up, left}
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    int dijkstra(int sx, int sy, int ex, int ey) {
        boolean[][] isVisited = new boolean[m][n];
        int[][] cost = new int[m][n];
        
        for (int i=0;i<m;i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        
		// PQ prioritized by cost, then obs (obstacle count)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.cost == b.cost) {
                return a.obs - b.obs;
            }
            return a.cost - b.cost;
        });
        pq.add(new Node(sx, sy, 0, 0));
        cost[sy][sx] = 0;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            
            if (isVisited[node.y][node.x]) {
                continue;
            }
            isVisited[node.y][node.x] = true;
            
            for (int i=0;i<4;i++) {
                int tox = node.x + dx[i];
                int toy = node.y + dy[i];
                
                if (tox >= 0 && tox < n && toy >= 0 && toy < m && node.cost + 1 < cost[toy][tox]) {
                    if (grid[toy][tox] == 0) {
                        cost[toy][tox] = node.cost + 1;
                        pq.add(new Node(tox, toy, node.cost + 1, node.obs));
                    } else {
                        if (node.obs + 1 <= k) {
                            cost[toy][tox] = node.cost + 1;
                            pq.add(new Node(tox, toy, node.cost + 1, node.obs + 1));
                        }
                    }
                }
            }
        }
        return cost[ey][ex];
    }
    
    public int shortestPath(int[][] grid, int k) {
        n = grid[0].length;
        m = grid.length;
        this.k = k;
        this.grid = grid;
        
        int r1 = dijkstra(0, 0, n - 1, m - 1); // dijkstra from (0, 0) to (n-1, m-1)
        int r2 = dijkstra(n - 1, m - 1, 0, 0); // dijkstra from (n-1, m-1) to (0, 0)
        int res = Math.min(r1, r2);
        
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
    
    class Node {
        int x, y;
        int cost;
        int obs; // obstacle count
        
        Node(int x, int y, int cost, int obs) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.obs = obs;
        }
    }
}