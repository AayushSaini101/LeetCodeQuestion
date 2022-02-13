class Solution {
    public long minimumRemoval(int[] beans) {
     
        HashMap<Integer,Integer>H=new HashMap<>();
        
        for(int elements:beans){
            H.put(elements,H.getOrDefault(elements,0)+1);
        }
        
        Arrays.sort(beans);
        
        long suffix[]=new long[beans.length];
        for(int i=beans.length-1;i>=0;i--){
            if(i==beans.length-1){
                suffix[i]=beans[i];
            }
            else{
                suffix[i]=suffix[i+1]+beans[i];
            }
        }
        
        long min=Long.MAX_VALUE;
        
        long sum=0;
        
        HashMap<Integer,Integer>Previous=new HashMap<>();
        
        for(int i=0;i<beans.length;++i){
            
           long decrease=0;
          if(Previous.containsKey(beans[i])){
              decrease=(long)Previous.get(beans[i])*beans[i];
          }
         long cost=sum-decrease+suffix[i]-(long)(beans.length-i)*beans[i];
            
        min=Math.min(min,cost);
            
            
            sum+=beans[i];
            
        }
        return min;
        
    }
}