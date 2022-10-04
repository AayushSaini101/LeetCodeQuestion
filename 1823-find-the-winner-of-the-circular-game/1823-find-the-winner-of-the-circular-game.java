class Solution {
    
    public int find(int n,int k){
        
         if(n==1){
            
            return 0;
        }
        
        int position=find(n-1,k);
        
        return ((position)+k)%n;
    }
    public int findTheWinner(int n, int k) {
        
        
        int answer=find(n,k);
        
        System.out.println(answer);
        
        return answer+1;
       
        
    }
}