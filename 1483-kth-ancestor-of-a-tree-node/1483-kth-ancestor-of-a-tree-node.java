class TreeAncestor {
    
    int build[][];

    public TreeAncestor(int n, int[] parent) {
        build=new int[32][n];
        
        //Filling the first parent of the every node of the treee
        for(int i=0;i<n;++i){
            //Filling the first parent of the every node of the tree
            build[0][i]=parent[i];
        }
        for(int i=1;i<=31;++i){
            for(int j=0;j<n;++j){
                //Filling the i the level of the tree
                //Find the above parent(parent )
                if(build[i-1][j]==-1){
                    build[i][j]=-1;
                    continue;
                }
                build[i][j]=build[i-1][build[i-1][j]];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        
        int answer=0;
        for(int i=0;i<=31;i++){
            if((k&(1<<i))!=0){
                
                answer=build[i][node];
                if(answer==-1){
                    return -1;
                }
                else{
                    node=answer;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */