class Solution {
    public void find(int index,String s,String helper,List<String>answer){
        
        if(index==s.length()){
            
            answer.add(helper);
            
            return ;
        }
        
        if(s.charAt(index)>='a'&&s.charAt(index)<='z'
||(s.charAt(index)>='A'&&s.charAt(index)<='Z')){
            
            char first=Character.toUpperCase(s.charAt(index));
            
            char second=Character.toLowerCase(s.charAt(index));
            
            find(index+1,s,helper+first,answer);
            
            find(index+1,s,helper+second,answer);
            
          
            
        }
        else
    
        find(index+1,s,helper+s.charAt(index),answer);
    }
    public List<String> letterCasePermutation(String s) {
        
        
        List<String>answer =new ArrayList<>();
        
        find(0,s,"",answer);
        
        return answer;
    }
}