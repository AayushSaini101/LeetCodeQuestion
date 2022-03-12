class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer>H=new HashMap<>();
        
        int max=0;
        int value=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==key){
                if(i+1<nums.length){
                    H.put(nums[i+1],H.getOrDefault(nums[i+1],0)+1);
                }
            }
        }
        for(int elements:H.keySet()){
            if(H.get(elements)>max){
                max=H.get(elements);
                value=elements;
            }
        }
        return value;
        
    }
}