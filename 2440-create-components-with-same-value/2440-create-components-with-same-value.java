class Solution {
    public int dfs(List<List<Integer>>lst,int dp[],int parent,int index,int target){
        
        int sum=dp[index];
        
        for(int elements:lst.get(index)){
            
            if(elements!=parent){
        
                sum+=dfs(lst,dp,index,elements,target);
                
            }
        }
        if(sum==target)return 0;
        
        return sum;
    }
    public int componentValue(int[] nums, int[][] edges) {
     
     List<List<Integer>>lst=new ArrayList<>();
        
     for(int i=0;i<=nums.length;++i){
         
         lst.add(new ArrayList<>());
     }
        
     for(int i=0;i<edges.length;++i){
         
         int u=edges[i][0];
         
         int v=edges[i][1];
         
         lst.get(u).add(v);
         
         lst.get(v).add(u);
         
     }
     int sum=0;
        
     for(int elements:nums){
         
         sum+=elements;
     }
    
     //We cannot break any edge from the graph beacause the sum is odd 
        
     if(sum%2==1)return 0;
        
     int max=0;
        
     for(int i=1;i<=nums.length;++i){
         
         if(sum%i!=0)continue;
         
         int value=dfs(lst,nums,-1,0,sum/i);
         
        // System.out.println(value+" "+sum/i);
         
         
         if(value==0){
             
             max=Math.max(max,i-1);
         }
     }
        
        return max;
        
        
    }
}