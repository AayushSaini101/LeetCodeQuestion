class Solution {
    public String pushDominoes(String str) {
        
      int left[]= new int[str.length()];
        
      int right[]=new int[str.length()];
        
      Arrays.fill(left,Integer.MIN_VALUE);
        
      Arrays.fill(right,Integer.MIN_VALUE);
        
      for(int i=str.length()-1;i>=0;--i){
          
          if(str.charAt(i)=='L'){
              
              left[i]=i;
          }
          else
              if(str.charAt(i)=='.'){
                  
                  if(i!=str.length()-1){
                      
                      left[i]=left[i+1];
                  }
              }
      }
        
     for(int i=0;i<str.length();++i){
         
          if(str.charAt(i)=='R'){
              
              right[i]=i;
          }
         else
             if(str.charAt(i)=='.'){
                 
                 if(i!=0){
                     
                     right[i]=right[i-1];
                 }
             }
     }
        
        StringBuffer finalPosition=new StringBuffer("");
        
        for(int i=0;i<str.length();++i){
            
              
            if(str.charAt(i)=='.'){
              
                if(right[i]!=Integer.MIN_VALUE&&left[i]!=Integer.MIN_VALUE){
                    
                    int diff=i-right[i];
                    
                    int diff1=left[i]-i;
                    
                    if(diff>diff1){
                        
                        finalPosition.append("L");
                        
                        continue;
                    }
                    else
                        if(diff1>diff){
                            
                            finalPosition.append("R");
                            
                            continue;
                        }
                    else{
                        
                        finalPosition.append(".");
                        
                        continue;
                    }
                  
                }
                
                int check1=right[i];
                
                int check2=left[i];
                
                if(check2!=Integer.MIN_VALUE){
                    
                    finalPosition.append("L");
                }
                else
                    if(check1!=Integer.MIN_VALUE)
                        
                       finalPosition.append("R");
                
                else{
                    
                    finalPosition.append(".");
                    
                }
            }
            else{
                
                finalPosition.append(str.charAt(i));
                
            }
           
        }
        
      
          
            return finalPosition.toString();
        
        
    }
}