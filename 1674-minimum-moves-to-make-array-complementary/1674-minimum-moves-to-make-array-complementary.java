class Solution {
    public int minMoves(int[] nums, int limit) {
       //The range of the sum is lies between 
        int range[]=new int[limit*2+2];
        for(int i=0;i<nums.length/2;++i){
            int min=Math.min(nums[i],nums[nums.length-1-i])+1;
            
            int max=Math.max(nums[i],nums[nums.length-1-i])+limit;
            
            int total=nums[i]+nums[nums.length-1-i];
            
            //Using the sweeping the algorithm 
            
            range[min]--;
            range[max+1]++;
            range[total]--;
            range[total+1]++;
        }
    
        int n=nums.length;
        int count=n;
        int answer=Integer.MAX_VALUE;
        
        for(int i=2;i<limit*2+1;++i){
            
             count+=range[i];
           // System.out.println(count);
            answer=Math.min(answer,count);
            
        }
        return answer;
        
        
    }
}