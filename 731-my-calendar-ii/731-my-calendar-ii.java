class MyCalendarTwo {
    
    //There are two ways to use the line sweep algorithm using the dp array and the second one usingthe tree Ma
    
    public TreeMap<Integer,Integer>T;
    
    public MyCalendarTwo() {
    
        this.T=new TreeMap<>();
        
    }
    
    public boolean book(int start, int end) {
        
        T.put(start,T.getOrDefault(start,0)+1);
        
        T.put(end,T.getOrDefault(end,0)-1);
        
        int count=0;
        
        for(int elements:T.keySet()){
        
            count+=T.get(elements);
            
            if(count>=3){
                
                T.put(start,T.get(start)-1);
                
                T.put(end,T.get(end)+1);
                
                return false;
            }
            
        }
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */