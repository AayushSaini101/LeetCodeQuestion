// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            
            this.data=data;
        
        }
    }
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
     Stack<Integer> st=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        int A_i=0;
        int B_i=0;
        for(int i=1;i<=n;i++){
            while(A_i<2*e && A[A_i]==i){
                st.push(A[A_i+1]);
                A_i+=2;
            }
            while(B_i<2*e && B[B_i]==i){
                q.add(B[B_i+1]);
                B_i+=2;
            }
            
            while(!q.isEmpty()){
                if(q.remove()!=st.pop()){
                    return 0;
                }
            }
        }
        return 1;
        
    }
};