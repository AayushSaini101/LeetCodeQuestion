class Solution {
    public boolean check(int dp1[],int dp2[]){
        for(int i=0;i<dp1.length;++i){
            if(dp1[i]!=dp2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
    //Naive approach
    //Checking whether it contains a permutation or not 
    //Generate all the permuation of the String 
    // We can generate the String "ab" O(n*n!) complexity to find the permuation for contains we nee 
    // O(n)+O(n*n!);
        
    //Second approch check all possible substrinng of the s2 and check if the frequence of the characters 
    //In the substring is equal to frequence of the characters in the s1
    //Time Complexity : O(26)+O(N*N)*O(26) This will the complexity of the solution 
    //This will also cause TLE
        
    //Third approach we can also use sliding window of the length s1.length() and check whether the character 
    //Contains in the sliding window or not// 
    //If the character is present in the window we remove the character 
    //Otherwise not 
  

      int dp[]=new int[26];
     for(int i=0;i<s1.length();++i){
         dp[s1.charAt(i)-'a']++; 
     }
    //For getting the answer all the HashMap must be clear 
    //If we get unkown character in the HashMap we will update the HashMap
  
     int dp1[]=new int[26];
     for(int i=0;i<s1.length();++i){
         dp1[s2.charAt(i)-'a']++;
     }
        
    if(check(dp,dp1)){
        return true;
    }            //3
        // 0 1 2 3
        for(int i=s1.length();i<s2.length();++i){
            dp1[s2.charAt(i-s1.length())-'a']--;
            dp1[s2.charAt(i)-'a']++;
            if(check(dp,dp1)){
                
                return true;
            }
        }
        return false;
    
            
        
        
    }
}