class Solution {
    public void find(int start,int end,List<Integer>helper,List<List<Integer>>ans,int count,int k){
        if(count==k){
            //We will store the subset
            ans.add(new ArrayList<Integer>(helper));
            return;
        }
       
        for(int i=start;i<=end;++i){
            //Possibilies include the number 
            helper.add(i);
            find(i+1,end,helper,ans,count+1,k);
            helper.remove(helper.size()-1);
          
            
        }
    }
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>>L=new ArrayList<>();
      List<Integer>helper=new ArrayList<>();
      find(1,n,helper,L,0,k);
       return L;
    }
}