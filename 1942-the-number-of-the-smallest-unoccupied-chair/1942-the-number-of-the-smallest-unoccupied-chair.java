class Solution {
    public class Pair{
        int start=0;
        int ending=0;
        int index=0;
        int chair=0;
        Pair(int start,int ending,int index){
            this.start=start;
            this.ending=ending;
            this.index=index;
        }
        Pair(int start,int ending,int index,int chair){
            this.start=start;
            this.ending=ending;
            this.index=index;
            this.chair=chair;
        }
    
    }
    
    public int smallestChair(int[][] times, int targetFriend) {
       List<Pair>L=new ArrayList<>();
       for(int i=0;i<times.length;++i){
           L.add(new Pair(times[i][0],times[i][1],i));
       }
        //Sorting the person in the increasing order of the time
         Collections.sort(L,(a,b)->a.start-b.start);
        //Finding the position of the target friend
        int position=0;
        
        for(int i=0;i<L.size();++i){
          
            if(L.get(i).index==targetFriend){
               
                break;
            } 
            ++position;
        }
       // System.out.println(position);
        if(position==0){
            return 0;
        }
        else{
            PriorityQueue<Pair>P=new PriorityQueue<>((a,b)->a.ending-b.ending);
            
           
            
             System.out.println(position);
            PriorityQueue<Integer>ch=new PriorityQueue<>();
            for(int i=0;i<times.length;++i){
                ch.add(i);
            }
            
            for(int i=0;i<=position;++i){
               
                if(P.size()==0){
                    
                    P.add(new Pair(L.get(i).start,L.get(i).ending,L.get(i).index,ch.remove()));
                }
                else 
                    if(P.peek().ending<=L.get(i).start){
                        
                       while(P.size()!=0&&P.peek().ending<=L.get(i).start){
                           //Adding the chair
                           Pair ob=P.remove();
                           
                           ch.add(ob.chair);
                           
                       }
                        //Use 
                        
                         P.add(new Pair(L.get(i).start,L.get(i).ending,L.get(i).index,ch.remove()));
                    }
                else{
                     P.add(new Pair(L.get(i).start,L.get(i).ending,L.get(i).index,ch.remove()));
                }
            }
            
            while(P.size()!=0){
                
                Pair ob=P.remove();
                
                if(ob.index==targetFriend){
                    
                    return ob.chair;
                }
            }
            return 0;
            
        }
        
        
        
    }
}