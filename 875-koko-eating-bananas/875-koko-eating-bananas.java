class Solution {
    public boolean can(int value,int piles[],int h){
      
        int count_hours=0;
        
        for(int i=0;i<piles.length;++i){
            
            if(piles[i]<=value){
                ++count_hours;
            }
            else{
                count_hours+=(int)Math.ceil((double)piles[i]/value);
            }
        }
        return (count_hours<=h)?true:false;
     
    }
    public int minEatingSpeed(int[] piles, int h) {
        //All piles should be eat before the h hour 
        
        int start=1;
        
        int end=0;
        
        for(int elements:piles){
            
            end=Math.max(elements,end);
        }
        
        int answer=0;
        
        while(start<=end){
          
            int mid=(start+end)>>1;
          
            if(can(mid,piles,h)){
                answer=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            
        }
        return answer;
    }
}