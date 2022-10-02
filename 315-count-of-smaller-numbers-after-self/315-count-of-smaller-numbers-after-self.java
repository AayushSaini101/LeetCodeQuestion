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
    
    public int sum(int start,int end,int left,int right,int build[],int index){
        
         
          if(end < left || start > right) return 0;
            if(left<= start && end<=right){
                return build[index];
            }
        
        int mid=start+(end-start)/2;
        
        int left1=sum(start,mid,left,right,build,2*index+1);
        
        int right1=sum(mid+1,end,left,right,build,2*index+2);
        
        return left1+right1;
    }
     
           
    public List<Integer> countSmaller(int[] nums) {
        
        int value=(int)(Math.pow(10,4));
        
        for(int i=0;i<nums.length;++i){
            
            nums[i]+=value;
        }
       
          int n=4*100001;
            
          int build[] = new int[4*200001];
        
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