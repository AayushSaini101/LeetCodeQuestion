class Solution {
    public int lowerbound(int arr[],int sum,int low){
        int answer=-1;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)>>1;
             if(arr[mid]<=sum){
                 answer=mid;
                 low=mid+1;
             } 
            else{
                high=mid-1;
            }
        }
        return answer;
        
    }
    public int upperbound(int arr[],int sum,int low){
        int answer=arr.length;
        
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(arr[mid]>=sum){
                answer=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return answer;
        
    }
    public int threeSumClosest(int[] nums, int target) { 
        //Sum is closest to the target 
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int answer=0;
        //closet points to the target 
        for(int i=0;i<nums.length;++i){
            //Considering the ith point as a first point 
            int sum=0;
            int first=nums[i];
            sum=first;
          for(int j=i+1;j<nums.length;++j){
              sum=first+nums[j];
             //Closest may be upper bound or lower bound to the answer 
              int diff=target-sum;
              int lower_bound=lowerbound(nums,diff,j+1);
              int upper_bound=upperbound(nums,diff,j+1);
              int first_sum=-1;
              int second_sum=-1;
              //-4 -1 1 2
              if(lower_bound!=-1){
                  first_sum=sum+nums[lower_bound];
                  if(min>Math.abs(target-first_sum)){
                      min=Math.abs(target-first_sum);
                      answer=first_sum;
                      
                  }
                  
              }
              if(upper_bound!=nums.length){
                 second_sum=sum+nums[upper_bound];
                  if(min>Math.abs(target-second_sum)){
                      min=Math.abs(target-second_sum);
                      answer=second_sum;
                      
                  }
              }
            
              
          }
           
        }
         return answer;
        
    }
}