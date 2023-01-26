class Solution {
    class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    class Tuple {
        int first, second, third;
        Tuple(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // we need to store the Adjacent nodes and edge weights.
        // so we need Pair.
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        // {stops, {node, dist}}
        q.add(new Tuple(0, src, 0));
        // declear the distance array. with same size n.
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        // distance to source is 0.
        dist[src] = 0;
        // T -> O(n) = E = flights.size().
        while(!q.isEmpty()){
            Tuple it = q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;
            // if stops is greater then k mean no need to go further.
            if(stops > k) continue;
            for(Pair iter: adj.get(node)){
                // Adjacent node.
                int adjNode = iter.first;
                // edge weight.
                int edW = iter.second;
                // if cost + edge weight is < then distance of adjacent node && stops <= k.
                // mean we have to update our distance array.
                if(dist[it.second] + edW < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edW;
                    // increment the stops by 1, 
                    // adjacent node,
                    // cost + edge weight.
                    q.add(new Tuple(stops + 1, adjNode,dist[adjNode] ));
                }
            }
        }
        // if the distance to destination is 1e9 means we never reach so, return -1.
        if(dist[dst] == (int) 1e9) return -1;
        return dist[dst];
    }
}