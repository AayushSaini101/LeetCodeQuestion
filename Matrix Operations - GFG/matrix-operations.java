// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            System.out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int i = 0;
        int j = 0;
        
        boolean right = true;
        boolean left = false;
        boolean up = false;
        boolean down = false;
        
        int prevI = 0;
        int prevJ = 0;
        
        while(i>-1 && j>-1 && i<m && j<n){
            
            prevI = i;
            prevJ = j;
            
            if(right){
                
                if(arr[i][j]==0){
                    j++;
                }else if(arr[i][j]==1){
                    arr[i][j] = 0;
                    right = false;
                    down = true;
                }
                
            }else if(left){
                
                if(arr[i][j]==0){
                    j--;
                }else if(arr[i][j]==1){
                    arr[i][j] = 0;
                    left = false;
                    up = true;
                }
                
            }else if(up){
                
                if(arr[i][j]==0){
                    i--;
                }else if(arr[i][j]==1){
                    arr[i][j] = 0;
                    up = false;
                    right = true;
                }
                
            }else if(down){
                
                if(arr[i][j]==0){
                    i++;
                }else if(arr[i][j]==1){
                    arr[i][j] = 0;
                    down = false;
                    left = true;
                }
                
            }
            
        }
        
        return new int[]{prevI,prevJ};
    }
}