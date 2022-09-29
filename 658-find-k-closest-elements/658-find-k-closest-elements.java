class Solution {
    
    class Pair{
        
        int element;
        
        int diff;
        
        Pair(int element,int diff){
            
            this.element=element;
            
            this.diff=diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        PriorityQueue<Pair>P=new PriorityQueue<>(new Comparator<Pair>(){
            
            @Override
            public int compare(Pair first,Pair second){
                
                if(first.diff<second.diff){
                    
                    return -1;
                    
                }
                else
                    if(first.diff==second.diff){
                        
                        return first.element-second.element;
                    }
                else{
                
                    return 1;
                }
            }
            
        });
        
        for(int i=0;i<arr.length;++i){
            
            P.add(new Pair(arr[i],Math.abs(arr[i]-x)));
        }
        
        List<Integer>answer=new ArrayList<>();
        
        while(P.size()!=0&&k-->0){
            
           // System.out.println(P.peek().element+" "+P.peek().diff);
            
            answer.add(P.remove().element);
        }
        
        Collections.sort(answer);
        
        return answer;
        
    }
}