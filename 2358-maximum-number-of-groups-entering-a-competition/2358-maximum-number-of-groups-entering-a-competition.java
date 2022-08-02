class Solution {
    
    public long check(int number){
        
        return (long)number*(number+1)/2;
    }
    public int maximumGroups(int[] grades) {
        
        int start=1;
        
        int end=grades.length;
        
        int answer=0;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(check(mid)<=grades.length){
             
                answer=mid;
                
                start=mid+1;
            }
            else{
                
                end=mid-1;
            }
        }
        return answer;
    }
}