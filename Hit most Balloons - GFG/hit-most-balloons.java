// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            int arr[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBalloons(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int slope(int x,int y,int x1,int y1){
        
        return (int)((double)((y1-y)/(x1-x)));
    }
    public int mostBalloons(int n, int arr[][]) {
         if(n==1 || n==2)return n;
    
      int ans = 0;
      Map<Double, Integer> hm = new HashMap<>();
      for(int i=0; i<n; i++){
         int count=0; 
         for(int j=0; j<n; j++){
            if(arr[j][0] == arr[i][0] && arr[j][1] == arr[i][1]){
              count++;
              continue;
            }
            double slope = (double)(arr[j][1] - arr[i][1])/(double)(arr[j][0] - arr[i][0]);
            hm.put(slope, hm.getOrDefault(slope, 0)+1);
            
         }
         for(int values : hm.values())
           ans = Math.max(ans, values+count);
           
          hm.clear(); 
      }
      
      return ans;
    }
}