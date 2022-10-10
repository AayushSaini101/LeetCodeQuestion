class Solution {
    
   
    public String breakPalindrome(String str) {
     
        if(str.length()==1){
            
            return "";
            
        }
        int left=0;
        
        int right=str.length()-1;
        
        while(left<=right){
            

            if(str.charAt(left)!='a'&&left!=right){
                
                return str.substring(0,left)+"a"+str.substring(left+1);

            }
            
            ++left;
            
            --right;
        }
        
        return str.substring(0,str.length()-1)+"b";
    
    }
}