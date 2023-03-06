class Solution {
    public int findKthPositive(int[] arr, int k) {

        int start=0;
        
        int end=arr.length-1;
        
        int index=-1;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if((arr[mid]-(mid+1))<k){
                
                index=mid;
                
                start=mid+1;
            }
            else{
                
                end=mid-1;
            }
            
           // System.out.println(mid+" "+start+" "+end);
        }
        
        return index+k+1;
        
      
    }
}