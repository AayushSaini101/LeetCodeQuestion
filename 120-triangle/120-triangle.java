class Solution {
    public int findMaximumSum(int index,List<List<Integer>>lst,int startingIndex,int dp[][]){
        if(index>=lst.size()){
            return 0;
        }
        if(startingIndex>=lst.get(index).size()){
            return 100000;
        }
        
        if(dp[index][startingIndex]!=Integer.MAX_VALUE){
            return dp[index][startingIndex];
        }
        
        
        //There are two choices either pick the current index or pick the currentindex+1
        int first=lst.get(index).get(startingIndex)+findMaximumSum(index+1,lst,startingIndex,dp);
         
        int second=lst.get(index).get(startingIndex)+findMaximumSum(index+1,lst,startingIndex+1,dp);
        
        return dp[index][startingIndex]=Math.min(first,second);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
    int dp[][]=new int[201][201];
    
    for(int i=0;i<dp.length;++i){
        for(int j=0;j<dp.length;++j){
            dp[i][j]=Integer.MAX_VALUE;
        }
    }
    
    return findMaximumSum(0,triangle,0,dp);
    }
}