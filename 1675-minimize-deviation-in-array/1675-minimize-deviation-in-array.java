class Solution {
    public int minimumDeviation(int[] nums) {
        // First create a priority Queue
        // and implemented a custom comperator, which help us in making this priority queue act like a max heap
        // concept of max heap states that, highest value should lie at the front of the queue & lowest value at the back of the queue
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a); // so we apply the custom comperator over here
        
        int min=Integer.MAX_VALUE; // creating minimum variable
        for(int i:nums){ // add these values in priority queue
            if(i%2==1) i*=2; // if value is odd mult. by 2 & make it even
            min=Math.min(min,i); // find the minimum
            pq.add(i);
        } // now we have the value in the priority queue, where we have convert all the odd's into even
        
        // let's find the maximum of all the value
        int diff=Integer.MAX_VALUE; 
        while(pq.peek()%2==0){ 
            int max=pq.remove(); // max will be at top of the queue
            diff=Math.min(diff,max-min); // find the difference
            min=Math.min(max/2,min);//minimum can change because, new value we are getting by half max can be lower then current minimum
            pq.add(max/2); // add that in the queue
        }
        
        return Math.min(diff,pq.peek()-min);
    }
}