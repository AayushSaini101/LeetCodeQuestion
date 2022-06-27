class Solution {
    public int minPartitions(String n) {
        //The String length is of the length !0^5 
    
    // The array represents the state of teh String 
    
      int dp[]=new int[n.length()];
        
      int Totalcount=0;
        
      int check=0;
        
      for(int i=0;i<n.length();++i){
          
          if(n.charAt(i)=='0'){
              continue;
          }
          else{
              
              if(n.charAt(i)!='1'){
                  
                  check=1;
                  
              }
              
              dp[i]=1;
              
          }
      }
        
     if(check==0){
         
         return 1;
     }
    
     else{
         
         Totalcount=1;
         
         while(true){
             
              check=0;
             
             
             for(int i=0;i<n.length();++i){
                 
                  int diff=(n.charAt(i)-'0')-dp[i];
                 
                  if(diff!=0){
                      
                      dp[i]+=1;;
                      
                      check=1;
                  }
             }
             if(check==0){
                 break;
             }
             ++Totalcount;
         }
         
         
         
     }
        return Totalcount;
        
    }
}