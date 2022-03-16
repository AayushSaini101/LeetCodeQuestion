// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        ArrayList<ArrayList<Integer>>lst=new ArrayList<>();
        int length=A.size();
        int total=(1<<length)-1;
        
        for(int i=0;i<=total;++i){
            ArrayList<Integer>ans=new ArrayList<>();
            for(int j=0;j<A.size();++j){
                if((i&(1<<j))!=0){
                    ans.add(A.get(j));
                }
            }
            lst.add(new ArrayList<>(ans));
        }
        Collections.sort(lst,new Comparator<>(){
         @Override
         public int compare(ArrayList<Integer>first,ArrayList<Integer>second){
             
             for(int i=0;i<Math.min(first.size(),second.size());++i){
                 
                 if(first.get(i)<second.get(i)){
                     return -1;
                 }
                 else
                 if(first.get(i)>second.get(i)){
                     return 1;
                 }
             }
             return first.size()-second.size();
         }
            
        });
        
        
        return lst;
    }
}