class Solution {
    public boolean wordPattern(String pattern, String s) {
        char ch[]=pattern.toCharArray();
        String temp[]=s.split(" ");
       HashMap<Character,String>H=new HashMap<>();
        
        if(ch.length!=temp.length){
            return false;
        }
        HashSet<String>S=new HashSet<>();
        for(int i=0;i<ch.length;++i){
            
            if(H.containsKey(ch[i])==false){
                if(S.contains(temp[i])){
                    return false;
                }
                H.put(ch[i],temp[i]);
                S.add(temp[i]);
            }
            else{
                
                if(H.get(ch[i]).equals(temp[i])==false){
                    return false;
                }
            }
        }
        return true;
        
    }
}