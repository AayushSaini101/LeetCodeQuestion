class Solution {
    public void find(int index,int nums[],List<Integer>helper,List<List<Integer>>ans,int dp[],int count){
        
        if(count==nums.length){
          //  System.out.println(helper);
            ans.add(new ArrayList<>(helper));
            return;
        }
        //Use the number 
        for(int i=0;i<nums.length;++i){
            //use the value
            if(dp[i]==0){
                dp[i]=1;
                helper.add(nums[i]);
                find(i+1,nums,helper,ans,dp,count+1);
                helper.remove(helper.size()-1);
                dp[i]=0;
            }
            
        }
    }
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>>L=new ArrayList<>();
      List<Integer>helper=new ArrayList<>();  
      int dp[]=new int[nums.length+1];
       int count=0;
      find(0,nums,helper,L,dp,0);  
        return L;
    }
}