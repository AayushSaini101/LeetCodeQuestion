class Solution {
    static class Pair{
        int number;
        int count;
        Pair(int number,int count){
            this.number=number;
            this.count=count;
        }
    }
    public int minimumOperations(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        HashMap<Integer,Integer>odd=new HashMap<>();
        HashMap<Integer,Integer>even=new HashMap<>();
       int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=nums.length;++i){
            if(i%2==1){
              odd.put(nums[i-1],odd.getOrDefault(nums[i-1],0)+1);
            }
            else{
              even.put(nums[i-1],even.getOrDefault(nums[i-1],0)+1);  
            }
            min=Math.min(min,nums[i-1]);
            max=Math.max(max,nums[i-1]);
        }
        
        //Find the number which is not present in the key 
       if(min==max){
           return nums.length/2;
       }
        else{
            min=Integer.MAX_VALUE;
            max=0;
            int number=0;
            int answer=0;
            for(int elements:odd.keySet()){
                if(max<odd.get(elements)){
                    max=odd.get(elements);
                    number=elements;
                }
            }
            answer=nums.length/2+nums.length%2-max;
            System.out.println(answer);
            max=0;
            
            for(int elements:even.keySet()){
                if(elements!=number){
                 max=Math.max(max,even.get(elements));
                }
            }
            answer+=nums.length/2-max;
          //  System.out.println(answer);
            min=Math.min(min,answer);
            
            max=0;
            number=0;
            answer=0;
          for(int elements:even.keySet()){
                if(max<even.get(elements)){
                    max=even.get(elements);
                    number=elements;
                }
            }
            answer=nums.length/2-max;
            
            max=0;
            
            for(int elements:odd.keySet()){
                if(elements!=number){
                 max=Math.max(max,odd.get(elements));
                }
            }
            answer+=nums.length/2+nums.length%2-max;
            
            return Math.min(min,answer);
        }
       
        //If all the numbers are equal 
        
    }
}