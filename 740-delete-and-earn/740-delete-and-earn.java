class Solution {
    public int max(int index,List<Integer>L,TreeMap<Integer,Integer>T,int dp[]){
        if(index<0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int first=0;
        if(index-1>=0&&L.get(index-1)+1==L.get(index))
        first=L.get(index)*T.get(L.get(index))+max(index-2,L,T,dp);
        else
            first=L.get(index)*T.get(L.get(index))+max(index-1,L,T,dp);
        int second=max(index-1,L,T,dp);
        dp[index]= Math.max(first,second);
        return dp[index];
    }
    public int deleteAndEarn(int[] nums) {
    TreeMap<Integer,Integer>T=new TreeMap<>();
    for(int i=0;i<nums.length;++i){
        int value=nums[i];
        T.put(value,T.getOrDefault(value,0)+1);
    }
    
    List<Integer>L= new ArrayList<Integer>(T.keySet());
    int dp[]=new int[L.size()];
    Arrays.fill(dp,-1);

    return max(L.size()-1,L,T,dp);
        
    }
}