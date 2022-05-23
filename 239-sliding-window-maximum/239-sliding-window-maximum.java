class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
   
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];
        
        left[0]=nums[0];
        
        right[right.length-1]=nums[nums.length-1];
      
        for(int i=1;i<nums.length;++i){
            
            if(i%k==0){
               // System.out.println(i);
                left[i]=nums[i];
            }
            else{
               // System.out.println(nums[i]);
                left[i]=Math.max(left[i-1],nums[i]);
            }
            
            int last=nums.length-1-i;
            
            if((last+1)%k==0){
             
                right[last]=nums[last];
            }
            else{
                right[last]=Math.max(right[last+1],nums[last]);
                
            }
            
        }
        
        
        int answer[]=new int[nums.length-k+1];
        
      
       for(int i=0;i<nums.length-k+1;++i){
           
           int leftMax=right[i];
           int rightMax=left[i+k-1];
           
           answer[i]=Math.max(leftMax,rightMax);
       }    
        return answer;
  }
    
}