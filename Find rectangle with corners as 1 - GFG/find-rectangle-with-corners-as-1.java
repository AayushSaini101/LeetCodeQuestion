// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.HashSet; 

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}

			Solution x = new Solution();
			if (x.ValidCorner(matrix)) 
				System.out.println("Yes"); 
			else
				System.out.println("No"); 
			t--;
		}
	} 
}
	


// } Driver Code Ends


//User function Template for Java

public class Solution { 
	static boolean ValidCorner(int matrix[][]) 
	{ 
	      // Your code goes here
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=i+1; j<m; j++){
                int cnt = 0;
                for(int row=0; row<n; row++){
                    if(matrix[row][i] == 1 && matrix[row][j] == 1){
                        cnt += 1;
                    }
                    if(cnt>=2){
                        return true;
                    }
                }
            }
        }
        return false;
	}
}