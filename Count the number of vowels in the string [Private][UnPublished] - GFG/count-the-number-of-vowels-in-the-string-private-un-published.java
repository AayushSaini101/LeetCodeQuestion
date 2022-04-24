// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        
        while(t-->0){
            
            String m=scan.next();
            
            GFG ob=new GFG();
            
            System.out.println(ob.countVowels(m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class GFG{
    
    public boolean checkVowel(char ch){
        
        ch=Character.toLowerCase(ch);
        
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        else{
            return false;
        }
    }
    public int countVowels(String m){
        int count=0;
        
        for(int i=0;i<m.length();++i){
             if(checkVowel(m.charAt(i))){
                 ++count;
             }    
        }
        return count;
    }
}