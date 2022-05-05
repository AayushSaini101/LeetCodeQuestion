class Solution {
    public void find(int start,int end,List<Integer>lst){
        if(start>end){
            return;
        }
        
        for(int i=0;i<=9;++i){
            
            int nextNumber=start*10+i;
            
            if(nextNumber!=0&&nextNumber<=end){
                
                lst.add(nextNumber);
                
                find(nextNumber,end,lst);
                
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
      
        List<Integer>lst=new ArrayList<>();
        
        find(0,n,lst);
        
        return lst;
    }
}