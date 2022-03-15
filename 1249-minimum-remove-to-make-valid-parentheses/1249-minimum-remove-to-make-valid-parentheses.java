class Solution {
    public String minRemoveToMakeValid(String s) {
        //Removing the brackets to make this valid string 
        //One observation is clear 
        //The number of open and the closed bracketes should be same the sum is even 
        // the number of open brackets should be come 
        //Characters are not invali
        Stack<Integer>S=new Stack<>();
        List<Integer>lst=new ArrayList<>();
        StringBuffer ans=new StringBuffer("");
        for(int i=0;i<s.length();++i){
            if(S.size()!=0&&s.charAt(i)==')'){
               // System.out.println(S+" "+i+" "+lst);
                while(S.size()!=0){
                    //This will remove 
                    lst.remove(new Integer(S.pop()));
                    break;
                    
                }
              
            }
            else{
                if(s.charAt(i)==')'){
                    //This is invalid bracket 
                    lst.add(i);
                    continue;
                }
                else
                if(s.charAt(i)=='('){
                    lst.add(i);
                    S.add(i);
                    
                }
            }
        }
        
        for(int i=0;i<s.length();++i){
            if(lst.contains(i)){
                continue;
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}