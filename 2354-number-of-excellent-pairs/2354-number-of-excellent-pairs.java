class Solution {

    public long countExcellentPairs(int[] nums, int k) {
    
        
        HashSet<Integer>H=new HashSet<>();
        
        HashMap<Integer,Integer>map=new HashMap<>();
        
        int maxDigits=30;
        
       int counts[]=new int[31];
        
        for(int elements:nums){
            
            if(H.contains((elements)))continue;
            
            int bits=Integer.bitCount(elements);
            
            counts[bits]++;
               
            H.add(elements);
               
        }
    
               
        long pairs = 0;
        for (int i = 1; i <= maxDigits; i++) {
            int start = Math.max(i, k-i);
            for (int j = start; j <= maxDigits; j++) pairs += i == j ? (long) counts[i]*counts[j] : 2* (long)counts[i]*counts[j];
        }
        return pairs;
               
               
     
      
            
    }
}