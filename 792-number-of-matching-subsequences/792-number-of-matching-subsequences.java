class Solution {
    public int find(List<Integer>lst,int value){
        
        int start=0;
        
        int end=lst.size()-1;
        
        int answer=lst.size();
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(lst.get(mid)>value){
                
                answer=mid;
                
                end=mid-1;
            }
            else{
                
                start=mid+1;
            }
            
        }
        return answer;
    }
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap<Integer,List<Integer>>temp=new HashMap<>();
        
        for(int i=0;i<s.length();++i){
            
            int key=s.charAt(i)-'a';
            
            temp.computeIfAbsent(key,k->new ArrayList<Integer>()).add(i);
        }
        
      
        int count=0;
        
        for(int i=0;i<words.length;++i){
            
            String str=words[i];
            
            int index=-1;
            
            int tracker=0;
            
            for(int j=0;j<str.length();++j){
                
                int key=str.charAt(j)-'a';
                
                if(temp.containsKey(key)==false||temp.get(key).size()==0){
                    
                    continue;
                    
                }
                if(index==-1){
                    
                    index=temp.get(key).get(0);
                    
                    
                    
                    ++tracker;
                }
                else{
                    
                    //Finding the index just greater than the previous index 
                    int position=find(temp.get(key),index);
                    
                    if(position==temp.get(key).size()){
                        
                        break;
                    }
                    else{
                        
                        index=temp.get(key).get(position);
                        
                 
                    }
                    
                    ++tracker;
                  
                }
            }
            if(tracker==str.length()){
                ++count;
            }
            
        }
        
        return count;
    }
}