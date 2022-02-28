class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return new LinkedList<>();
        }
      //Smallest sorted list of the ranges 
       //Range must be sorted and containing elements in that is present in the array 
        int start=0;
        
        List<String>lst=new ArrayList<>();
        int i=0;
        for( i=1;i<nums.length;++i){
            if(nums[i-1]+1==nums[i]){
                continue;
            }
            else{
                //it ith value is not same 
                int index=i-1;
                if(start==index){
                    lst.add(nums[start]+"");
                }
                else{
                    lst.add(nums[start]+"->"+nums[index]);
                }
                start=i;
                
            }
        }
        i=Math.min(nums.length-1,i);
        if(i==start){
            lst.add(nums[i]+"");
        }
        else{
            lst.add(nums[start]+"->"+nums[i]);
        }
        return lst;
        
        
    }
}