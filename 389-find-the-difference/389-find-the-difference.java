class Solution {
    public char findTheDifference(String s, String t) {
     if(s.length()==0){
         return t.charAt(0);
     }
      HashMap<Character,Integer>H= new HashMap<>();
      HashMap<Character,Integer>T=new HashMap<>();
        for(int i=0;i<s.length();++i){
            H.put(s.charAt(i),H.getOrDefault(s.charAt(i),0)+1);
        }
          for(int i=0;i<t.length();++i){
            T.put(t.charAt(i),T.getOrDefault(t.charAt(i),0)+1);
        }
        
         for(Character ch:T.keySet()){
              
             if(H.containsKey(ch)==false){
                 return ch;
             }
             else
                 if(H.get(ch)!=T.get(ch)){
                     return ch;
                 }
         }
        return '0';
        
        
    }
}