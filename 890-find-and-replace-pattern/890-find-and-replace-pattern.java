class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String>answer=new ArrayList<>();
        
        for(int i=0;i<words.length;++i){
            
            String str=words[i];
            
            
            int first[]=new int[26];
            
            int second[]=new int[26];
            
            Arrays.fill(first,-1);
            
            Arrays.fill(second,-1);
            
    
            
            if(str.length()!=pattern.length()){
                continue;
            }
            
            StringBuffer fx=new StringBuffer("");
            
            for(int j=0;j<pattern.length();++j){
                
                int key1=pattern.charAt(j)-'a';
                
                int key2=str.charAt(j)-'a';
                
                if(key1==key2){
                    
                    if(first[key1]==-1&&second[key2]==-1){
                        
                        first[key1]=key2;
                        
                        second[key2]=key1;
                        
                        fx.append((char)('a'+key1));
                    }
                    
                    else
                        if(first[key1]==key2&&second[key2]==key1){
                            
                            fx.append((char)('a'+key1));
                            
                        }
                   else{
                       
                       break;
                   }
                    
                   
                }
                
                else{
                    
                    if(first[key1]==-1&&second[key2]==-1){
                        
                        first[key1]=key2;
                        
                        second[key2]=key1;
                        
                        fx.append((char)('a'+key1));
                            
                    }
                     else
                        if(first[key1]==key2&&second[key2]==key1){
                            
                            fx.append((char)('a'+key1));
                            
                        }
                }
        }
            
        if(fx.toString().equals(pattern)){
            
            answer.add(words[i]);
        }
            
    }
        
        return answer;
    }
}