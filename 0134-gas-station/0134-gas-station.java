class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int index=0;
      int min=Integer.MAX_VALUE;
       int cost1=0;
      for(int i=0;i<gas.length;++i){
          cost1+=gas[i]-cost[i];
          
          if(min>cost1){
              min=cost1;
            
          }
      }
        if(cost1<0){
            return -1;
        }
        cost1=0;
        for(int i=0;i<gas.length;++i){
            cost1+=gas[i]-cost[i];
            if(cost1==min){
                return (i+1)%gas.length;
            }
        }
        return -1;
    }
}