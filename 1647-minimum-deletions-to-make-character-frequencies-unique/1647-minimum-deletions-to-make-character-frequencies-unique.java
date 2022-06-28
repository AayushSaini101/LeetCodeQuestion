class Solution {
    public int minDeletions(String s) {
  
        int dp[]=new int[26];
        
        PriorityQueue<Integer>P=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<s.length();++i){
            
            dp[s.charAt(i)-'a']++;
            
        }
        
        for(int i=0;i<dp.length;++i){
            
            if(dp[i]!=0)
            P.add(dp[i]);
        }
        
        int count=0;
        
        int previous=-1;
        
        while(P.size()!=0){
            
           int number=P.remove();
            
          
            
           if(previous==-1){
               
               previous=number;
           }
           else{
               
               if(number==previous){
                   
                   //Decrease the number 
                   if(number-1==0){
                       
                       ++count;
                       
                       continue;
                   }
                   
                   P.add(number-1);
                   
                   ++count;
                   
                   //Previous will be the same 
                   
               }
               
               else{
                   
                   previous=number;
               }
           }
        }
        
        return count;
       
    }
}