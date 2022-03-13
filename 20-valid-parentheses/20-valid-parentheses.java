class Solution {
    public boolean isValid(String s) {
        //valid 
        Stack<Character>S=new Stack<>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                S.add(s.charAt(i));
            }
            else{
            if(S.size()==0){
                return false;
            }
                else
                if(s.charAt(i)==')'&&S.peek()!='('){
                    return false;
                }
                else
                    if(s.charAt(i)==']'&&S.peek()!='['){
                        return false;
                    }
                else
                    if(s.charAt(i)=='}'&&S.peek()!='{'){
                        return false;
                    }
                S.pop();
            }
        }
        if(S.size()==0)
        return true;
        else
            return false;
        
    }
}