class Solution {
    public int maxDistToClosest(int[] seats) {
        int left[]=new int[seats.length];
        
        int right[]=new int[seats.length];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        for(int i=0;i<seats.length;++i){
              if(seats[i]==1){
                  left[i]=i;
              }
            else
              if(i==0){
                  if(seats[i]==1){
                      left[i]=i;
                  }
              }
            else{
                left[i]=left[i-1];
            }
        }
         for(int i=seats.length-1;i>=0;--i){
              if(seats[i]==1){
                  right[i]=i;
              }
            else
              if(i==seats.length-1){
                  if(seats[i]==1){
                      right[i]=i;
                  }
              }
            else{
                right[i]=right[i+1];
            }
        }
       
       
      //Max(min)
        int ans=0;
        for(int i=0;i<seats.length;++i){
            if(seats[i]==0){
                if(left[i]!=-1&&right[i]!=-1){
                    ans=Math.max(ans,Math.min(i-left[i],right[i]-i));
                }
                else
                    
                    if(left[i]!=-1){
                         ans=Math.max(ans,i-left[i]);
                    }
                else
                    if(right[i]!=-1){
                        ans=Math.max(ans,right[i]-i);
                    }
            }
        }
        return ans;
        
        
    }
}