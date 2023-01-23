class Solution {
    public int singleNonDuplicate(int[] nums) {
        
      int start=0;
        
      int end=nums.length-1;
        
      while(start<=end){
          
          int mid=(start+end)>>1;
          
          if((mid%2==0&&mid+1<nums.length&&nums[mid]==nums[mid+1])||(mid%2==1&mid-1>=0&&nums[mid-1]==nums[mid])){
              
              start=mid+1;
          }
          else{
              
              end=mid-1;
          }
      }
       return nums[start]; 
        
        
    }
}