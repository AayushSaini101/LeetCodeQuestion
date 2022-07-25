class Solution {
   void update(int start, int end, int tree[],int node,int val){
            if(start == end && start == val){
                tree[node]++;
            }
            else{
                int mid = start + (end - start)/2;
                
                if(val <= mid){
                    update(start, mid, tree,2*node+1,val);
                }
                else{
                    update(mid+1, end, tree,2*node+2,val);
                }
                
                tree[node] = tree[2*node+1] + tree[2*node+2];
            }
        }
    
  int sum( int start, int end, int left, int right,int tree[],int node){
            if(end < left || start > right) return 0;
            if(left<= start && end<=right){
                return tree[node];
            }
            
            int mid = start + (end - start)/2;
            
            int l = sum( start, mid, left, right,tree,2*node+1);
            int r = sum( mid+1, end, left, right, tree,2*node+2);
            
            return l+r;
        }
    public List<Integer> countSmaller(int[] nums) {
        
        int value=(int)(Math.pow(10,4));
        
        for(int i=0;i<nums.length;++i){
            
            nums[i]+=value;
        }
    //    System.out.println(Arrays.toString(nums));
        
           // int n = (int) Math.pow(10, 5)+1;
           // int temp = (int)(Math.ceil(Math.log(n)/Math.log(2)));
            //int  treeSize = (int) (2*Math.pow(2, temp) - 1);
            
            int n=2*10000+1;
        
            int treeSize=4*n;
        
            int build[] = new int[treeSize];
        
           List<Integer>answer=new ArrayList<>();
        
        for(int i=nums.length-1;i>=0;--i){
            
            
            int count=sum(0,n-1,0,nums[i]-1,build,0);
            
            update(0,n-1,build,0,nums[i]);
            
           
            
            answer.add(count);
        }
        
        Collections.reverse(answer);
        
        return answer;
    }
}