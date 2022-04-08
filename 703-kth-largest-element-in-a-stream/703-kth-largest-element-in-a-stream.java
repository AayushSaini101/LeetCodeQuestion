class KthLargest {
    //Using the priority Queue 
    
   PriorityQueue<Integer> pq= new PriorityQueue<>();  //we need to declare public pq and kth element
    int k;
    int max=-1;
    public KthLargest(int k, int[] nums) {
    for( int a: nums){
				pq.add(a);           //add all the elements in pq 
    }
        this.k=k;   //pointing k to global k
    }
    
    public int add(int val) {
        if(max!=-1){
            if(val<max){
                return max;
            }
        }
        
        pq.add(val);         //adding value in pq  no need to take care of nums array
        
        while(pq.size()>k){      //remove all the elements which we dont need  
				pq.remove();       // making the window of k size
        }
        return max=pq.peek();   //returning the peek element of queue

    
}
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */