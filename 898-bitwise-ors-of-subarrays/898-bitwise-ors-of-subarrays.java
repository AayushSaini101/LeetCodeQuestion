class Solution {
    Set<Integer>set;
    Set<Integer>dp[];
    void find(int index,int arr[],int num){
        if(index>=arr.length)return ;
        if(dp[index].contains(num))return ;
        dp[index].add(num);
        set.add(num|arr[index]);
        find(index+1,arr,0);
        find(index+1,arr,num|arr[index]);
        return ;
    }
    
    public int subarrayBitwiseORs(int[] arr) {
        set=new HashSet<>();
       dp=new HashSet[arr.length];
        for(int i=0;i<arr.length;i++)dp[i]=new HashSet<>();
        find(0,arr,0);
        return set.size();
    }
}