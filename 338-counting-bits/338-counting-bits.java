class Solution {
    public int[] countBits(int n) {
        int answer[]=new int[n+1];
        
        for(int i=0;i<=n;++i){
            int count=0;
            for(int j=31;j>=0;--j){
                if((i&(1<<j))!=0){
                    ++count;
                }
            }
            answer[i]=count;
        }
        return answer;
    }
}