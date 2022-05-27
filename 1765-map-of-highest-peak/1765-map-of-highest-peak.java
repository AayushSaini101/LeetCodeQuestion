class Solution {
    public class Pair{
        int x;
        int y;
        
        //Parameterised Constructor
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public boolean check(int i,int j,int answer[][]){
        
        if(!(i>=0&&i<answer.length&&j>=0&&j<answer[0].length&&answer[i][j]==-1)){
            
            return false;
        }
        
        return true;
    }
    public int[][] highestPeak(int[][] isWater) {
        
        List<Pair>lst=new ArrayList<>();
        
        int answer[][]=new int[isWater.length][isWater[0].length];
        
        
        Queue<Pair>Q=new LinkedList<>();
        
        for(int i=0;i<isWater.length;++i){
            
            for(int j=0;j<isWater[0].length;++j){
                
                
                answer[i][j]=-1;
                
                if(isWater[i][j]==1){
                    
                    answer[i][j]=0;
                    
                    
                    lst.add(new Pair(i,j));
                    
                    Q.add(lst.get(lst.size()-1));
                    
                }
            }
        }
        
        //Case when all the water is not present in the block 
        if(lst.size()==0){
            
           for(int i=0;i<answer.length;++i){
               for(int j=0;j<answer[0].length;++j){
                   
                   answer[i][j]=1000;
               }
           }
            return answer;
        }
        
        else{
            //Using the BFS Approach O(number_of_waterblockes*)
            while(Q.size()!=0){
                
                int size=Q.size();
                
                for(int k=1;k<=size;++k){
                    
                    //Remove the first value from the queue 
                    
                    Pair ob=Q.remove();
                    
                    int x[]={0,0,-1,1};
                    int y[]={-1,1,0,0};
                    
                    for(int i=0;i<x.length;++i){
                        
                        if(check(ob.x+x[i],ob.y+y[i],answer)){
                            
                            answer[ob.x+x[i]][ob.y+y[i]]=answer[ob.x][ob.y]+1;
                            
                            Q.add(new Pair(ob.x+x[i],ob.y+y[i]));
                        }
                        
                        
                    }
                }
                
            }
            
            return answer;
            
            
        }
        
    }
}