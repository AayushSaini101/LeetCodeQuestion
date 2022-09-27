class SparseVector {
    
    int first[];
    
    SparseVector(int[] nums) {
    
        this.first=nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
          int answer=0;
        
        for(int i=0;i<first.length;++i){
            
            answer+=vec.first[i]*first[i];
        }
        
        return answer;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);