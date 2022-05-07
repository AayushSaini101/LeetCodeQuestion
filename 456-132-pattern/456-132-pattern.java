class Solution {
    
    public boolean find132pattern(int[] nums) {
        
        Stack<Integer>St=new Stack<>();
        
        int min=Integer.MIN_VALUE;
        
        
        for(int i=nums.length-1;i>=0;--i){
            
            if(min!=Integer.MIN_VALUE){
                
                if(nums[i]<min){
                    return true;
                }
            }
          
             if(St.size()!=0){
                
                //The case of 3 2 is occurs in the case 
              
               if(nums[i]>St.peek()){
                   
                    // min=Math.max(min,nums[i]);
                   
                   while(St.size()!=0&&nums[i]>St.peek()){
                       
                       min=Math.max(min,St.pop());
                   }
                 
                   
                   
               }  
                 
             }
             St.add(nums[i]);
            
        }
        
        return false;
    }
}