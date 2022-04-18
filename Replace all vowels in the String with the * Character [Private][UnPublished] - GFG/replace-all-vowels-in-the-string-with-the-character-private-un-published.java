// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        
        int t=scan.nextInt();
        
        while(t-->0){
            
            String m=scan.next();
            
            GFG ob=new GFG();
            
            System.out.println(ob.replaceVowels(m));
            
        }
    }
}// } Driver Code Ends


//User function Template for Java

class GFG{
    
    String replaceVowels(String m){
          StringBuffer ans=new StringBuffer("");
        for(int i=0;i<m.length();++i){
            char ch=Character.toLowerCase(m.charAt(i));
            if(ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u'){
                ans.append("*");
            }
            else{
                ans.append(m.charAt(i));
            }
        }
        
        return ans.toString();
    }
}

