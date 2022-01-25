// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean can(int tempCapacity,int arr[],int days){
        
        int count=1;
        
        int sum=0;
        for(int i=0;i<arr.length;++i){
            
            if(arr[i]>tempCapacity){
                return false;
            }
            sum+=arr[i];
            
            if(sum>=tempCapacity){
                if(sum==tempCapacity){
                    sum=0;
                    if(i+1<arr.length){
                        ++count;
                    }
                    else{
                        continue;
                    }
                }
                else{
                 sum=arr[i];
                ++count;
                }
            }
        }
       //System.out.println(count+" "+days+" "+tempCapacity);
        if(count<=days){
            return true;
        }
        return false;
    }
    static int leastWeightCapacity(int[] arr, int N, int D) {
        int max=0;
        for(int elements:arr){
            max+=elements;;
        }
        int start=1;
        
        int end=max;
        
        int answer=max;
       //1  4 
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(can(mid,arr,D)){
               // System.out.println(mid);
               answer=mid;
                
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            
        }
        return answer;
    }
};