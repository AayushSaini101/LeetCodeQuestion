class Solution {
    public double power(double x, long n){
        if(n<=0){
            return 1.0;
        }
        else
            if(n==1){
                return (double)x;
            }
        if(n%2==0){
            double ans=power(x,n/2);
            return ans*ans;
        }
       else{
           double ans1=power(x,n/2);
           return x*ans1*ans1;
       } 
        
    }
    public double myPow(double x, int n) {
          if(n<0){
              long temp=n;
            //  System.out.println(Math.abs(temp));
              return 1/power(x,Math.abs(temp));
          }
         else{
             return power(x,n);
         }
    }
}