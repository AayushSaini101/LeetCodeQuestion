class Solution {
    public int findPeakElement(int[] arr) {
        int start=0;
        int end=arr.length-1;
        
        int answer=0;
        
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(mid<arr.length-1&&arr[mid]<arr[mid+1]){
               
                start=mid+1;
                answer=start;
            }
            else{
                end=mid-1;
            }
        }
        return answer;
    }
}