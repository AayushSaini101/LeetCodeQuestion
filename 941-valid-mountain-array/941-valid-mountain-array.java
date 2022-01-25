class Solution {
    public boolean validMountainArray(int[] arr) {
     int incr[]=new int[arr.length];
     int decr[]=new int[arr.length];
     
     Arrays.fill(incr,1);
     Arrays.fill(decr,1);
        
    for(int i=1;i<arr.length;++i){
       if(arr[i-1]<arr[i]){
           incr[i]=incr[i-1]+1;
       }
    }
        for(int i=arr.length-2;i>=0;--i){
               if(arr[i]>arr[i+1]){
                   decr[i]=decr[i+1]+1;
               }
        }
     for(int i=1;i<arr.length-1;++i){
         if(incr[i]+decr[i]-1==arr.length){
             return true;
         }
     }   
        return false;
    }
}