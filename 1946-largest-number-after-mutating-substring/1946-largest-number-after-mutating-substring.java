class Solution {
    public String maximumNumber(String num, int[] change) {
         char ch[]=num.toCharArray();
        StringBuffer msg=new StringBuffer("");
        int check=0;
        int starting=0;
         for(int i=0;i<ch.length;++i){
             if(ch[i]-'0'==change[(ch[i]-'0')]){  msg.append(ch[i]);
                
                 continue;
             }
             if(ch[i]-'0'<=change[(ch[i]-'0')]&&check==0){
                 starting=1;
                
               msg.append(change[ch[i]-'0']);
                // System.out.println(msg+" "+i);
             }
             else{
                 if(starting==1)
                 check=1;
               msg.append(ch[i]);
             }
         }
        return msg.toString();
    }
}