class Solution {
    public void find(int nums[],int index,List<Integer>ans,List<List<Integer>>ans1){
        if(index>=nums.length){
            
       List<Integer>anss=new ArrayList<>();
            anss.addAll(ans);
            ans1.add(anss);
            return;
        }
        //Include the answer not include the answer;
        ans.add(nums[index]);
        find(nums,index+1,ans,ans1);
        ans.remove(ans.size()-1);
        find(nums,index+1,ans,ans1);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
       
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>anss=new ArrayList<>();
         find(nums,0,anss,ans);
        return ans;
    }
}