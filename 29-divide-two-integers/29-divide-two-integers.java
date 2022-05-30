class Solution {
    public int count(long dividend,long divisor){
        
        int count=0;
        System.out.println(dividend+" "+divisor);
        if(divisor==1){
            
            if(dividend>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else
                if(dividend>=0){
                    return (int)dividend;
                }
            
        }
       
        
        while(dividend>=divisor){
            
            dividend-=divisor;
           
            if(dividend<divisor){
                ++count;
                return count;
            }
            ++count;
        }
        
        return count;
    }
    public int divide(int dividend, int divisor) {
     
      //We have to take care the range of the numbers 
    
        if(divisor>=0){
            
            //There are two condition either the divident is greater than zero or less than zero 
            if(dividend==0){
                
                return 0;
            }
            else
                if(dividend>0){
                    
                    return count(dividend,divisor);
                }
            else{
                //We cannot convert to this to the positive number as it will 
                //cause an overflow 
                if(dividend==Integer.MIN_VALUE){
                    
               int value=count(Math.abs((long)dividend),divisor);
                    
     return  Math.max(Integer.MIN_VALUE,value==Integer.MAX_VALUE?Integer.MIN_VALUE:-value);
                }
                else{
                    return -count(Math.abs(dividend),divisor);
                }
                
            }
        }
        else{
            
            if(dividend>=0){
                
                if(divisor==Integer.MIN_VALUE){
                    
                    return Math.max(Integer.MIN_VALUE,-count(dividend,Math.abs((long)divisor)));
                }
                else{
                    return -count(dividend,Math.abs(divisor));
                }
                
            }
            else{
                //Both are negative numbers 
              //  System.out.println("Sdfs");
                
            return Math.min(Integer.MAX_VALUE,count(Math.abs((long)dividend),Math.abs((long)divisor)));
                
               
            }
            
        }
       
    }
}