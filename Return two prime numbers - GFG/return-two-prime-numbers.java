// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   static List<Integer> primeDivision(int n){
       
       boolean[] arr = new boolean[n+1];
       printAllPrime(n,arr);
       HashSet<Integer> h = new LinkedHashSet<Integer>();
       List<Integer> a = new ArrayList<Integer>();
       for(int i=2;i<=n;i++){
           if(arr[i]){
               h.add(n-i);
           }
       }
       for(Integer i: h){
           if(h.contains(n-i)){
               a.add(n-i);
               a.add(i);
           }
       }
       
       return a;
   }
   
   static void printAllPrime(int n,boolean[] arr){

       if(n <= 1)  return;

       Arrays.fill(arr,true);
       for (int i=2;i*i<=n;i++){
           if (arr[i]){
               for (int j=i*i;j<=n;j+=i){
                   arr[j] = false;
               }
           }
       }
     
   }
}