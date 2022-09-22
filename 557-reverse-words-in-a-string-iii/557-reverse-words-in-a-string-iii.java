class Solution {
    public String reverseWords(String s) {
        
        String temp[]=s.split(" ");
        
        StringBuffer updatedString=new StringBuffer("");
        
        for(int i=0;i<temp.length;++i){
            
            String str=temp[i];
            
            StringBuffer string=new StringBuffer();
            
            for(int j=str.length()-1;j>=0;--j){
                
                string.append(str.charAt(j));
            }
            
            if(i!=temp.length-1){
                
                string.append(" ");
                
            }
            
            updatedString.append(string);
        }
        
        return updatedString.toString();
    }
}