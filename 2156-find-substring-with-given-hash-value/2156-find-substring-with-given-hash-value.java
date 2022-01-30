class Solution {
  public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long[] p = new long[k]; //to store all the power values beforehand to avoid redundant calculations
        for(int i=0;i<k;i++){
            p[i] = binpow(power, i, modulo);
        }

        for(int j=0;j<s.length()-k+1;j++){
            long hash = 0;
            for(int i=j;i<j+k;i++){
                hash += (s.charAt(i)-'a'+1)*p[i-j];
            }
            hash %= modulo;
            if(hash==hashValue)
                return s.substring(j,j+k);
        }
        return "";
    }
    
    // function to calculate (a^n)mod(n) in O(log(n)) time
    private long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if (b%2==1)
                res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

}
