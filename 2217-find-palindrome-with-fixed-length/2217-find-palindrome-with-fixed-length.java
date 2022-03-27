class Solution {
    public boolean check(long value,int length){
        
        StringBuffer first=new StringBuffer(""+value);
        if(first.length()>length){
            return false;
        }
        StringBuffer second=new StringBuffer(""+value);
        second.reverse();
        if(first.toString().equals(second.toString())){
            return true;
        }
        return false;
    }
    public long[] kthPalindrome(int[] queries, int length) {
     int check=0;
     if(length%2==0){
         check=-1;
     }
     long first=(long)Math.pow(10,(length/2+check));
     long answer[]=new long[queries.length];
    
     int index=0;
     for(int elements:queries){
         first+=(elements-1);
         long value=Long.parseLong(first+""+new StringBuffer(String.valueOf(first).substring(0,length/2)).reverse());
         if(check(value,length)==false){
             answer[index++]=-1;
             first-=(elements-1);
             continue;
         }
         answer[index++]=value;
         first-=(elements-1);
         
     }
        return answer;
     
        
    }
}