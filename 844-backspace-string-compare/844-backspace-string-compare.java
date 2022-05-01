class Solution {
    private String find(String s){
        Stack<Character>S=new Stack<>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='#'){
                if(S.size()!=0){
                    S.pop();
                    
                    continue;
                    
                }
                else{
                    continue;
                }
            }
            S.add(s.charAt(i));
        }
        
        StringBuffer ans=new StringBuffer("");
        while(S.size()!=0){
            ans.append(S.pop());
            
        }
        ans.reverse();
        
        return ans.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        
        String firstFinal=find(s);
        String secondFinal=find(t);
        
       // System.out.println(firstFinal+" "+secondFinal);
        if(firstFinal.equals(secondFinal)){
            return true;
        }
        return false;
        
    }
}