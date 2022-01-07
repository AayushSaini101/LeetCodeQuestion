class Solution {
    public double power(double x, long n){
        if(n==0){
            return 1.0;
        }
        else
            if(n==1){
                return (double)x;
            }
        double ans=power(x,n/2);
        if(n%2==0){
            // 2^4= 2^2*2^2;
           
            return ans*ans;
        }
       else{
          
           return x*ans*ans;
       } 
        
    }
    public double myPow(double x, int n) {
          if(n<0){
              //Reason to take long 
              //Maximum negative value of Integer cannot use in the normal format.
              
              long temp=n;
       
              return 1/power(x,Math.abs(temp));
          }
         else{
             return power(x,n);
         }
    }
}