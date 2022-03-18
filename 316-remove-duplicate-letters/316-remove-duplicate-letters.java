class Solution {
  
    public String removeDuplicateLetters(String s) {
        
     HashMap<Character,Integer>H=new HashMap<>();
     for(int i=0;i<s.length();++i){
         char ch=s.charAt(i);
         H.put(ch,H.getOrDefault(ch,0)+1);
     }
       // System.out.println(H);
        StringBuilder ans=new StringBuilder("");
        Stack<Character>S=new Stack<>();
        
        for(int i=0;i<s.length();++i){
              if(S.contains(s.charAt(i))){
                  if(H.get(s.charAt(i))>1){
                      H.put(s.charAt(i),H.get(s.charAt(i))-1);
                  }
                  continue;
              }
           while(S.size()!=0&&S.peek()>=s.charAt(i)){
               //We can pop the S.peek() only when the frequency is greater than 1
                char ch=S.peek();
                if(H.get(ch)==1){
                    //Don't remove
                    break;
                }
                else{
                    S.pop();
                    H.put(ch,H.get(ch)-1);
                }
           }
         //  H.put(s.charAt(i),H.get(s.charAt(i))-1);
           S.add(s.charAt(i));
              
            
        }
        
        while(S.size()!=0){
            ans.append(S.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}