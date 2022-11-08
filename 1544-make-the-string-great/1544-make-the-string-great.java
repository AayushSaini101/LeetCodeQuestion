class Solution {
    public String makeGood(String m) {
    Stack<Character>S=new Stack<>();
        //97 
     for(int i=m.length()-1;i>=0;--i){
         if(S.size()==0){
             S.add(m.charAt(i));
         }
         else{
            if(S.peek()+32==m.charAt(i)||S.peek()-32==m.charAt(i)){
                S.pop();
            }
            else
            S.add(m.charAt(i));
         }

     }
     String ans="";
     while(S.empty()==false){
         ans+=S.pop();
     }
    return ans;
        
    }
}