class Solution {
    public boolean detectCapitalUse(String word) {
        int count=0;
        int first=-1;
        for(int i=0;i<word.length();++i){
            if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                if(first==-1){
                    first=i;
                }
                ++count;
            }
        }
        if(count==word.length()||(first==0&&count==1)||(count==0&&first==-1)){
            return true;
        }
        return false;
    }
}