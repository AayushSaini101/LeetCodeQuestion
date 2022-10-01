class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
      
        if(nums1.length%2==0&&nums2.length%2==0)return 0;
        
        int answer=0;
        
        if(nums1.length%2==1){
            
            for(int elements:nums2){
                
                answer^=elements;
            }
        }
        
       // System.out.println(answer);
        
        if(nums2.length%2==1){
            
            for(int elements:nums1){
                
                answer^=elements;
            }
        }
        
      
        
        return answer;
    }
}