class Solution {
    public List<Integer> partitionLabels(String s) {
     
      int dp[]=new int[26];
    
      for(int i=0;i<s.length();++i){
          
          int key=s.charAt(i)-'a';
          
          dp[key]=Math.max(dp[key],i);
      }
        
      int max=0;
        
      List<Integer>answer=new ArrayList<>();
    
      int previous=-1;
        
        
      for(int i=0;i<s.length();++i){
          
          
            int key=s.charAt(i)-'a';
          
            max=Math.max(dp[key],max);
       
          
          if(max==i){
              
              //System.out.println(i+1);
              
              if(answer.size()==0&&previous==-1){
                  
                  answer.add(i+1);
                  
                  previous=i+1;
              }
              else{
                  
                //  System.out.println((i+1)+" "+answer.get(answer.size()-1));
                  
                  answer.add((i+1)-previous);
                  
                  previous=i+1;
              }
              
              
              max=0;
              
              
          }
        
      }
        
       
        return answer;
        
    }
}