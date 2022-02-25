class Solution {
    public int compareVersion(String version1, String version2) {
      
        String first[]=version1.split("[.]");
        String second[]=version2.split("[.]");
        
        int startFirst=0;
        int startSecond=0;
        while(startFirst<first.length&&startSecond<second.length){
            int firstNumber=Integer.parseInt(first[startFirst++]);
            
            int secondNumber=Integer.parseInt(second[startSecond++]);
            
            if(firstNumber>secondNumber){
                return 1;
            }
            else
                if(firstNumber<secondNumber){
                    return -1;
                }
        }
        
        int number=0;
        
        while(startFirst<first.length){
            
         number=Integer.parseInt(first[startFirst++]);
        
         if(number!=0){
             
             return 1;
         }
            
        }
        
         while(startSecond<second.length){
            
         number=Integer.parseInt(second[startSecond++]);
        
         if(number!=0){
             
             return -1;
         }
            
        }
        
        return 0;
        
    }
}