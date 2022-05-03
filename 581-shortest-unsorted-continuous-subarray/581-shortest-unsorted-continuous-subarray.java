class Solution {
    public int findUnsortedSubarray(int[] nums) {
      
        //Let's use the stack datastructure to find the shortest subbary 
        Stack<Integer>S=new Stack<>();
        
        int answer=0;
        
        int firstPosition=-1;
        int secondPosition=-1;
        
        int index1=Integer.MAX_VALUE;
        int index2=0;
        
        
        for(int i=0;i<nums.length;++i){
            
            
            
            if(S.size()!=0){
              
                while(S.size()!=0&&nums[S.peek()]>nums[i]){
                   
                     index1=Math.min(index1,S.pop());
                    
                  
                    
                }
              
                
             
            }
           S.add(i);
            
           
        }
        if(index1==-1){
            return 0;
        }
        S.clear();
          
        for(int i=nums.length-1;i>=0;--i){
            
            
            
            if(S.size()!=0){
                 while(S.size()!=0&&nums[i]>nums[S.peek()]){
                     index2=Math.max(index2,S.pop());
                 } 
               
                
             
            }
           S.add(i);
            
           
        }
        if(index1==Integer.MAX_VALUE){
            return 0;
        }
        return index2-index1+1;
    }
}