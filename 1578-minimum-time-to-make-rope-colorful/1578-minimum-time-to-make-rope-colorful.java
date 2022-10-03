class Solution {
    public int minCost(String colors, int[] neededTime) {
     
   
      int i=0;
        
      int j=0;
        
      int minCost=0;
        
      for(i=0;i<colors.length();){
          
          
          int max=Integer.MIN_VALUE;
          
          int sum=0;
          
          j=i;
          
          while(j<colors.length()&&colors.charAt(i)==colors.charAt(j)){
          
              max=Math.max(max,neededTime[j]);
              
              sum+=neededTime[j];
              
              ++j;
          }
          if(max!=Integer.MIN_VALUE)
              
           minCost+=(sum-max);
             
         // System.out.println(i+" "+j);
          
          if(j>i){
              
              i=j;
          }
          else{
              
              ++i;
          }
          
      
          
      }
        
        return minCost;
   
    }
}