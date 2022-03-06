class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>>lst=new ArrayList<>();
        List<TreeSet<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;++i){
            lst.add(new ArrayList<>());
            ans.add(new TreeSet<>());
            
        }
        
        int indegree[]=new int[n];
        
        for(int i=0;i<edges.length;++i){
            
            lst.get(edges[i][0]).add(edges[i][1]);
             
            indegree[edges[i][1]]++;
        }
        
        Queue<Integer>Q=new LinkedList<>();
        
        for(int i=0;i<indegree.length;++i){
            
            if(indegree[i]==0){
                //Adding the edge in the list
                Q.add(i);
            }
        }
        
        while(Q.size()!=0){
            
            int remove=Q.remove();
            
            for(int elements:lst.get(remove)){
                
                ans.get(elements).add(remove);
                
                ans.get(elements).addAll(ans.get(remove));
                
                indegree[elements]--;
                
                if(indegree[elements]==0){
                    
                    Q.add(elements);
                }
            }
            
        }
        
        List<List<Integer>>answer=new ArrayList<>();
        
        for(int i=0;i<n;++i){
            answer.add(new ArrayList<>());
            answer.get(i).addAll(ans.get(i));
        }
        return answer;
    }
}