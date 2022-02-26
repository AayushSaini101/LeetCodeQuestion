class Solution {
  
    public int shortestPathLength(int[][] graph) {
       //base case
        int n = graph.length;
        if(n==1) return 0;
        
        int endingMask = (1<<n)-1;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] seen = new boolean[n][endingMask];
        
        
        //enqueue some initial values
        for(int i=0;i<n;i++){
            queue.add(new int[]{i,1<<i});
            seen[i][1<<i] = true;
        }
        
        
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                int node = curr[0];
                int mask = curr[1];
                for(int next:graph[node]){
                    int newmask = mask|(1<<next);
                    if(newmask==endingMask) return steps + 1;
                    
                    if(!seen[next][newmask]){
                        seen[next][newmask]=true;
                        queue.add(new int[]{next,newmask});
                    }
                }
            }
            steps++;
        }
        return 0;
        
    }
}