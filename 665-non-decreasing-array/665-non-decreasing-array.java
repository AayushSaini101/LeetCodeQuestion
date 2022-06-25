class Solution {
    public boolean checkPossibility(int[] nums) {
        //Use the concept of the stack to check 
        Stack<Integer>St=new Stack<>();
        
        boolean check=true;
        
        if(nums.length==1||nums.length==2){
            
            return true;
        }
        
        //Store the adjacent element in the array 
        
        int adj[]=new int[nums.length];
        
        for(int i=nums.length-1;i>=0;--i){
            
            if(i==nums.length-1){
                
                adj[i]=-1;
            }
            else{
                
              //Storing the adjacent value to the array 
               adj[i]=nums[i+1];
            }
        }
        
        int count=0;
        
        for(int i=0;i<nums.length;++i){
            
           
            
            if(St.size()!=0){
                
                
               if(nums[St.peek()]>nums[i]){
                   
                   if(count==1){
                       
                       return false;
                   }
                    ++count;  
                   //There are two option either remove the current element or remove peek element 
                   
                   if(i==nums.length-1){
                       
                       nums[i]=nums[i-1];
                       
                       break;
                   }
                   
                   if(adj[i]>nums[St.peek()]){
                       
                       nums[i]=adj[i];
                           
                       continue;
                   }
                   
                   
                   
                  int index= St.pop();
                   
                     
                  nums[index]=nums[i];
                   
             
               }
                
                
                
             }
            
            St.add(i);
            
        }
        
     
        
        for(int i=1;i<nums.length;++i){
            
            if(nums[i]<nums[i-1]){
                
                return false;
                
            }
        }
        
        return true;
        
        
    }
}