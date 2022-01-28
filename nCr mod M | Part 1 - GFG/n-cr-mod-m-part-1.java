// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            long n = Long.parseLong(s[0]);
            long r = Long.parseLong(s[1]);
            Solution obj = new Solution();
            int ans = obj.nCr(n, r);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends



class Solution
{
    static long mod=1000003;
    public static int nCr(long n, long r)
    {
        return (int)lucas(n,r);
    }
    
    static long binary_expo(long a,long b){
        long ans=1;
        while(b>0){
            if((b&1)!=0){
                ans=(ans*a)%mod;
            }
            a=(a*a)%mod;
            b/=2;
        }
        return ans;
    }
    static long mod_inverse(long a){
        return binary_expo(a,mod-2);
    }
    static long fermat(long n,long r){
        if(n<r)return 0;
        if(r==0||n==r)return 1;
        if(r==n-1||r==1)return n;
        HashMap<Long,Long>fact=new HashMap<>();
        fact.put((long)0,(long)1);
        for(long i=1;i<=n;i++){
            long x=(fact.get(i-1)*i)%mod;
            fact.put(i,x);
        }
        long a=fact.get(n);
        long b=mod_inverse(fact.get(n-r));
        long c=mod_inverse(fact.get(r));
        return ((a*b)%mod*c%mod)%mod;
    }
    static long lucas(long n,long r){
        if(r==0)return 1;
        long ni=n%mod,ri=r%mod;
        return (lucas(n/mod,r/mod)*fermat(ni,ri))%mod;
    }
}