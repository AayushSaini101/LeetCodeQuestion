class Solution {
    
    public int find(long a,long b,int mod){
        
        
        long answer=1l;
        
        while(b>0){
        
            if((b&1)!=0){
                
                answer=(answer*a)%mod;
            }
            
            a=((long)a*a)%mod;
            
            b/=2;
            
            
        }
        
        return (int)answer;
    }
    public int countWays(int[][] ranges) {
     
        //Counting the overllapping intervals 
        
        int count=1;
        
        Arrays.sort(ranges,(a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        
    //    int count=0;
        
        int previous=-1;
        
        boolean check=false;
        
        for(int i=0;i<ranges.length;++i){
            
     //  
          //  System.out.println(ranges[i][0]+" "+ranges[i][1]);
            
            if(previous==-1){
                
                previous=ranges[i][1];
                
                continue;
            }
            else
                if(ranges[i][0]<=previous){
                    
                    previous=Math.max(previous,ranges[i][1]);
                         
                    
                    
                }
            else{
                
              
                
                    ++count;
                
             
                
                previous=ranges[i][1];
            }
            
        }
        
        System.out.println(count);
         
            
       
        return find(2,count,(int)1e9+7);
        
    }
}