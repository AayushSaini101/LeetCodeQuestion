class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n<=0)return false;
        if(n==1)return true;
        
        if((int)Math.ceil(Math.log(n)/Math.log(4))==(int)Math.floor(Math.log(n)/Math.log(4))){
            
            return true;
        }
        
        return false;
    }
}