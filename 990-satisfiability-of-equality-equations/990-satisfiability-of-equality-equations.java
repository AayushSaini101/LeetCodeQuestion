class Solution {
    
    public boolean findPossible(int u,int v,int parent,List<List<Integer>>lst,int dp[]){
        
        //Searching the node in the undirected graph
        
        boolean answer=false;
        
        dp[u]=1;
        
        for(int elements:lst.get(u)){
            
            if(elements!=parent&&dp[elements]==0){
                
                if(elements==v)return true;
                
                 dp[elements]=1;
                
                 answer|=findPossible(elements,v,u,lst,dp);
               
                 dp[elements]=0;
            }
        }
        
        return answer;
    }
    public boolean equationsPossible(String[] equations) {
        
        List<List<Integer>>lst=new ArrayList<>();
        
        //Consider these equations to be edges 
        
        for(int i=0;i<=27;++i){
            
            lst.add(new ArrayList<>());
        }
        
       
        
       for(int i=0;i<equations.length;++i){
           
           int u=equations[i].charAt(0)-'a';
           
           int v=equations[i].charAt(equations[i].length()-1)-'a';
           
           if(equations[i].charAt(1)!='!'){
               
               //connect the node 
               
               lst.get(u).add(v);
               
               lst.get(v).add(u);
           }
       }
        
        //The graph has been made just we need to check wether we can reach from the not equal node in the graph 
        
        
        for(int i=0;i<equations.length;++i){
            
           int u=equations[i].charAt(0)-'a';
           
           int v=equations[i].charAt(equations[i].length()-1)-'a';
            
             int dp[]=new int[26];
           
           if(equations[i].charAt(1)=='!'){
               
               if(u==v)return false;
               //connect the node 
               
               if(findPossible(u,v,-1,lst,dp))return false;
           }
            
        }
        
        return true;
    }
}