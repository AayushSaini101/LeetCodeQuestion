class Solution {
    long  power(long a,long b,long mod){
    a%=mod;
    long res=1;
    while(b>0){
        if(b%2==1){
            res=(res*a)%mod;
        }
        a=(a*a)%mod;
        b>>=1;
    }
    return res;
}
   
    public String subStrHash(String s, int power1, int mod, int k, int hashValue) {
    
     long power[]=new long[k];
     
     for(int i=0;i<power.length;++i){
         power[i]=power(power1,i,mod);
     }
        //We need to find the value of the opiw
     
        
        for(int j=0;j<=s.length()-k;j++){
            long hash = 0;
            for(int i=0;i<k;i++){
                hash += (s.charAt(i+j)-'a'+1)*power[i];
            }
            hash %= mod;
            if(hash==hashValue)
                return s.substring(j,j+k);
        }
        return "";
    }
           
    

}