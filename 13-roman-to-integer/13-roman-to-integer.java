class Solution {
    public int romanToInt(String s) {
        
        HashMap<String,Integer>H=new HashMap<>();
        
        H.put("I",1);
        H.put("V",5);
        H.put("X",10);
        H.put("L",50);
        H.put("C",100);
        H.put("D",500);
        H.put("M",1000);
        
        H.put("IV",4);
        H.put("IX",9);
        H.put("XL",40);
        H.put("XC",90);
        
        H.put("CD",400);
        H.put("CM",900);
        
        
        int requiredNumber=0;
        
        for(int i=0;i<s.length();++i){
            
            int value=0;
            
            if(i+1<s.length()&&H.containsKey(String.valueOf(s.charAt(i)+""+s.charAt(i+1)))){
            
                value=H.get(String.valueOf(s.charAt(i)+""+s.charAt(i+1)));
                
                ++i;
            }
            else{
                
                value=H.get(String.valueOf(s.charAt(i)));
            }
               
            requiredNumber+=value;
        }
               
        return requiredNumber;
               
        
        
    }
    
}