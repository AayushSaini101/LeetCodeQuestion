class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
       String msg[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        
      HashSet<String>H=new HashSet<>();
        
      for(int i=0;i<words.length;++i){
          
          String str=words[i];
          
          String encoded="";
          
          for(int j=0;j<str.length();++j){
          
              encoded+=msg[str.charAt(j)-'a'];
          }
          
          H.add(encoded);
      }
        
        
      return H.size();
        
    }
}