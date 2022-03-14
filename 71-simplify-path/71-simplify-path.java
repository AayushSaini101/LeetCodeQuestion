class Solution {
    public String simplifyPath(String path) {
        String extractPath[]=path.split("/");
        StringBuilder ans=new StringBuilder("");
        Stack<String>st=new Stack<>();
        for(int i=0;i<extractPath.length;++i){
             
             if(extractPath[i].equals("..")){
                // System.out.println(st);
                 if(st.isEmpty()==false){
                     st.pop();
                 }
             }
             else
                 if(extractPath[i].equals(".")==false&&extractPath[i].isEmpty()==false){
                     st.add(extractPath[i]);
                 }
           
        }
        
        Stack<String>rev=new Stack<>();
        
        while(st.size()!=0){
            rev.add(st.pop());
        }
        //System.out.println(rev);
        while(rev.size()!=0){
            String str=rev.pop();
            if(str.isEmpty()){
                continue;
            }
            else{
               
                    ans.append("/");
                    ans.append(str);
                }
               
                    
            
        }
         if(ans.isEmpty()){
             ans.append("/");
         }
        return ans.toString();
    }
}