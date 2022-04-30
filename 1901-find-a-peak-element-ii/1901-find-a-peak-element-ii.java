class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int x=0;
        int y=0;
        int max=0;
        for(int i=0;i<mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(max<mat[i][j]){
                    max=mat[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        return new int[]{x,y};
    }
}