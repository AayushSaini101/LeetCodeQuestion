// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}
// } Driver Code Ends


class Solution {
    
    public String reverse(String S){
        //code here
        
        StringBuffer str=new StringBuffer("");
        
        Stack<Character>St=new Stack<>();
        
        for(int i=0;i<S.length();++i){
            St.add(S.charAt(i));
        }
        
        while(St.size()!=0){
            str.append(St.pop());
        }
        return str.toString();
    }

}