class Solution {
    
    class Pair{
        
        int first;
        
        int second;
        
        Pair(int first,int second){
            
            this.first=first;
            
            this.second=second;
        }
    }
    
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        //If we choose greddly method what can we do 
        
        List<Pair>lst=new ArrayList<>();
        
        for(int i=0;i<plantTime.length;++i){
            
            lst.add(new Pair(plantTime[i],growTime[i]));
        }
        
        Collections.sort(lst,(a,b)->b.second-a.second);
        
       
        int totalDays=0;
        
        int max=0;
        
        int start=0;
        
        for(int i=0;i<lst.size();++i){
            
            start+=lst.get(i).first;
            
            totalDays=Math.max(totalDays,start+lst.get(i).second);
            
        }
        
        return totalDays;
    
    }
}