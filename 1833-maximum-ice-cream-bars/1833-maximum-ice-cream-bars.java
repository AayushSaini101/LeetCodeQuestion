class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);
        
        int count=0;
        
        for(int elements:costs){
            
            if(elements<=coins){
                
                ++count;
                
                coins-=elements;
            }
            else{
                
                return count;
            }
        }
        return count;
    }
}