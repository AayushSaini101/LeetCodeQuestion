class Solution {
    public int minimumRounds(int[] tasks) {
     //Either take the 2 or 3 task of the limit 
        
        HashMap<Integer,Integer>H=new HashMap<>();
        
        for(int elements:tasks){
            
            H.put(elements,H.getOrDefault(elements,0)+1);
        }
        
      //  System.out.println(H);
        
        int count = 0 ;
        
   
        for(int elements:H.keySet()){
            
            
            int freq = H.get(elements);
            
            
         
            if(freq<2)return -1;
            
            if(freq%3==0)count+=freq/3;
            
            else{
               
                count+=(freq)/3+1;
            }
                
            
            
        }
        
        return count;
    }
}