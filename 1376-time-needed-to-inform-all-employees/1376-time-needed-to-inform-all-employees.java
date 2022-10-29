class Solution {
    
    class Pair{
        
        int u;
        
        int cost;
        
        Pair(int u,int cost){
            
            this.u=u;
            
            this.cost=cost;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
     List<List<Integer>>lst=new ArrayList<>();
        
     for(int i=0;i<=n;++i){
         
         lst.add(new ArrayList<>());
     }
      
     for(int i=0;i<manager.length;++i){
         
         if(manager[i]!=-1)
         
         lst.get(manager[i]).add(i);
     }
        
        Queue<Pair>Q=new LinkedList<>();
        
        Q.add(new Pair(headID,0));
        
        int dp[]=new int[n];
        
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        dp[headID]=0;
        
        while(Q.size()!=0){
            
             int size=Q.size();
            
            for(int i=0;i<size;++i){
                
                Pair ob=Q.remove();
                
                if(lst.get(ob.u).size()==0)continue;
                
                for(int elements:lst.get(ob.u)){
                    
                    if(dp[elements]>informTime[ob.u]+ob.cost){
                        
                        dp[elements]=informTime[ob.u]+ob.cost;
                        
                        Q.add(new Pair(elements,dp[elements]));
                    }
                    
                    
                }
            }
        }
        
    
        int cost=0;
        
        for(int elements:dp){
            
            cost=Math.max(elements,cost);
        }
        
        return cost;
    
        
    
    }
}
