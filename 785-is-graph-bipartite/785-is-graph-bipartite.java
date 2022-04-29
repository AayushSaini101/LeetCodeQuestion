class Solution {
  static boolean bipartite(int graph[][],int dp[],int index){
      Queue<Integer>Q=new LinkedList<>();
      dp[index]=1;
      Q.add(index);
      while(Q.size()!=0){
      int remove=Q.remove();
        for(int child:graph[remove]){
            if(dp[child]==-1){
                dp[child]=1-dp[remove];
                Q.add(child);
            }
            else 
                if(dp[child]==dp[remove]){
                    return false;
                }
        }
      }
      return true;
  }
    public boolean isBipartite(int[][] graph) {
        
     int dp[]=new int[graph.length];
     Arrays.fill(dp,-1);
     for(int i=0;i<graph.length;++i){
         if(dp[i]==-1){
             if(bipartite(graph,dp,i)==false){
                 return false;
             }
         }
     }
        return true;
        
    }
}