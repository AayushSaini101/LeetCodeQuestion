class Solution {
    public int find(int n,int vowel){
        if(n==0){
           return 1;
        }
        else
         if(vowel==0){
             return 0;
         }
        
        int answer=0;
          
        answer+=find(n-1,vowel)+find(n,vowel-1);
        
        return answer;
        
    }
    public int countVowelStrings(int n) {
          
         int answer=find(n,5);
        
        return answer;
    }
}