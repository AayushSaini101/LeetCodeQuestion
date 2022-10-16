class Solution {
    
    
    public void build(int left,int right,int arr[],int build[],int index){
        
        if(left==right){
            
            build[index]=arr[left];
            
            return ;
        }
        
        int mid=(left+right)>>1;
        
        build(left,mid,arr,build,2*index+1);
        
        build(mid+1,right,arr,build,2*index+2);
        
        build[index]=Math.max(build[2*index+1],build[2*index+2]);
        
    }
    
      int getMid(int s, int e)
    {
        return s + (e - s) / 2;
    }
    
     int find(int[] st, int ss,
                       int se, int l,
                       int r, int node)
    {
 
        // If segment of this node is completely
        // part of given range, then return
        // the max of segment
        if (l <= ss && r >= se)
            return st[node];
 
        // If segment of this node does not
        // belong to given range
        if (se < l || ss > r)
            return -1;
 
        // If segment of this node is partially
        // the part of given range
        int mid = getMid(ss, se);
 
        return Math.max(
            find(st, ss, mid, l, r,
                     2 * node + 1),
            find(st, mid + 1, se, l, r,
                    2 * node + 2));
    }
    
    public int find(int left,int right,int k,int arr[],int dp[][][],int build[]){
        
        if(left==arr.length&&k==0){
            
         //   System.out.println(left+" "+right);
            
            return 0;
        }
        
        
        if(left>right||k<0){
            
            return 1000000;
        }
        
        if(dp[left][right][k]!=-1)return dp[left][right][k];
        
        
        int answer=0;
        
        int value=Integer.MAX_VALUE;
        
        int max=0;
        
        for(int i=left;i<=right;++i){
            
             //We need to find the max value from left to i 
            
              max=find(build,0,arr.length-1,left,i,0);
            
          
        
               int nextMax=find(i+1,right,k-1,arr,dp,build);
            
            
              value=Math.min(value,max+nextMax);
            
            
            
        }
        
        return dp[left][right][k]=value;
    }
    public int minDifficulty(int[] arr, int d) {
        
        if(d>arr.length)return -1;
        
        
        int dp[][][]=new int[arr.length+1][arr.length+1][d+1];
        
        
        for(int i=0;i<dp.length;++i){
            
            for(int j=0;j<dp.length;++j){
                
                for(int k=0;k<=d;++k){
                    
                    dp[i][j][k]=-1;
                }
            }
        }
    
        int build[]=new int[4*arr.length+1];
        
        build(0,arr.length-1,arr,build,0);
        
       // System.out.println(Arrays.toString(build));
        
        return find(0,arr.length-1,d,arr,dp,build);
        
        
        
    }
}