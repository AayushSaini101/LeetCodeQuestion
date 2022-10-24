class Solution {
    
    static boolean check(List<String>ans){
    int dp[]=new int[26];
        int count=0;
    for(int i=0;i<ans.size();++i){
        for(int j=0;j<ans.get(i).length();++j){
            dp[ans.get(i).charAt(j)-'a']++;
            ++count;
        }
    }
        for(int i=0;i<26;++i){
            if(dp[i]>1){
                return false;
            }
        }
        max=Math.max(max,count);
        return true;
        
        
    }
    static int max=0;
    static void check(List<String>arr,int index,ArrayList<String>ans){
        if(index>=arr.size()){
            return;
        }
        //Two either use the given String 
        //Not use the String
        ans.add(arr.get(index));
        if(check(ans)==true){
            check(arr,index+1,ans);
         }
        if(ans.size()!=0){
            ans.remove(ans.size()-1);
        }
        check(arr,index+1,ans);
        
       
        
    }
    public int maxLength(List<String> arr) {
        //One approach is using the backtracking approach
        ArrayList<String>ans=new ArrayList<>();
        check(arr,0,ans);
        int count=max;
        max=0;
        return count;
        
    }
}