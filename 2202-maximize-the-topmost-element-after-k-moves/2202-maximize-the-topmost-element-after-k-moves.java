class Solution {
    static class Pair implements Comparable<Pair>{
        int index;
        int value;
        Pair(int index,int value){
            this.index=index;
            this.value=value;
        }
        @Override
        
        public int compareTo(Pair second){
            if(this.value==second.value){
                return this.index-second.index;
            }
            else{
                return second.value-this.value;
            }
        }
    }
    public int maximumTop(int[] nums, int k) {
         if(k==0){
            return nums[0];
        }
        else
            if(k==1){
                if(nums.length==1){
                    return -1;
                }
                else{
                    return nums[1];
                }
            }
      else{
          
          if(nums.length==1){
              if(k%2==1){
                  return -1;
              }
              else{
                  return nums[0];
              }
          }
          
      }      
       
       
       
      PriorityQueue<Pair>P=new PriorityQueue<>();
        
        for(int i=0;i<nums.length;++i){
            P.add(new Pair(i,nums[i]));
        }
        int max=-1;
        
        while(P.size()!=0){
         Pair remove=P.remove();
           
            //We cannot fetch this elements from the pile 
            if(remove.index>k){
                continue;
            }
            else
                if(remove.index==0){
                    if(k>1)
                    max=Math.max(max,remove.value);
                }
           
          else{
              
            if(remove.index<=k){
                int diff=k-remove.index;
                if(diff!=1)
                max=Math.max(max,remove.value);
            }
              
          
             
          }
         
        
      
        
    }
          return max;
    }
}