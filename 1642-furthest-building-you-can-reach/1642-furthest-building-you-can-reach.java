class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int sum=0;
        
        PriorityQueue<Integer>P=new PriorityQueue<>(Collections.reverseOrder());
        
        int count=0;
        
        for(int i=0;i<heights.length;++i){
            
            if(i!=0){
                if(heights[i-1]<heights[i]){
                    
                    int diff=heights[i]-heights[i-1];
                    
                    P.add(diff);
                    
                    sum+=diff;
                    
                    if(sum>bricks){
                        
                        //We have to find the place where we use can the ladder in the plac using of the bricks 
                        int peek=P.remove();
                        
                        if(sum-peek<=bricks){
                            
                            if(ladders!=0){
                                
                                sum-=peek;
                                
                                
                                
                                --ladders;
                            }
                            else{
                                
                                return i-1;
                            }
                            
                        }
                        
                        else{
                            return i-1;
                        }
                        
                        
                    }
                }
            }
        }
        
        return heights.length-1;
        
    }
}