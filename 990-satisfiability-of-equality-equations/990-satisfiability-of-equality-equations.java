class Solution {
    
    public int find(int parent[],int index){
        
        if(parent[index]==-1)return index;
        
        return parent[index]=find(parent,parent[index]);
    }
    public void union(int parent[],int u,int v){
        
        int parentu=find(parent,u);
        
        int parentv=find(parent,v);
        
        if(parentu!=parentv){
            
            parent[parentv] = parentu;
        }
    }
    
    public boolean check(int parent[],int u,int v){
        
      
        return find(parent,u)==find(parent,v);
    }
    
    public boolean equationsPossible(String[] equations) {
        
        int build[] = new int[27];
        
        Arrays.fill(build,-1);
        
        for(int i=0;i<equations.length;++i){
            
            String str=equations[i];
            
            int u=str.charAt(0)-'a';
            
            int v=str.charAt(str.length()-1)-'a';
            
            if(str.charAt(1)!='!'){
                
                union(build,u,v);
            }
        }
        
        for(int i=0;i<equations.length;++i){
            
            String str=equations[i];
            
            int u=str.charAt(0)-'a';
            
            int v=str.charAt(str.length()-1)-'a';
            
            if(str.charAt(1)=='!'){
                
                if(check(build,u,v)){
                    
                    return false;
                }
            }
            
            
        }
        return true;
        
        
        
       
    }
}