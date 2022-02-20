// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.kthDiff(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long kthDiff(long arr[], long n, long k)
    {
         Arrays.sort(arr);
       long maxDiff =  arr[(int)n - 1] - arr[0];
       // long minDiff = maxDiff;
       // for(int i=0;i<n - 1;i++)
       //     if(minDiff > (arr[i + 1] - arr[i])) 
       //         minDiff = arr[i + 1] - arr[i];
       long l = 0;
       long r = maxDiff;
       long mid;
       while(l < r){
           mid = (l + r)/2;
           if(compute(mid,arr,k))
               r = mid;
           else
               l = mid + 1; 
       }
       return l;
   }
   
   public boolean compute(long m,long a[],long k)
   {
       int j = 1;
       long n = a.length;
       int total = 0;
       for(int i=0;i<n;i++){
           while(j < n && (a[j] - a[i] <= m)) j++;
           j--;
           int x = j - i;
           total += x;
       }
       return (total>=k);
   }
    
}