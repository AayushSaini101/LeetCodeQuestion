class Solution {
    class Custom{
        int si;
        int x;
        int y;
        Custom(int si, int x, int y){
            this.si=si;
            this.x=x;
            this.y=y;
        }
    }
    public int[] findBall(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        Queue<Custom> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.offer(new Custom(i,0,i));
        }
        while(!q.isEmpty()){
            Custom temp=q.poll();
            if(temp.x==m){
                ans[temp.si]=temp.y;
            }
            else{
                if(grid[temp.x][temp.y]==1){
                    if(temp.y+1<n && grid[temp.x][temp.y+1]!=-1){
                        q.offer(new Custom(temp.si,temp.x+1,temp.y+1));
                    }
                }
                if(grid[temp.x][temp.y]==-1){
                    if(temp.y-1>=0 && grid[temp.x][temp.y-1]!=1){
                        q.offer(new Custom(temp.si,temp.x+1,temp.y-1));
                    }
                }
            }
        }
        return ans;
        
    }
}