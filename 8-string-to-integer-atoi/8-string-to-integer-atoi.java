class Solution {
    public int myAtoi(String s) {
   
      int checkMinus=0;
    
      StringBuffer ans=new StringBuffer("");
      int i=0;
      for(i=0;i<s.length();++i){
          if(s.charAt(i)==32){
           continue;    
          }
          else{
              break;
          }
      }
      while(i<s.length()){
          if(s.charAt(i)=='-'){
              checkMinus=1;
              ++i;
              break;
          }
          else{
              break;
          }
      }
     while(i<s.length()){
          if(s.charAt(i)=='+'&&checkMinus==0){
             
              ++i;
              break;
          }
          else{
              break;
          }
      }
        int check=0;
        //Reading the number
     for(int j=i;j<s.length();++j){
          if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
              if(ans.length()==0&&s.charAt(j)=='0'){
                  continue;
              }
              ans.append(s.charAt(j));
              check=1;
          }
         else{
             break;
         }
     }
        if(check==0){
            return 0;
        }
        
        if(checkMinus==1){
            //The number is of Minus
            String min=""+Integer.MIN_VALUE;
            ans.insert(0,'-');
            if(ans.length()>min.length()){
                return Integer.MIN_VALUE;
            }
            if(ans.length()==min.length()&&min.compareTo(ans.toString())<=0){
                return Integer.MIN_VALUE;
            }
            else{
                //We can return the number 
               
                return new Integer(ans.toString());
            }
        }
        else{
              String max=""+Integer.MAX_VALUE;
          
            if(ans.length()>max.length()){
                return Integer.MAX_VALUE;
            }
            if(ans.length()==max.length()&&max.compareTo(ans.toString())<=0){
                
              //  System.out.println(max.compareTo(ans.toString())+" "+ans);
                return Integer.MAX_VALUE;
            }
            else{
                //We can return the number 
                String ans1=ans.toString();
                return new Integer(ans1);
            }
        }
        
    }
}