class Solution {
    public int countDistinct(int[] nums, int k, int p) {
     HashSet<String>H=new HashSet<>();
        
  int answer=0;
        

        for(int i=0;i<nums.length;++i){
            
            int count=0;
            StringBuffer ans=new StringBuffer("");
            for(int j=i;j<nums.length;++j){
               ans.append(nums[j]+",");
              
               if(nums[j]%p==0){
                   ++count;
               }
               if(count>k){
                  
                   break;
               }
                if(ans.length()!=0)

                H.add(ans.toString());
            

            
            }
           


        }
      //  System.out.println(H);
      return H.size();

    }
}