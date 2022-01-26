class Solution {
     //We can do this using the segment tree also
    public int find(int arr[],int start,int end,int k,int dp[]){
        if(start>=end){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int max=0;
        int answer=0;
        for(int i=start;i<start+k&&i<arr.length;++i){
            max=Math.max(max,arr[i]);
            
            int right=find(arr,i+1,end,k,dp);
          
            //This will break the second parth 
            answer=Math.max(answer,max*(i-start+1)+right);
        }
        return dp[start]= answer;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
       
      int dp[]=new int[arr.length+1];
        Arrays.fill(dp,-1);
      return find(arr,0,arr.length,k,dp);
    }
}