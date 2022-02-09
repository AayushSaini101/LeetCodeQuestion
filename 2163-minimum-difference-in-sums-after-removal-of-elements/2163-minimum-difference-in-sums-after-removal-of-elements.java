class Solution {
    public long minimumDifference(int[] nums) {
        //Minimum difference between two sets of the array 
        //Sum of the set first -sum of the elements in the set second 
        //Maximise the sum of elements in the both of the two set 
        //We have one more condition we have to remove total n elements from an array 
        //The parts of the should be equal 
        long prefix[]=new long[nums.length];
        long suffix[]=new long[nums.length];
        int length=nums.length/3;
        //Starting from the last element 
        //PriorityQueue
        PriorityQueue<Long>P=new PriorityQueue<>();
        long sum=0;
        for(int i=nums.length-1;i>=0;i--){
            
            P.add((long)nums[i]);
            sum=(long)sum+nums[i];
            if(P.size()>length){
                sum-=P.remove();
            }
            
            if(P.size()==length)
             suffix[i]=sum;
            
            
               
        }
        sum=0;
        PriorityQueue<Long>PP=new PriorityQueue<>(Collections.reverseOrder());
     long sum1=Long.MAX_VALUE;
        for(int i=0;i<prefix.length-length;++i){
            
            sum=(long)sum+nums[i];
            
            PP.add((long)nums[i]);
            if(PP.size()>length){
                sum-=PP.remove();
            }
            
           
            if(PP.size()==length){
              sum1=Math.min(sum1,sum-suffix[i+1]);  
            }
        }
       
   
        return sum1;
       
    } 
}