class Solution {
    public int find(int parent[],int find){
      //This means it is a itself parent of the node
       if(parent[find]==find){
           return find;
       }
        return find(parent,parent[find]);
    }
    public void union(int parent[],int first,int second){
        int findFirst=find(parent,first);
        int findSecond=find(parent,second);
        
        parent[findFirst]=findSecond;
    }
    public int findCircleNum(int[][] arr) {
       //We can use the concept of the union find 
        //To tackle the probel
        int parent[]=new int[arr.length];
        for(int i=0;i<arr.length;++i){
            parent[i]=i;
        }
        
        //Connecting the nodes
        
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr[0].length;++j){
                //This is not connected to the node 
                if(arr[i][j]==0){
                    continue;
                }
                if(i<j){
                    //System.out.println(i+" "+j);
                    union(parent,i,j);
                }
            }
        }
        
        //Finding the connected components in the 
        
        int count=0;
        
        for(int i=0;i<parent.length;++i){
           // System.out.print(parent[i]+" ");
            if(parent[i]==i){
                ++count;
            }
        }
        return count;
        
    }
}