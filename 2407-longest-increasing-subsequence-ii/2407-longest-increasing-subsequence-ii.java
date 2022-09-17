class Solution {
    
    public int search(int l, int r, int st, int end, int build[],int node){
        
        
       if(l > end || r < st) return 0;
        if(l >= st && r <= end) {
            return build[node];
        }
        int mid = l + (r - l) / 2;
        int res = search(l, mid, st, end, build,2 * node + 1);
        res = Math.max(res, search(mid + 1, r, st, end,build, 2 * node + 2));
        
        return res;
        
    }
    public  void update(int l, int r, int i, int value,int build[], int node){
        
      if(l == r) {
            build[node] = value;
            return;
        }
        int mid = l + (r - l) / 2;
        if(i <= mid) update(l, mid, i,value,build, 2 * node + 1);
        else update(mid + 1, r, i,value, build,2 * node + 2);
        build[node] = Math.max(build[node], Math.max(build[2 * node + 1], build[2 * node + 2]));
        
        
    }
    public int lengthOfLIS(int[] nums, int k) {
    
        int number=100001;
        
        int build[]=new int[4*number];
        
        int answer=0;
        
        for(int i=0;i<nums.length;++i){
            
            int max=search(1,number-1,Math.max(0,nums[i]-k),nums[i]-1,build,0);
            
        
            answer=Math.max(answer,max+1);
            
            update(1,number-1,nums[i],max+1,build,0);
        }
        
    //    System.out.println(Arrays.toString(build));
        
        return answer;
    }
}