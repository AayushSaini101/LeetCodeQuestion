class Solution {
    public long numberOfWays(String s) {
      long left[]=new long[s.length()];
      long right[]=new long[s.length()];
      long answer=0;
        
      for(int i=0;i<s.length();++i){
          if(s.charAt(i)=='1'){
              if(i==0){
                  left[i]=1;
              }
              else{
                  left[i]=left[i-1]+1;
              }
          }
          else{
              if(i!=0)
              left[i]=left[i-1];
          }
      }
        
    for(int i=s.length()-1;i>=0;--i){
          if(s.charAt(i)=='1'){
              if(i==s.length()-1){
                  right[i]=1;
              }
              else{
                  right[i]=right[i+1]+1;
              }
          }
          else{
              if(i!=s.length()-1)
              right[i]=right[i+1];
          }
      }
    
      //  long answer=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='0'){
                answer+=left[i]*right[i];
            }
        }
        
        
        Arrays.fill(left,0);
        Arrays.fill(right,0);
        
          for(int i=0;i<s.length();++i){
          if(s.charAt(i)=='0'){
              if(i==0){
                  left[i]=1;
              }
              else{
                  left[i]=left[i-1]+1;
              }
          }
          else{
              if(i!=0)
              left[i]=left[i-1];
          }
      }
        
    for(int i=s.length()-1;i>=0;--i){
          if(s.charAt(i)=='0'){
              if(i==s.length()-1){
                  right[i]=1;
              }
              else{
                  right[i]=right[i+1]+1;
              }
          }
          else{
              if(i!=s.length()-1)
              right[i]=right[i+1];
          }
      }
            for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='1'){
                answer+=left[i]*right[i];
            }
        }
        return answer;
        
        
        
    
        
    }
}