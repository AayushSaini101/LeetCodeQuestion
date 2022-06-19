class Solution {
    public int strStr(String haystack, String needle) {
      
        //Let's try to solve this problem using the Z algorithm 
        String updated=needle+"$"+haystack;
        int l=0;
        int r=0;
        
        int z[]=new int[updated.length()];
        
        for(int i=1;i<updated.length();++i){
            if(i<=r){
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            while(i+z[i]<updated.length()&&updated.charAt(z[i])==updated.charAt(i+z[i])){
                z[i]++;
            }
            
            if(i+z[i]-1>r){
                l=i;
                r=i+z[i]-1;
                
            }
        }
        
        for(int i=0;i<updated.length();++i){
            
          
            
            if(z[i]==needle.length()){
                return i-needle.length()-1;
            }
        }
        return -1;
        
    }
}