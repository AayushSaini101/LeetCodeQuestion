class Solution {
    class Pair{
        int value;
        int count;
        Pair(int value,int count){
            this.value=value;
            this.count=count;
        }
    }
    public int totalSteps(int[] nums) {
        //Starting from the end position 
        
        Stack<Pair>St=new Stack<>();
        
        int answer=0;
        
        int count=0;
        
        for(int i=nums.length-1;i>=0;--i){
            
            count=0;
            
            while(St.size()!=0&&nums[i]>St.peek().value){
                
                 count=Math.max(count+1,St.pop().count);
        
            }
            
            answer=Math.max(answer,count);
            
            St.add(new Pair(nums[i],count));
            
          
           
        }
        
     
        return answer;
    }
}