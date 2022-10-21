class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer,Integer>H=new HashMap<>();
        
        for(int i=0;i<nums.length;++i){
            
            if(H.containsKey(nums[i])==false){
                
                H.put(nums[i],i);
            }
            else{
                
                if(Math.abs(i-H.get(nums[i]))<=k)return true;
                
                H.put(nums[i],i);
            }
        }
        
        return false;
    }
}