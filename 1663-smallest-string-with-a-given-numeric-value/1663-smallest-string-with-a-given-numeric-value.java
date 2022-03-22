class Solution {
    public String getSmallestString(int n, int k) {
        char ch[]=new char[n];
        Arrays.fill(ch,'a');
        if(n==k){
            return new String(ch);
        }
        else{
            k-=n;
         //Start from the end
            for(int i=ch.length-1;i>=0;--i){
                if(k>25){
                    ch[i]='z';
                    k-=25;
                }
                else{
                    ch[i]= (char) ((char)ch[i]+k);
                    break;
                }
            }
        }
        return new String(ch);
        
    }
}