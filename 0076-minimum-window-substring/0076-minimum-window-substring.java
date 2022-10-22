import java.util.*;

class Solution {
    
public boolean checkFreq(HashMap<Character,Integer>H,HashMap<Character,Integer>required){
    
    
    for(Character elements:required.keySet()){
        
        if(H.containsKey(elements)){
            
            if(H.get(elements)<required.get(elements))return false;
            
        }
        else{
            
            return false;
        }
        
    }
    
    return true;
    
}
    
 public String check(int length,String s,String t,HashMap<Character,Integer>required){
     
     if(length==0){
         
         return "";
     }
     HashMap<Character,Integer>H=new HashMap<>();
     
     for(int i=0;i<length;++i){
         
         H.put(s.charAt(i),H.getOrDefault(s.charAt(i),0)+1);
         
     }
   //  System.out.println(H+" "+"first"+" "+length);
     
     if(checkFreq(H,required)){
         
         return s.substring(0,length);
     }
     for(int i=length;i<s.length();++i){
         
       //  System.out.println(H);
         
         H.put(s.charAt(i-length),H.get(s.charAt(i-length))-1);
         
        // System.out.println(H);
     
         
         if(H.get(s.charAt(i-length))==0){
             
             H.remove(s.charAt(i-length));
         }
         
         H.put(s.charAt(i),H.getOrDefault(s.charAt(i),0)+1);
         
       
         
         if (checkFreq(H,required)){
             
             return s.substring(i-length+1,i+1);
         }
         
     }
     
     return "";
     
     
     
 }
    
  public String minWindow(String s, String t) {
  
      int start=1;
      
      int end=s.length();
      
      StringBuffer answer=new StringBuffer("");
      
      HashMap<Character,Integer>H=new HashMap<>();
      
      for(int i=0;i<t.length();++i){
          
          H.put(t.charAt(i),H.getOrDefault(t.charAt(i),0)+1);
          
      }
      
      while(start<=end){
          
          int mid=(start+end)>>1;
          
          String check=check(mid,s,t,H);
          
         //  System.out.println(mid+" "+check);
          
          if(check.isEmpty()==false){
              
              
              
              answer=new StringBuffer(check);
              
              end=mid-1;
          }
          
          else{
              
              start=mid+1;
          }
      }
      
      return answer.toString();
    
    }
}