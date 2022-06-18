/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    
    class Pair{
        
        int first;
        int second;
        
        Pair(int first,int second){
            
            this.first=first;
            this.second=second;
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> lst) {
        
        List<Pair>pair=new ArrayList<>();
        
        List<Interval>answer=new ArrayList<>();
        
        for(List<Interval>elements:lst){
            
            for(int i=0;i<elements.size();++i){
                
                pair.add(new Pair(elements.get(i).start,elements.get(i).end));
            }
          
       }
        
      Collections.sort(pair,(a,b)->a.first==b.first?b.second-a.second:a.first-b.first);
        
     
     int max=0;
        
     
        
     for(int i=0;i<pair.size();++i){
         
        
         
         if(i==0){
             max=pair.get(i).second;
         }
         else{
             if(pair.get(i).first>max){
                 //This is the free time 
                 answer.add(new Interval(max,pair.get(i).first));
                 
                 
             }
             max=Math.max(max,pair.get(i).second);
                 
             
         }
     }
        
     return new ArrayList<>(answer);
        
     
        
    
      
        
    }
}