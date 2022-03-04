// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
}

class GFG{
    public static void main(String args[]) throws IOException { 
        FastReader read = new FastReader();
        int t = read.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while(t-- > 0){
            int N = read.nextInt();
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = read.nextInt();

            Solution ob = new Solution();
            int ans[] = ob.canMakeTriangle(A, N); 
            for (int i=0;i<ans.length;i++) 
                out.print(ans[i]+" "); 
            out.println();
        }
        out.flush();
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int[] canMakeTriangle(int A[], int N) 
    { 
       //The sum of two smaller sides must be greater than the third side 
       int answer[]=new int[N-2];
       int index=0;
       int max=0;
      
       for(int i=0;i<N-2;++i){
           int first=A[i];
           int second=A[i+1];
           int third=A[i+2];
           max=Math.max(first,Math.max(second,third));
           
           if(max==first){
               if(second+third>max){
                   answer[index++]=1;
                   continue;
               }
           }
           else
           if(max==second){
               if(first+third>max){
                   answer[index++]=1;
                   continue;
               }
               
           }
           else{
               if(first+second>max){
                   answer[index++]=1;
                   continue;
               }
               
           }
           ++index;
           
           
           
           
       }
       return answer;
       
    }
}