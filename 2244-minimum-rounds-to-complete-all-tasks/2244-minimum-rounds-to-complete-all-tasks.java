class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer>H=new HashMap<>();
        for(int elements:tasks){
            H.put(elements,H.getOrDefault(elements,0)+1);
        }
        System.out.println(H);
        
        //Iterating on the keys of the hash map
        int sum=0;
        for(int key:H.keySet()){
            if(H.get(key)<2){
                return -1;
            }
            else{
              if(H.get(key)%3==0){
                  sum+=H.get(key)/3;
              }
                else{
                   sum+=H.get(key)/3+1;
                }
                    
            }
                
        }
        return sum;
    }
}