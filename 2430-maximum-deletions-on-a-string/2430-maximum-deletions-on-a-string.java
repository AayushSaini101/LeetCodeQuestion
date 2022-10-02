class Solution {
    HashMap<Integer,Integer> map = new HashMap();
    public int deleteString(String s) {
        return helper(s,0);
    }
    
    private int helper(String s, int idx){
        if(idx == s.length())return 0;
        
        if(map.containsKey(idx))return map.get(idx);
        
        int ans = 1;
        for(int i = idx; i <idx+(s.length()-idx)/2; i++){
            if(!map.containsKey(i)){
                String a = s.substring(idx,i+1);
                String b = s.substring(i+1,i+1+i-idx+1);
            
                if(a.equals(b)){
                String temp = s.substring(i+1);
                int c = helper(s,i+1)+1;
                ans = Math.max(c,ans);
            }
            }
            
        }
        
        map.put(idx,ans);
      
        return ans;
    }
}