class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        for(int i=1;i<travel.length;++i){
            
            travel[i]+=travel[i-1];
        }
        int cost[][]=new int[garbage.length][3];
        
        for(int i=0;i<garbage.length;++i){
            
            String str=garbage[i];
            
            int first=0;
            
            int second=0;
            
            int third=0;
                
            
            for(int j=0;j<str.length();++j){
                
                
                char ch=str.charAt(j);
                
                if(ch=='M')++first;
                else
                    if(ch=='P')++second;
                else{
                    ++third;
                }
            }
            
            if(i==0){
                
                cost[i][0]=first;
                    
                cost[i][1]=second;
                
                cost[i][2]=third;
            }
            else{
                
                if(first!=0){
                    
                    cost[i][0]+=cost[i-1][0]+first;
                }
                if(second!=0){
                    
                    cost[i][1]+=cost[i-1][1]+second;
                }
                if(third!=0){
                    
                    cost[i][2]+=cost[i-1][2]+third;
                }
                
                if(first==0){
                    
                    cost[i][0]=cost[i-1][0];
                }
                if(second==0){
                    
                    cost[i][1]=cost[i-1][1];
                }
                if(third==0){
                    
                    cost[i][2]=cost[i-1][2];
                }
                
            }
             //System.out.println(cost[i][0]+" "+cost[i][1]+" "+cost[i][2]);
        }
       
        
       for(int i=0;i<3;++i){
           
           int index=0;
           
           for(int j=cost.length-1;j>=1;--j){
               
               if(cost[j][i]!=cost[j-1][i]){
                   
                   index=j;
                   
                   break;
               }
           }
           
           
           if(index!=0)
           cost[cost.length-1][i]+=travel[index-1];
       }
        
        return cost[cost.length-1][0]+cost[cost.length-1][1]+cost[cost.length-1][2];
        
      
    }
}