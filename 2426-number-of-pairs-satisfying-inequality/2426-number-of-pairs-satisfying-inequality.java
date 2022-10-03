class Solution {

    long build[];
    
    Solution(){
        
        build=new long[4*40001];
    }
    public void update(int l,int r,int tar,int ind){
        
       if(l>tar || r< tar)return;
            if(l==r){
                build[ind]++;
                return;
            }
            int m=l+(r-l)/2;
            update(l,m,tar,2*ind+1);
            update(m+1,r,tar,2*ind+2);
            build[ind]=build[2*ind+1]+build[2*ind+2];
        
        }
    
    
    public long query(int l,int r,int ind,int low,int high){
            if(l>high || r<low)return 0;
            if(low<=l && high>=r){
                return build[ind];
            }
            int m=l+(r-l)/2;
            return query(l,m,2*ind+1,low,high)+query(m+1,r,2*ind+2,low,high);
        }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        
        long countPairs=0;
        
        
         int arr[]=new int[nums1.length];
        
         int top=40000,add=20000;
        
        for(int i=0;i<arr.length;++i){
            
            countPairs+=query(0,top,0,0,nums1[i]-nums2[i]+add+diff);
            
            update(0,top,nums1[i]-nums2[i]+add,0);
        }
        
        return countPairs;
        
    }
}