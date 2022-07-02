class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
       //Maximum horizontal cut and maximum vertical cut in the edge  we need to check teh 
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long first=horizontalCuts[0];
        long second=verticalCuts[0];
        
        long mod=(long)(1e9+7);
        for(int i=0;i<horizontalCuts.length;++i){
            
            if(i!=0){
                first=Math.max(horizontalCuts[i]-horizontalCuts[i-1],first);
            }
        }
        first=Math.max(first,h-horizontalCuts[horizontalCuts.length-1]);
        
        for(int i=0;i<verticalCuts.length;++i){
            
            if(i!=0){
                second=Math.max(verticalCuts[i]-verticalCuts[i-1],second);
            }
        }
        second=Math.max(second,w-verticalCuts[verticalCuts.length-1]);
        
        return (int)((first%mod*second%mod)%mod);
        
        
    }
}