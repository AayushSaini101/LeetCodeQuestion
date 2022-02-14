// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        //WE need to find the elements that the frequency is 2 and the one number is missing 
        // 1 2 2 
        // 3 number is missing from the array 
        // [1-N]
        
        
       
        int twoTimes=0;
        int missingNumber=0;
       
        // 1 3 3
        // 
        for(int i=0;i<arr.length;++i){
          // All the numbers in the range[1-N]
          //i+1th number is present two times in the array 
           int value=Math.abs(arr[i])-1;
            if(arr[value]<0){
               
               
               
                   twoTimes=value+1;
               
            }
            else{
                
               
                 arr[value]=-1*arr[value];
            }
            
            
        }
      
        
        for(int i=0;i<arr.length;++i){
            if(arr[i]>0){
                missingNumber=i+1;
            }
        }
        return new int[]{twoTimes,missingNumber};
    }
}