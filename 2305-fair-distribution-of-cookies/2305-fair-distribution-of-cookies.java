class Solution {
    public int answer=Integer.MAX_VALUE;
    public int answer1=Integer.MAX_VALUE;
    
    public void find(int index,int cookies[],int k,int dp[]){
       if(index>=cookies.length){
          int max=0;
          int min=Integer.MAX_VALUE;
          for(int elements:dp){
              
              if(elements==0)return ;
              
              max=Math.max(max,elements);
           
              min=Math.min(min,elements);
          }
      
          
           if(max-min<answer){
               answer=max-min;
               answer1=Math.min(answer1,max);
           }
           
           return ;
       }
        
       for(int i=0;i<k;++i){
           //Either use in the block 
           dp[i]+=cookies[index];
           
           find(index+1,cookies,k,dp);
           
           dp[i]-=cookies[index];
       }
    }
    public int distributeCookies(int[] cookies, int k) {
        //Distribution of the candies using the k 
        int dp[]=new int[k];
        
        find(0,cookies,k,dp);
        
        return answer1;
        
    }
}