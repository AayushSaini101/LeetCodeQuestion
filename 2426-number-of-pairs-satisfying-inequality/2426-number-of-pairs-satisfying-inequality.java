class Solution {
    public class SegTree{
        private long[] tree;
        public SegTree(int n){
            tree=new long[4*n];
        }
        
        public void u(int pos){
            update(1,0,40000,pos,1);
        }
        private void update(int node,int start,int end,int pos,int val){
            if(start==end){
                tree[node]++;
            } else {
                int mid=(start+end)/2;
                if(start<=pos && pos<=mid){
                    update(node*2,start,mid,pos,val);
                } else {
                    update(node*2+1,mid+1,end,pos,val);
                }
                tree[node]=tree[node*2]+tree[node*2+1];
            }
        }
        
        public long q(int l,int r){
            return query(1,0,40000,l,r);
        }
        private long query(int node,int start,int end,int l,int r){
            if(end<l || r<start) return 0;
            
            if(start>=l && end<=r){
                return tree[node];
            } else {
                int mid=(start+end)/2;
                long left=query(2*node,start,mid,l,r);
                long right=query(2*node+1,mid+1,end,l,r);
                
                return left+right;
            }
        }
    }
    
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        SegTree seg=new SegTree(40000);
        int add=20000;
        int n=nums1.length;
        long count=0;
        // nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
        // nums1[i]-nums2[i] <= nums1[j]-nums2[j]+diff
        for(int i=0;i<n;i++){
            count+=seg.q(0,nums1[i]-nums2[i]+diff+add);
            seg.u(nums1[i]-nums2[i]+add);
        }
        
        return count;
    }
}