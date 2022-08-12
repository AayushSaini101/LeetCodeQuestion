class Solution {
    
    public boolean check(int arr[],int value,int sum){
        
        int count=0;
        
        for(int i=0;i<arr.length;++i){
        
            count+=arr[i]/value+((arr[i]%value)!=0?1:0);
            
        }
        
        return count<=sum;
        
    }
    public int minimizedMaximum(int n, int[] quantities) {
        
        //Distributes the products among all the stores 
        
        int start=1;
        
        int end=0;
        
        for(int elements:quantities){
            
            end=Math.max(end,elements);
        }
        
        int answer=0;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(check(quantities,mid,n)){
                
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