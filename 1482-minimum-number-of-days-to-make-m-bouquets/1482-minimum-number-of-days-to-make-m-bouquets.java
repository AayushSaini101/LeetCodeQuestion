class Solution {
    
    public boolean checkPossibleBlossom(int arr[],int m,int k,int days){
        
        if(k>arr.length)return false;
        
        int count=0;
        
        int num=k;
        
        for(int i=0;i<arr.length;++i){
        
             if(arr[i]<=days){
                 
                 --num;
             }
             else{
                 
                 num=k;
             }
            
            if(num==0){
                
                --m;
                
                num=k;
            }
        }
        return m<=0;
        
      
        
    }
    public int minDays(int[] bloomDay, int m, int k) {
        
        if(m>bloomDay.length) return -1;
     
     
        int start=1;
        
        int end=0;
        
        for(int elements:bloomDay){
        
            end=Math.max(end,elements);
            
        }
        
        int days=Integer.MAX_VALUE;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
           
            
            if(checkPossibleBlossom(bloomDay,m,k,mid)){
                
               // System.out.println(mid);
                
                days=Math.min(days,mid);
                
                end=mid-1;
                
            }
            
            else{
                
                start=mid+1;
                
            }
        }
        if(days==Integer.MAX_VALUE)return -1;
        
        return days;
    }
}