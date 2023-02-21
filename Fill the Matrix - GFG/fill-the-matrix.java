//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    
    static class Pair{
        
        int x;
        
        int y;
        
        Pair(int x,int y){
            
            this.x=x;
            
            this.y=y;
        }
    }
    
    public static boolean check(int x,int y,int N,int M,int dp[][]){
        
        return !(x<=0||x>N||y<=0||y>M||dp[x][y]==1);
    }
    
	public static int minIteration(int N, int M, int X, int Y){
		//code here
		//Using the concept of BFS 
		
		Queue<Pair>Q=new LinkedList<>();
		
		Q.add(new Pair(X,Y));
		
		int dp[][]=new int[N+1][M+1];
		
		dp[X][Y]=1;
		
		int count=0;
		
		while(Q.size()!=0){
		    
		    int size=Q.size();
		    
		    boolean check=false;
		    
		    for(int i=0;i<size;++i){
		        
		        Pair remove=Q.remove();
		        
		        int x=remove.x;
		        
		        int y=remove.y;
		        
		        if(check(x+1,y,N,M,dp)){
		            
		          //  System.out.println("First");
		            
		            check=true;
		            
		            Q.add(new Pair(x+1,y));
		            
		            dp[x+1][y]=1;
		        }
		        if(check(x-1,y,N,M,dp)){
		              
		           //      System.out.println("Second");
		            check=true;
		            
		            Q.add(new Pair(x-1,y));
		            
		              dp[x-1][y]=1;
		            
		        }
		        if(check(x,y-1,N,M,dp)){
		              
		             //    System.out.println("Third");
		            check=true;
		            
		            Q.add(new Pair(x,y-1));
		            
		            dp[x][y-1]=1;
		            
		        }
		        if(check(x,y+1,N,M,dp)){
		              
		            check=true;
		            
		            Q.add(new Pair(x,y+1));
		            
		            dp[x][y+1]=1;
		        }
		        
		    }
		    
		
		    if(check==true)
		    ++count;
		}
		return count;
		
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends