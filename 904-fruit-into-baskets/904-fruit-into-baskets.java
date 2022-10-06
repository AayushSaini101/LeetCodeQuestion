class Solution {
    public int totalFruit(int[] fruits) {
       
        int  max=0;
        
        int count=0;
        
        Map<Integer,Integer>H=new HashMap<>();
        
        int left=-1;
        
        for(int i=0;i<fruits.length;++i){
        
            H.put(fruits[i],H.getOrDefault(fruits[i],0)+1);
            
            while(H.size()>2&&left<fruits.length){
        
                ++left;
                
                count-=1;
                
                if(H.get(fruits[left])==1){
                    
                    H.remove(fruits[left]);
                }
                else
                
                 H.put(fruits[left],H.get(fruits[left])-1);
                
                
            }
            
            ++count;
            
            max=Math.max(max,count);
            
        }
        
        return max;
    }
}