class Solution {
    public String longestPrefix(String s) {
        //Find the prefix which is also a prefix 
        int z[]=new int[s.length()];
        
        int l=0;
        int r=0;
        
        for(int i=1;i<s.length();++i){
            
            if(r>=i){
                //Filling the box value 
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            //Matching the values from the prefix 
            
            while(i+z[i]<s.length()&&s.charAt(z[i])==s.charAt(i+z[i])){
                 
                   z[i]++; 
            }
            
            if(i+z[i]-1>r){
                r=i+z[i]-1;
                l=i;
            }
            
            
        }
        int max=0;
        int index=-1;
        for(int i=0;i<z.length;++i){
            //System.out.print(z[i]+" ");
            if(z.length-1-i+1!=z[i]){
                continue;
            }
             if(max<z[i]){
                 
                 max=z[i];
                 index=i;
             }
        }
        
        if(index==-1){
            return "";
        }
     
        
      return s.substring(index);
        
        
    }
}