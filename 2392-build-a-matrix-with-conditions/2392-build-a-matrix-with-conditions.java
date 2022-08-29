class Solution {
    public List<Integer> sort(int arr[][],int k){
        
        List<List<Integer>>lst=new ArrayList<>();
        
        for(int i=0;i<=k;++i){
            
            lst.add(new ArrayList<>());
        }
        
        int indegree[]=new int[k];
        
        int element=0;
        
        List<Integer>number=new ArrayList<>();
        
        for(int i=0;i<arr.length;++i){
            
            int u = arr[i][0];
            
            int v = arr[i][1];
            
            lst.get(u).add(v);
            
            number.add(u);
            
            lst.get(v).add(u);
            
            indegree[v]++;
            
        }
        
        Queue<Integer>Q=new LinkedList<>();
        
       // System.out.println(number+" "+Arrays.toString(indegree));
        
        for(int i=1;i<indegree.length;++i){
            
            if(indegree[i]==0){
                
                Q.add(i);
                
            }
        }
        
        List<Integer>answer=new ArrayList<>();
        
        while(Q.size()!=0){
            
            int remove=Q.remove();
            
            answer.add(remove);
            
            for(int elements:lst.get(remove)){
                
                indegree[elements]--;
                
                if(indegree[elements]==0){
                    
                    Q.add(elements);
                }
                
            }
        }
        
        return answer;
        
        
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
      List<Integer>rowOrder=sort(rowConditions,k+1);
      
      List<Integer>colOrder=sort(colConditions,k+1);
        
    //  System.out.println(rowOrder+" "+colOrder);
     
   
     if(rowOrder.size()<k||colOrder.size()<k)return new int[0][0];
        
      int answer[][]=new int[k][k];
        
      int points[]=new int[k+1];
        
      for(int i=0;i<k;++i){
          
          points[colOrder.get(i)]=i;
      }
        
      for(int i=0;i<k;++i){
          
          answer[i][points[rowOrder.get(i)]]=rowOrder.get(i);
      }
        
      return answer;
    
     
    }
}