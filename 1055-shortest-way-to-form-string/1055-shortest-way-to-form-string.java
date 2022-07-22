class Solution {

    public int shortestWay(String source, String target) {
      
        int count=0;
        
        int index=0;
        
        int previous=-1;
        
        while(index<target.length()){
            
             previous=index;
            
            for(int i=0;i<source.length();++i){
                
                if(index>=target.length()){
                    break;
                }
                if(source.charAt(i)==target.charAt(index)){
                    
                    ++index;
                }
            }
            if(previous==index){
                
                 return -1;
            }
            
            ++count;
            
        }
        return count;
    }
}