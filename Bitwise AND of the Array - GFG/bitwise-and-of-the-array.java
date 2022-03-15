// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int ans = ob.count(N, A, X); 
            System.out.println(ans);
        }
    } 
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int count(int N, int A[], int X) 
    {  
        // code here
           int ans=N;

        int mask=0;

        for(int i=31;i>=0;i--){

            if((X&(1<<i))!=0){

              mask^=(1<<i);

              continue;

            }

            int temp=mask^(1<<i);

            int count=0;

            for(int j=0;j<N;j++){

              if((temp&A[j])!=temp)

              count++;

            }

            ans=Math.min(ans,count);

        }

      return ans;
    }
} 