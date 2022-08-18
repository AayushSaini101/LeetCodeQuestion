class Solution {
    
    class Pair{
        
        int first;
        
        int second;
        
        Pair(int first,int second){
            
            this.first=first;
            
            this.second=second;
        }
    }
    
    public int minSetSize(int[] arr) {
    
        
        HashMap<Integer,Integer>H=new HashMap<>();
        
        PriorityQueue<Pair>P=new PriorityQueue<Pair>((a,b)->b.second-a.second);
        
        
        for(int elements:arr){
            
            H.put(elements,H.getOrDefault(elements,0)+1);
        }
        
        for(int elements:H.keySet()){
            
            P.add(new Pair(elements,H.get(elements)));
            
        }
        
        int count=0;
        
        
        int sum=0;
        
        while(P.size()!=0){
            
            
            sum+=P.remove().second;
            
            ++count;
            
            if(sum>=arr.length/2){
                
                break;
            }
            
        }
        
        return count;
    }
}