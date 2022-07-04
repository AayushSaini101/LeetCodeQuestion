// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minVal(a, b));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int countSetBits(int number){
        
        int count=0;
        
        while(number!=0){
             
             if((number&1)!=0){
                 
                 ++count;
                 
             }
             number=number/2;  
        }
        return count;
    }
    public static int minVal(int a, int b) {
        
        
        int setBitsA=countSetBits(a);
        
        int setBitsB=countSetBits(b);
        
        int x=0;
        
        
        if(setBitsA==setBitsB){
            
            return a;
        }
        else
        
        if(setBitsA>setBitsB){
            
            for(int i=31;i>=0;--i){
                
                if(setBitsB==0){
                    break;
                }
                
                if((a&(1<<i))!=0){
                    
                    x|=(1<<i);
                    
                    --setBitsB;
                }
            }
            
            return x;
            
            
            
        }
        
        else{
            
            int diff=setBitsB-setBitsA;
            
            x=a;
            
            for(int i=0;i<=31;++i){
                
              if(diff==0){
                  
                  break;
              }
              
              if((x&(1<<i))==0){
                  
                  x|=(1<<i);
                  
                  --diff;
                  
              }
            }
            
            return x;
            
        }
    }
}