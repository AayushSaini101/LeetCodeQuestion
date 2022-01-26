// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    for(int i=0; i<n; i++)
                        {
                            int x = sc.nextInt();
                            arr.add(x);
                        }
                    int k = sc.nextInt();
                    
                    Solution obj = new Solution();
                    res = obj.TopK(arr,k);
                    
                    for(int i=0; i<res.size();i++)
                        {
                            System.out.print(res.get(i) + " ");
                        }
                    System.out.println();    
                    
                        
                }
        }
}// } Driver Code Ends


class Solution
{
    class Pair{
        int value;
        int count;
        Pair(int value,int count){
            this.value=value;
            this.count=count;
        }
    }
    ArrayList<Integer>TopK(ArrayList<Integer> array, int k)
    {
        // code here
        TreeMap<Integer,Integer>map=new TreeMap<>();
        for(int i=0;i<array.size();++i){
            map.put(array.get(i),map.getOrDefault(array.get(i),0)+1);
        }
       ArrayList<Integer>lst=new ArrayList<>();
       
       PriorityQueue<Pair>P=new PriorityQueue<>((a,b)->(a.count==b.count)?b.value-a.value:b.count-a.count);
       
       for(int key:map.keySet()){
           P.add(new Pair(key,map.get(key)));
       }
       while(P.size()!=0&&k-->0){
           Pair ob=P.remove();
           lst.add(ob.value);
       }
       return lst;
       
       
        
    }
}
