import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String args[]){
        
        Scanner scan=new Scanner(System.in);
        
        int t=scan.nextInt();
        
        while(t-->0){
        String m=scan.next();
        
        StringBuffer ans=new StringBuffer();
        
        for(int i=0;i<m.length();++i){
            
            char ch=Character.toLowerCase(m.charAt(i));
            
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                ans.append("*");
            }
            else{
                ans.append(m.charAt(i));
            }
          
        }
        System.out.println(ans);
        
        }
    }
}