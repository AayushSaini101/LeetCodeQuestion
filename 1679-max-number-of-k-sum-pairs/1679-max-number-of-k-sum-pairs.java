class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer>H=new HashMap<>();
        for(int elements:nums){
            H.put(elements,H.getOrDefault(elements,0)+1);
        }
        int count=0;
        for(int i=0;i<nums.length;++i){
            if(H.containsKey(k-nums[i])){
                 if(nums[i]==k-nums[i]){
                     if(H.get(nums[i])<2){
                         continue;
                     }
                     else{
                         ++count;
                         H.put(nums[i],H.get(nums[i])-2);
                         if(H.get(nums[i])<2){
                             H.remove(nums[i]);
                         }
                     }
                 }
                else{
                    
                    if(H.containsKey(nums[i])&&H.containsKey(k-nums[i])){
                      
                        ++count;
                        H.put(nums[i],H.get(nums[i])-1);
                        H.put(k-nums[i],H.get(k-nums[i])-1);
                        if(H.get(nums[i])==0){
                            H.remove(nums[i]);
                        }
                        if(H.get(k-nums[i])==0){
                            H.remove(k-nums[i]);
                        }
                        
                    }
                    
                    
                }
                
            }
        }
        return count;
        
    }
}