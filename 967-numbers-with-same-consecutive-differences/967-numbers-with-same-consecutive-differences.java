class Solution {
    public void createNumbers(int dp[],int index,List<Integer>answer,int k,int n){
        
        if(index==n){
            
            int number=0;
            
            for(int i=0;i<dp.length;++i){
                
                number=number*10+dp[i];
            }
            
            answer.add(number);
            
            return ;
        }
        
        for(int i=0;i<=9;++i){
            
            if(index==0&&i==0)continue;
            
            else
                if(index==0){
                    
                    dp[index]=i;
                    
                    createNumbers(dp,index+1,answer,k,n);
                }
            else{
                
                if(Math.abs(dp[index-1]-i)==k){
                    
                    dp[index]=i;
                    
                    createNumbers(dp,index+1,answer,k,n);
                }
            }
        }
        
        
    }
    public int[] numsSameConsecDiff(int n, int k) {
        
       List<Integer>answer=new ArrayList<>();
        
       int dp[]=new int[n];
        
       createNumbers(dp,0,answer,k,n);
        
       int numbers[]=new int[answer.size()];
        
       for(int i=0;i<answer.size();++i){
           
           numbers[i]=answer.get(i);
       }
        
        return numbers;
    }
}