class Solution {
    public int longestPalindrome(String[] words) {
      HashMap<String,Integer>H=new HashMap<>();
      HashMap<String,Integer>pallindrom=new HashMap<>();
      for(String elements:words){
          String str=elements;
          String rev=new StringBuffer(str).reverse().toString();
          if(str.equals(rev)){
              pallindrom.put(str,pallindrom.getOrDefault(str,0)+1);
          }
          else
          H.put(elements,H.getOrDefault(elements,0)+1);
      }
     int count=0;
        
        for(int i=0;i<words.length;++i){
            String rev=new StringBuffer(words[i]).reverse().toString();
            if(H.containsKey(rev)){
                count+=rev.length()*2;
                H.put(rev,H.get(rev)-1);
                if(H.get(rev)==0){
                    H.remove(rev);
                }
            }
            
        }
    int ans=count/2;
    int length=0;
    int length1=0;
       // System.out.println(pallindrom);
        for(String elements:pallindrom.keySet()){
           // System.out.println("sdfa");
            if(pallindrom.get(elements)==1){
                 length=Math.max(length,elements.length());
            }
            else{
                 if(pallindrom.get(elements)%2==1){
                     
                     ans+=(pallindrom.get(elements)-1)*elements.length();
                     if(pallindrom.get(elements)!=1){
                         length1=Math.max(length1,elements.length());
                     }
                 }
                else{
                     ans+=(pallindrom.get(elements))*elements.length();
                }
            }
        }
        return ans+((length==0)?length1:length);
       
        
    }
}