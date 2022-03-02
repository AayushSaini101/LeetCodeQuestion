// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.countStrings(S); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countStrings(String S) 
    { 
        long ans=0;
       HashMap<Character,Long> hm =  new HashMap<>();
       for(int i=0;i<S.length();i++){
           hm.putIfAbsent(S.charAt(i),Long.valueOf(0));
           hm.put(S.charAt(i),hm.get(S.charAt(i))+1);
       }
       long total=Long.valueOf(S.length());
       for(int i=0;i<S.length();i++){
           char x=S.charAt(i);
           long df=hm.get(x);
           ans+=total-df;
           total--;
           hm.put(x,hm.get(x)-1);
       }
       if(hm.size()==S.length())
          return ans;
       else 
          return ans+1;
    }
}