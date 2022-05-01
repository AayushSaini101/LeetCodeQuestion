class Solution {
    
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] % p == 0)  count++;
                if(count > k)  break;
			
                list.add(nums[j]);
              //  System.out.println(list);
                set.add(new LinkedList<>(list));
                //System.out.println(list);
            }
            list.removeAll(list);
        }
        return set.size();
    }

}