class Solution {
    public class Pair{
        int max_index;
        int value;
        int original_index=0;
        Pair(int max_index,int value,int index){
            this.max_index=max_index;
            this.value=value;
            this.original_index=index;
        }
    }
    public int largestRectangleArea(int[] heights) {
    Stack<Pair>S=new Stack<>();
        
    int max=0;
        
    for(int i=0;i<heights.length;++i){
        int index=-1;
        
        while(S.size()!=0&&heights[S.peek().original_index]>heights[i]){
           Pair height=S.pop(); 
            max=Math.max(max,height.value*(i-height.max_index));
            index=height.max_index;       
        }
        if(index!=-1)
        S.add(new Pair(index,heights[i],i));
        else{
            S.add(new Pair(i,heights[i],i));
        }
        
    }
      
        int length=heights.length;
        
        while(S.size()!=0){
         Pair ob=S.pop();
            max=Math.max(max,ob.value*(length-ob.max_index));
              
        }
        return max;
    }
}