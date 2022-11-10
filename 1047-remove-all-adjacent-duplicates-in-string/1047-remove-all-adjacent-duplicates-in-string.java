class Solution {
    public String removeDuplicates(String s) {
        if(s.length()==1||s.length()==0){
            return s;
        }
        Stack<Character>S=new Stack<>();
         char ch='.';
        for(int i=s.length()-1;i>=0;--i){
            boolean check=false;
            int count=0;
            if(S.size()!=0){
                while(S.size()>=1&&S.peek()==s.charAt(i)){
                    ch=S.pop();
                    ++count;
                    check=true;
              }
          }
            if(count==0)
            S.add(s.charAt(i));
    
    
        
    }
        String ans="";
        while(S.size()!=0){
            ans=ans+S.pop();
        }
        return ans;
}}