class Solution {
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
     
        List<List<Integer>>lst=new ArrayList<>();
        
        for(int i=0;i<=edges.length;++i){
            
            lst.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i){
            
            if(i==edges[i]||edges[i]==-1){
                
                continue;
            }
            lst.get(i).add(edges[i]);
            //lst.add(i,edges[i]);
        }
        
        int dp[]=new int[edges.length];
        
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        dp[node1]=0;
        
        //Finding the distance from the node1 to all the nodes 
        
        Queue<Integer>Q=new LinkedList<>();
        
        Q.add(node1);
        
        while(Q.size()!=0){
            
            int remove=Q.remove();
            
         //   System.out.println(remove);
            
            for(int elements:lst.get(remove)){
                
                if(dp[elements]==Integer.MAX_VALUE){
                    
                    dp[elements]=dp[remove]+1;
                    
                    Q.add(elements);
                }
            }
        }
        
        int dp1[]=new int[edges.length];
        
        Arrays.fill(dp1,Integer.MAX_VALUE);
        
        Q.clear();
        
        Q.add(node2);
        
        dp1[node2]=0;
        
        while(Q.size()!=0){
            
            int remove=Q.remove();
        
            for(int elements:lst.get(remove)){
                
                if(dp1[elements]==Integer.MAX_VALUE){
                
                    
                    dp1[elements]=dp1[remove]+1;
                    
                    Q.add(elements);
                }
            }
            
        }
        
        int answer=Integer.MAX_VALUE;
        
      
        
        int index=-1;
        
        
        for(int i=0;i<dp1.length;++i){
            
            if(dp[i]!=Integer.MAX_VALUE&&dp1[i]!=Integer.MAX_VALUE){
                
                 if(answer>Math.max(dp[i],dp1[i])){
                     
                     answer=Math.max(dp[i],dp1[i]);
                     
                     index=i;
                 }
            }
        }
        return index;
        
        
        
        
    }
}