class Solution {
    public int maximumXOR(int[] nums) {
        
       int sum=0;
        
       int max=0;
        
        for(int elements:nums){
            
            max=Math.max(max,elements);
        }
        int bit=(int)(Math.log(max)/Math.log(2));
    
        for(int i=0;i<=bit;++i){
            int count=0;
            for(int j=0;j<nums.length;++j){
                if((nums[j]&(1<<i))!=0){
                    ++count;
                }
            }
            if(count==0){
                continue;
            }
            else{
                sum|=(1<<i);
            }
        }
        return sum;
    }
}