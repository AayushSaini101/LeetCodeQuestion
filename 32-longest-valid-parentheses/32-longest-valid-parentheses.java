class Solution 
{
    public int longestValidParentheses(String s) 
    {
        Stack<Integer> stk=new Stack<>();
        stk.push(-1);
        int maxi=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                stk.push(i);
            else
            {
                stk.pop();
                if(stk.isEmpty())
                    stk.push(i);
                maxi=Math.max(maxi,i-stk.peek());
            }
        }
        return maxi;
    }
}