class Solution {
    public String removeKdigits(String num, int k) {
        if(k==0){
            return num;
        }
        else
            if(k>=num.length()){
                return "0";
            }
    // Remove k digits 
        Stack<Integer>S=new Stack<>();
        StringBuffer ans=new StringBuffer("");
        
        for(int i=0;i<num.length();++i){
            
            while(S.size()!=0&&S.peek()>num.charAt(i)-'0'&&k-->0){
                S.pop();
            }
            S.add(num.charAt(i)-'0');
        }
        
       //Reverse the Stack 
        Stack<Integer>temp=new Stack<>();
        
        while(S.size()!=0){
            temp.add(S.pop());
        }
        int check=0;
        while(temp.size()!=0){
            int value=temp.pop();
            if(value==0&&check==0){
                continue;
            }
            else{
                check=1;
                ans.append(value);
            }
            
        }
        if(k!=0){
            //remove last k value from the strin g
            if(k>=ans.length()){
                return "0";
            }
            else{
                return ans.substring(0,Math.min(ans.length()-k,ans.length()));
            }
        }
        if(ans.toString().isEmpty()){
            return "0";
        }
        return ans.toString();
    }
}