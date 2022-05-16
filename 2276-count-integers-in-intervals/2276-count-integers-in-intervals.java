class CountIntervals {

    int count;
    
    TreeMap<Integer,Integer>T;
    
    public CountIntervals() {
    
        this.count=0;
        this.T=new TreeMap<>();
    }
    
    public void add(int left, int right) {
     {
            
            int min=left;
            int max=right;
            
            while(!(T.floorKey(right)==null||T.get(T.floorKey(right))<left)){
                
                int key=T.floorKey(right);
                
                int value=T.get(T.floorKey(right));
            
                
                //This is the overlapping problem 
                count-=(value-key+1);
                
                T.remove(key);
                
                min=Math.min(min,key);
                
                max=Math.max(value,max);
                
                
                
                
                
            }
            
            count+=(max-min+1);
            
            T.put(min,max);
            
            
        }
    }
    
    public int count() {
        
        return this.count;
        
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */