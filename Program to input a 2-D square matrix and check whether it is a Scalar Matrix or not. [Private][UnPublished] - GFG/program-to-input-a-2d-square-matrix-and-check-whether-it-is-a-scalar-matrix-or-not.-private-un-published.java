// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        
        while(t-->0){
            int N=scan.nextInt();
            int M=scan.nextInt();
            int mat[][]=new int[N][M];
            for(int i=0;i<N;++i){
                for(int j=0;j<M;++j){
                    mat[i][j]=scan.nextInt();
                }
            }
            
            GFG ob=new GFG();
            
            System.out.println(ob.checkScalerMatrix(mat,N,M));
            
        }
    }
}









// } Driver Code Ends


//User function Template for Java
class GFG{
boolean checkScalerMatrix(int mat[][],int N,int M)
    {
        // Check all elements
        // except main diagonal are
        // zero or not.
        int value=mat[0][0];
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                  if(i!=j&&mat[i][j]!=0){
                      return false;
                  }
                  else
                  if(i==j&&mat[i][j]!=value){
                      return false;
                  }
            }
            
            
    }
    return true;
    }           
    
          
    

    
}