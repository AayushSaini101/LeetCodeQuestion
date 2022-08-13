class Solution {
    public int findLongestChain(int[][] arr) {
     
          
       int dp[]=new int[arr.length];
       
       Arrays.fill(dp,1);
       
       //Can be choosed any set of pairs 
       
       Arrays.sort(arr,(a,b)->a[0]-b[0]);
       
       int max=1;
       
       
       for(int i=0;i<arr.length;++i){
           
           for(int j=0;j<=i;++j){
               
               
               if(arr[j][1]<arr[i][0]){
                   
            
                  dp[i]=Math.max(dp[j]+1,dp[i]);
                   
                   max=Math.max(max,dp[i]);
               }
           }
       }
       
 
       
       return max;
    }
}