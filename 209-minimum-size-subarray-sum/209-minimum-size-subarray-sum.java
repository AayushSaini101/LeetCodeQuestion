class Solution {
    
    public int checkSum(int arr[],int sum1, int length){
        
        int sum=0;
        
        int max=0;
        
        for(int i=0;i<length;++i){
            
            sum+=arr[i];
            
        }
        max=Math.max(max,sum);
        
        for(int i=length;i<arr.length;++i){
            
            sum=(sum-arr[i-length])+arr[i];
            
            max=Math.max(max,sum);
        }
        
       // System.out.println(max+" "+length);
        
        return max;
    }
    public int minSubArrayLen(int target, int[] nums) {
        
        int start=1;
        
        int end=nums.length;
        
        int length=0;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(checkSum(nums,target,mid)>=target){
                
                length=mid;
                
                end=mid-1;
                
            }
            else{
                
                start=mid+1;
                
            }
        }
        
        return length;
    }
}