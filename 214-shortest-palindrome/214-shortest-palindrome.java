class Solution {
    public int[] Zalgo(String s,int z[]){

        int l=0;
        int r=0;

        for(int i=0;i<s.length();++i){

            if(i>r){

                l=i;
                
                r=i;

                while(r<s.length()&&s.charAt(r)==s.charAt(r-l)){

                    ++r;
                }
                //The z value will be

                z[i]=r-l;

                --r;
            }
            else{
                int index=i-l; 
                if(i+z[index]<=r){

                    z[i]=z[index];
                }
                else{

                    l=i;

                    while(r<s.length()&&s.charAt(r)==s.charAt(r-l)){

                    ++r;
                }
                //The z value will be

                z[i]=r-l;

                --r;
                }
            }
        }

        return z;
    }
    public String shortestPalindrome(String s) {
        //anab$bana
        String first=s;
        
        String second=new StringBuffer(first).reverse().toString();
        
        String str=first+"$"+second;
        
      //  System.out.println(str);
        
        int z[]=new int[str.length()];
        
        Zalgo(str,z);
        
        for(int i=0;i<z.length;++i){
            
            //Perfect string found that match with the prefix 
            //can be remove 
            if(z[i]+i==str.length()){
                
                return str.substring(first.length()+1,i)+s;
            }
        }
        
        return "";
    }
}