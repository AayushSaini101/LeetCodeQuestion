class Solution {
  
    public List<String> wordSubsets(String[] str, String[] words2) {
        
    int dp[]=new int[26];
        
   
        
    List<String>lst=new ArrayList<>();
        
    //Counting the frequency of the second words
    for(int i=0;i<words2.length;++i){

        String words=words2[i];

        int temp[]=new int[26];
        
        for(int j=0;j<words.length();++j){


            int key=words.charAt(j)-'a';

            temp[key]++;
          

          
        }
        for(int k=0;k<26;++k){
        
            dp[k]=Math.max(dp[k],temp[k]);
        }

        
        
    }
  
// System.out.println(Arrays.toString(dp));
        
    for(int i=0;i<str.length;++i){
        
        String word=str[i];
        
        int dp1[]=new int[26];
        
        for(int j=0;j<word.length();++j){
            
            dp1[word.charAt(j)-'a']++;
        }
          
        
            int check=0;
        
            int temp[]=dp;
          
            
            for(int l=0;l<26;++l){
                
                if(temp[l]!=0){
                    
                    if(dp1[l]!=0&&dp1[l]>=temp[l]){
                        
                        continue;
                    }
                    else{
                       
                       // System.out.println(l+" "+dp1[l]);
                        
                        check=1;
                       
                        break;
                    }
                }
            }
            if(check==1){
                
                continue;
            }
        
           lst.add(str[i]);
        
        
  
}
        
       
      
        return lst;
  
    }
}