class MedianFinder {

    
    private PriorityQueue<Integer>first;
    
    private PriorityQueue<Integer>Second;
    
    public MedianFinder() {
        
        this.first=new PriorityQueue(Collections.reverseOrder());
        
        this.Second=new PriorityQueue<>();
    }
    
    
    public void addNum(int num) {
    
      
        if(first.size()==0||first.peek()>=num){
            
            first.add(num);
        }
        else{
            
            Second.add(num);
            
        }
        
        if(first.size()>Second.size()+1){
            
            Second.add(first.remove());
        }
        else
            if(Second.size()>first.size()){
                
                first.add(Second.remove());
            }
        
    }
    
    public double findMedian() {
        
          
     //   System.out.println();
        
      //  System.out.println(first+" "+Second);
        
        if((first.size()+Second.size())%2==1){
            
            if(first.size()>Second.size()){
                
                return first.peek();
            }  
            else{
                
                return Second.peek();
            }
            
        }
        else{
            
            return (double)(first.peek()+Second.peek())/2;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */