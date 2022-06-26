class Solution {
    public int maxScore(int[] cardPoints, int k) {
     
        //First approach is using the recursion to find out the maximum possible cases 
        //Memosiation of the recursive call the time compelxity will be k*n
        //Removing the subarray of the window n-k;
        int sum=0;
        
        int total=0;
        
        for(int elements:cardPoints){
            
            total+=elements;
        }
        
        int min=Integer.MAX_VALUE;
        
        int max=0;
        
        for(int i=0;i<cardPoints.length-k;++i){
            sum+=cardPoints[i];
        }
        min=Math.min(sum,min);
        
        max=Math.max(max,total-sum);
        
        for(int i=cardPoints.length-k;i<cardPoints.length;++i){
            
            sum-=cardPoints[i-(cardPoints.length-k)];
            
            sum+=cardPoints[i];
            
            max=Math.max(max,total-sum);
            
        }
        return max;
        
        
    }
}