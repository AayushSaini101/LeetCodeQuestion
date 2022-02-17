class Solution {
    public void find(int index,int arr[],int sum,List<Integer>helper,List<List<Integer>>ans){
        if(index>=arr.length){
            return;
        }
        if(sum<0){
            return;
        }
        if(sum==0){
            ans.add(new ArrayList<>(helper));
            return;
        }
        helper.add(arr[index]);
        find(index,arr,sum-arr[index],helper,ans);
        helper.remove(helper.size()-1);
        find(index+1,arr,sum,helper,ans);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>helper=new ArrayList<>();
        find(0,candidates,target,helper,ans);
        return ans;
    }
}