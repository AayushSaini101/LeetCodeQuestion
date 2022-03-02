class Solution {
    public boolean isSubsequence(String s, String t) {
        //Checking whether the string is subsequene of not 
        //subsequence the order matters but the consecutive sequece doesn't
        int index=0;
        for(int i=0;i<t.length();++i){
            if(index<s.length()&&s.charAt(index)==t.charAt(i)){
                ++index;
            }
        }
        return index==s.length()?true:false;
    }
}