class Solution {
    public int minimumTime(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='1'){
                return 1;
            }
            else{
                return 0;
            }
        }
        int left[]=new int[s.length()];
        if(s.charAt(0)=='1'){
            left[0]=1;
        }
        for(int i=1;i<s.length();++i){
            
            if(s.charAt(i)=='1'){
                left[i]=Math.min(i+1,left[i-1]+2);
            }
            else{
                left[i]=left[i-1];
            }
        }
    
    int right[]=new int[s.length()];
    if(s.charAt(s.length()-1)=='1'){
        right[right.length-1]=1;
    }
    for(int i=s.length()-2;i>=0;--i){
        if(s.charAt(i)=='1'){
            right[i]=Math.min(right[i+1]+2,s.length()-i);
        }
        else{
            right[i]=right[i+1];
        }
          
        
    }
   int min=Integer.MAX_VALUE;
    for(int i=0;i<left.length-1;++i){
       // System.out.print(left[i]+" ");
        min=Math.min(min,left[i]+right[i+1]);
    }
    return min;
}
}