// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            
            String s[] = new String[n];
            for(int i=0;i<n;i++)
            {
                s[i] = sc.next();
            }
            Solution T = new Solution();
            System.out.println(T.lcp(s,n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
static  class Trie{
        
        Trie ob[]=new Trie[26];
        
        
        int count=0;
        
        
        
        Trie(){
           
          for(int i=0;i<26;++i){
              
              this.ob[i]=null;
              
          }   
        }
    }
//Inserting the value in the true 

static void insert(Trie head, String msg){
    
    Trie temp=head;
    for(int i=0;i<msg.length();++i){
         
         int value=msg.charAt(i)-'a';
         
         if(temp.ob[value]==null){
             
         
             temp.ob[value]=new Trie();
             
             temp.ob[value].count++;
             
             
             
         }
         else{
             
             temp.ob[value].count++;
             
             
         }
         
         temp=temp.ob[value];
        
    }
    
}    
static String search(Trie head,StringBuffer str,int length){
    
    Trie temp=head;
    
    StringBuffer prefix=new StringBuffer("");
    
    for(int i=0;i<str.length();++i){
        
        int value=str.charAt(i)-'a';
        
        if(temp.ob[value]==null||temp.ob[value].count!=length){
            return prefix.toString();
        }
        else{
            prefix.append(str.charAt(i));
        }
        
        temp=temp.ob[value];
        
    }
    return prefix.toString();
    
}
    //Uuse the trie datastructure to store the 
    public String lcp(String s[],int n)
    {
        // Write your code here
        
        //Find the smallest lenght String in the series of the string 
        int length=0;
        
        int index=0;
        
        StringBuffer ans=new StringBuffer("");
        
        for(int i=0;i<s.length;++i){
            String ss=s[i];
            
            if(ss.length()>length){
                
                index=i;
                
                length=ss.length();
              
                
            }
        }
        
        ans.append(s[index]);
        
        Trie head=new Trie();
        
        
        for(int i=0;i<s.length;++i){
            
            insert(head,s[i].substring(0,Math.min(length+1,s[i].length())));
            
        }
        
      String answer=search(head,ans,s.length);
        
        if(answer.isEmpty()){
            return "-1";
        }
        
      return answer;
        
        
    }
}
