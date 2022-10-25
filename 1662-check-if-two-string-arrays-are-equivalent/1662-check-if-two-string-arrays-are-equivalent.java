class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer first=new StringBuffer("");
        StringBuffer second=new StringBuffer("");
        for(int i=0;i<word1.length;++i){
            first.append(word1[i]);
        }
         for(int i=0;i<word2.length;++i){
            second.append(word2[i]);
        }
        if(first.toString().equals(second.toString())){
            return true;
        }
        return false;
        
    }
}