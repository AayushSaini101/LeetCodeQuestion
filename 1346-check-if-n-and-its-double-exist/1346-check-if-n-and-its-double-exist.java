class Solution {
    public boolean checkIfExist(int[] arr) {
        
        HashSet<Integer>H=new HashSet<>();
        
        for(int i=0;i<arr.length;++i){
            
            if(H.contains(arr[i])){
                
                return true;
            }
            if(arr[i]%2==0){
                
                H.add(arr[i]/2);
            }
            
        }
        
        H.clear();
        
         for(int i=arr.length-1;i>=0;--i){
            
            if(H.contains(arr[i])){
                
                return true;
            }
            if(arr[i]%2==0){
                
                H.add(arr[i]/2);
            }
            
        }
        return false;
    }
}