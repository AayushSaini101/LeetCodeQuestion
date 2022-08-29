class Solution {
   public List<List<Integer>> threeSum(int[] num) {
   
   List<List<Integer>> res = new ArrayList<>();
    int len = num.length;
    if(len < 3){
        return res;
    }    
   
    Arrays.sort(num);
    
    for(int i = 0; i < len-2; i++){
        if(i != 0 && num[i] == num[i-1]){
            continue;
        }
        
        int l = i+1;
        int r = len-1;
        
        while(l < r){
		
            int sum = num[i] + num[l] + num[r];
            if(sum == 0){
			
                res.add(Arrays.asList(num[i], num[l], num[r]));
                int currL = num[l];
                while(l < r && num[l] == currL) l++;
                int currR = num[r];
                while(l < r && num[r] == currR) r--;
            }
            else if(sum > 0){
                r--;
            }
            else{
                l++;
            }
        }
    }
    
return res;
}}