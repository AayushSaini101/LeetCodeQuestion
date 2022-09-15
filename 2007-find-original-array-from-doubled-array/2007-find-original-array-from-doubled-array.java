class Solution {
    public int[] findOriginalArray(int[] arr) {
    
        if(arr.length%2==1)return new int[]{};

        HashMap<Integer,Integer>H=new HashMap<>();
        
        for(int elements:arr){
            
            H.put(elements,H.getOrDefault(elements,0)+1);
        }
        
        int answer[]=new int[arr.length/2];
        
        int index=0;
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;++i){
            
            int value=arr[i];
            
            if(H.getOrDefault(2*value,0)!=0&&H.getOrDefault(value,0)!=0&&index<answer.length){
                
                //use the value 
                if(value*2==value){
                    
                    if(H.get(value)==1){
                        
                        continue;
                    }
                }
                
                answer[index++]=value;
                
                H.put(value*2,H.get(value*2)-1);
                
                H.put(value,H.get(value)-1);
            }
        }
        
     //  System.out.println(Arrays.toString(answer));
        
        if(index<arr.length/2) return new int[]{};
        
        return answer;
    }
}