class Solution {
    
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int answer[]=new int[queries.length];
        
        int currentSum=0;
        
        for(int elements:nums){
            
           if(elements%2==0){
               
               currentSum+=elements;
           }
        }
        
      //  System.out.println(currentSum);
        
        //Adding values to the range 
        
        for(int i=0;i<queries.length;++i){
            
            int index=queries[i][1];
            
            int value=queries[i][0];
            
          
            if(Math.abs(nums[index])%2==Math.abs(value)%2){
                
                
             if(Math.abs(nums[index])%2==1){
                    
                    currentSum+=nums[index];
                }
                
                nums[index]+=value;
                
                currentSum+=value;
                
            }
            else{
                if(Math.abs(nums[index])%2==0){
                    
                    currentSum-=nums[index];
                }
                
                nums[index]+=value;
                
            }
            
            answer[i]=currentSum;
            
             
        }
       // System.out.println(Arrays.toString(nums)+" "+(-1%2));
        
        return answer;
        
      
        
    }
}