class Solution {
 
    public int concatenatedBinary(int n) {
        //This will be n*long(n) solution
        
       StringBuffer ans=new StringBuffer("");
        
         long mod = 1000_000_007;
        
        long answer=0;
        
        for(int i=1;i<=n;++i){
            int lastBit=(int)((double)Math.log(i)/Math.log(2))+1;
            
            answer=answer<<lastBit;
            
           // System.out.println(Long.toBinaryString(answer));
            
            answer|=i;
            answer=answer%mod;
          
        }
        return (int)answer;
         
      
        
      
        
     
        
    }
}