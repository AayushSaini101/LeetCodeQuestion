class StockSpanner {

    class Pair{
        
        int element;
        
        int count;
        
        Pair(int element,int count){
            
            this.element=element;
            
            this.count=count;
        }
        
    }
    
    private Stack<Pair>S;
    
    public StockSpanner() {
    
        this.S=new Stack<>();
    }
    
    public int next(int price) {
        
        if(S.size()==0){
            
            S.add(new Pair(price,1));
            
            return 1;
        }
        else{
            
            int count=1;
            
            while(S.size()!=0&&S.peek().element<=price){
                
                
             
                count+=S.pop().count;
                
             }
            
            
            S.add(new Pair(price,count));
            
            return count;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */