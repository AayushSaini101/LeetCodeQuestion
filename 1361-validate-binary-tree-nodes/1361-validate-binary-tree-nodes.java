class Solution {
    public boolean can(int parent[],int i,int value){
       if(parent[i]==value){
           return false;
       }
       if(parent[i]==-1){
           return true;
       } 
     return can(parent,parent[i],value);
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
       //Array for storing the parent value 
        //One node have its only one root node
        int parent[]=new int[n];
        
        Arrays.fill(parent,-1);
        
        int flag=0;
        
        for(int i=0;i<n;++i){
            //The i will the the root node 
            int left_child=leftChild[i];
            
            int right_child=rightChild[i];
            
            if(left_child==i||right_child==i){
                return false;
            }
           
            
            if(left_child!=-1){
              
                //Can we join the left node 
                if(parent[left_child]!=-1){
                    return false;
                }
                if(can(parent,i,left_child)==false){
                    return false;
                }
                else{
                    parent[left_child]=i;
                }
                
                 
            
            }
            if(right_child!=-1){
                  if(parent[right_child]!=-1){
                    return false;
                }
                //can we join the right node 
                  if(can(parent,i,right_child)==false){
                    return false;
                }
                else{
                    parent[right_child]=i;
                }
                
                
            }
            
          
        }
        int count=0;
      for(int elements:parent){
        if(elements==-1){
            ++count;
        }
      }
    return count==1;
        
    }
}