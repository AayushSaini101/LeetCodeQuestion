class MyCalendarThree {

    TreeMap<Integer,Integer>T;
    
    public MyCalendarThree() {
    
        T=new TreeMap<>();
    }
    
    public int book(int start, int end) {
         
        T.put(start,T.getOrDefault(start,0)+1);
        
        T.put(end,T.getOrDefault(end,0)-1);
        
        int count=0;
        
        int max=0;
        
      //  S
        
        for(int elements:T.keySet()){
        
            count+=T.get(elements);
        
            max=Math.max(count,max);
           
        }
        
        return max;
        
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */