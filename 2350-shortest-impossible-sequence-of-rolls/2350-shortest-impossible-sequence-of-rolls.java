class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer>st=new HashSet<>();
        
        for(int elements:rolls){
            
            st.add(elements);
        }
        if(st.size()!=k){
            return 1;
        }
        int count=0;
        
        st.clear();
        
        for(int i=0;i<rolls.length;++i){
            
            if(st.size()==k){
                
                ++count;
                st.clear();
            }
            st.add(rolls[i]);
        }
        
        if(st.size()==k){
            ++count;
        }
        
        return count+1;
    }
}