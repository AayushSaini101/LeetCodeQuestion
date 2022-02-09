class Solution {
    public int findPairs(int[] nums, int k) {
        // Using the mod property we can use this
        HashSet<Integer>H=new HashSet<>();
        HashSet<Integer>S=new HashSet<>();
        int count=0;
        int equal=0;
        LinkedHashMap<Integer,Integer>el=new LinkedHashMap<>();
        for(int elements:nums){
            {
                el.put(elements,el.getOrDefault(elements,0)+1);
            }
           
        }
   //System.out.println(el);
        for(int elements:el.keySet()){
            int number=elements;
             if(el.get(number)>1){
                 equal+=1;
             }
            if(H.contains(number)){
              //  System.out.println(number);
                ++count;
            }
            if(S.contains(number)){
                ++count;
            }
            H.add(number+k);
            S.add(number-k);
        }
      //  int count=0;
       if(k==0){
           return equal;
       }
        return count;
    }
}