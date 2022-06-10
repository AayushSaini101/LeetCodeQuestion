class Solution {
    public int lengthOfLongestSubstring(String m) {
        Queue<Character>Q=new LinkedList<>();
        int max=0;
        int count=0;
        for(int i=0;i<m.length();++i){
           if(Q.contains(m.charAt(i))){
             
               while(Q.size()!=0&&Q.peek()!=m.charAt(i)){
                    
                     Q.remove();
               }
               //Removing the last character also from teh queue 
               
               Q.remove();
               
           }
            
            Q.add(m.charAt(i));
            
            max=Math.max(max,Q.size());
        }
        return max;
        
    }
}