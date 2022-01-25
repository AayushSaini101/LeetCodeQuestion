class Solution {

    public int numSplits(String s) {
     TreeSet<Character>T=new TreeSet<>();
     int prefix[]=new int[s.length()];
     int suffix[]=new int[s.length()];
     for(int i=0;i<s.length();++i){
         T.add(s.charAt(i));
         prefix[i]=T.size();
     }
     
        T.clear();
        
     for(int i=s.length()-1;i>=0;--i){
         T.add(s.charAt(i));
         suffix[i]=T.size();
     }
     int answer=0;
        
    for(int i=0;i<prefix.length-1;++i){
        
        if(prefix[i]==suffix[i+1]){
            ++answer;
        }
    }
        
     return answer;   
        
     
     
    }
}