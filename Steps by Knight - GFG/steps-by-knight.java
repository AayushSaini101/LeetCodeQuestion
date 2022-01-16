// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
     class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public boolean check(int x,int y,int dp[][]){
        if(x<0||y<0||x>=dp.length||y>=dp.length||dp[x][y]==1){
            return false;
        }
        return true;
    }
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        //We can bfs here
      Queue<Pair>Q=new LinkedList<>();
      
      int target_x=TargetPos[0]-1;
      int target_y=TargetPos[1]-1;
      int count=0;
      int dp[][]=new int[N][N];
      if(target_x==KnightPos[0]-1&&target_y==KnightPos[1]-1){
          return 0;
      }
      
      Q.add(new Pair(KnightPos[0]-1,KnightPos[1]-1));
      
      while(Q.size()!=0){
         
          //Remove the position
       
          
          int size=Q.size();
          
     
          ++count;
           //These are the moves of the knight
           
          for(int index=0;index<size;++index){
                   
           Pair position=Q.remove();
       
         
           if(dp[position.x][position.y]==1){
              continue;
          }
           dp[position.x][position.y]=1;
          
          int x[]={2,2,-2,-2,-1,-1,1,1};
          
          int y[]={-1,1,-1,1 ,2,-2,-2,2};
          
          for(int i=0;i<x.length;++i){
              
              if(check(position.x+x[i],position.y+y[i],dp)){
                  //Use this position
                 
                  
                  if(position.x+x[i]==target_x&&position.y+y[i]==target_y){
                   
                      return count;
                  }
                  Q.add(new Pair(position.x+x[i],position.y+y[i]));
              }
          }
          
          
          }   
      }
      return -1;
    }
}