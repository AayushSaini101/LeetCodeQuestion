// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


class Solution{
   static List<Integer> nextPermutation(int n, int arr[]){
       // code here
       int i=0;
       List<Integer> ans=new ArrayList<>();
       for(i=n-2;i>=0;i--)
       {
           if(arr[i]<arr[i+1])
               break;
       }
       if(i==-1)
       {
           i=0;
           n-=1;
           while(i<=n)
           {
               int v=arr[i];
               arr[i]=arr[n];
               arr[n]=v;
               i++;
               n--;
           }
           for(int vari:arr)
               ans.add(vari);
           return ans;
       }
       else
       {
           int k=i;
           for(i=n-1;i>=k;i--)
           {
               if(arr[i]>arr[k])
                   break;
           }
           int l=i;
           int temp=arr[k];
           arr[k]=arr[l];
           arr[l]=temp;
           k++;
           n-=1;
           while(k<=n)
           {
               int v=arr[k];
               arr[k]=arr[n];
               arr[n]=v;
               k++;
               n--;
           }
           for(int vari :arr)
               ans.add(vari);
           return ans;
       }
   }
}