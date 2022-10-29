class Solution {

    public void dfs(List<List<Integer>>lst,int index,int status[]){
        
       status[index]=1;
        
        for(int elements:lst.get(index)){
            
            if(status[elements]==0){
                
                status[elements]=1;
                
                dfs(lst,elements,status);
            }
        }
        
    }
    //Finding the isolate cluster of the nodes of the computer inorder to find the connected 
    public int makeConnected(int n, int[][] connections) {
    
        //Not possible to construct the connection to all the computers 
        
        if(connections.length<n-1){
            
            return -1;
        }
        
        int status[]=new int[n];
        
        List<List<Integer>>lst=new ArrayList<>();
        
        for(int i=0;i<=n;++i){
            
            lst.add(new ArrayList<>());
        }
        
        for(int i=0;i<connections.length;++i){
            
            int u=connections[i][0];
            
            int v=connections[i][1];
            
            lst.get(u).add(v);
            
            lst.get(v).add(u);
        }
        
        int count=0;
        
        for(int i=0;i<n;++i){
            
            if(status[i]==0){

                
                dfs(lst,i,status);
                
              //  System.out.println(i);
                
                
                ++count;
            }
        }
        
        return count-1;
        
      
    }
}