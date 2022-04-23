// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class Solution{
    
    public static void main(String args[]){
        
        Scanner scan=new Scanner(System.in);
        
        int t=scan.nextInt();
        
        while(t-->0){
            
            int number=scan.nextInt();
            
            GFG ob=new GFG();
            
            System.out.println(ob.checkUniqueNumber(number));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class GFG{
  public boolean checkUniqueNumber(int number){
     HashSet<Integer>H=new HashSet<>();
     
     while(number!=0){
         
         int remainder=number%10;
         
         if(H.contains(remainder)){
             
             return false;
         }
         
         H.add(remainder);
         
         number/=10;
     }
     return true;  
  }    
}