class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>P=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int elements:stones){
            P.add(elements);
        }
        if(P.size()==1){
            return P.peek();
        }
        while(P.size()!=0&&P.size()>1){
            
            int first=P.remove();
            int second=P.remove();
            
            if(first!=second){
                P.add(Math.abs(first-second));
            }
        }
        if(P.size()==0){
            return 0;
        }
        return P.peek();
        
        
        
    }
}