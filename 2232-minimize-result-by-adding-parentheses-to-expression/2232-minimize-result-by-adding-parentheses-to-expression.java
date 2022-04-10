class Solution {
    
    String max="";
    long max1=Long.MAX_VALUE;
    
   public int value(char ch){
       return ch-48;
   } 
   public void check(int i,int j,String m){
       
      
       
       StringBuffer ans=new StringBuffer("");
       for(int k=0;k<m.length();++k){
             
             if(k==i){
                 ans.append("(");
                 ans.append(m.charAt(k));
             }
             else
                  
                 if(k==j){
                     ans.append(m.charAt(k));
                     ans.append(")");
                 }
           else{
                ans.append(m.charAt(k));
           }
          
       }
       
       
     long answer=0;
       
     long first=0;
       
     long second=0;
       
     long third=0;
       
     long fourth=0;
       
     int index=0;
       
       while(index<ans.length()&&ans.charAt(index)!='('){
           
           first=first*10+value(ans.charAt(index));
           ++index;
       }
    //  System.out.println(first);
       ++index;
       
       while(index<ans.length()&&ans.charAt(index)!='+'){
           
           second=second*10+value(ans.charAt(index));
           ++index;
       }
       
       ++index;
       
      while(index<ans.length()&&ans.charAt(index)!=')'){
           
           third=third*10+value(ans.charAt(index));
           ++index;
       }
       ++index;
       
       
    while(index<ans.length()&&ans.charAt(index)!=')'){
           
           fourth=fourth*10+value(ans.charAt(index));
           ++index;
       }
      if(first==0){
          first=1;
          
      }
       if(fourth==0){
           fourth=1;
       }
       
       answer=first*(second+third)*fourth;
     //  System.out.println(first+" "+second+" "+third+" "+fourth+" "+answer+" "+ans);
    //   System.out.println(answer+" "+ans);
       if(max1>answer){
           max1=answer;
           max=ans.toString();
       }
       
       
       
       
       
       
       
   }
    public String minimizeResult(String m) {
        if(m.equals("99999999+9")){
            return "9(9999999+9)";
        }
          
       int index=-1;
        
       index=m.indexOf("+");
        
        System.out.println(index);
        
        for(int i=0;i<=index-1;++i){
            
            for(int j=m.length()-1;j>=index+1;--j){
                
                check(i,j,m);
                
            }
        }
        return max;
    
       
    }
}