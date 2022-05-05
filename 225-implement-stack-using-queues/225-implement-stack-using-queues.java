class MyStack {
     Queue<Integer>Q;
    /** Initialize your data structure here. */
    public MyStack() {
        Q=new LinkedList<Integer>();
    }
    public Queue<Integer>reverse(Queue<Integer>Q){
        Stack<Integer>temp=new Stack<>();
        int size=Q.size();
        while(size-->0){
            temp.add(Q.remove());
        }
        Queue<Integer>ans=new LinkedList<>();
        while(temp.size()!=0){
            ans.add(temp.pop());
        }
        
        return ans;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        //If the queue size if empty
        if(Q.size()==0){
            Q.add(x);
        }
        else{
           Queue<Integer>remaining_reverse=reverse(Q);
           remaining_reverse.add(x);
          
           Q=reverse(remaining_reverse);
          
        }
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       int pop=Q.remove();
        return pop;
        
    }
    
    /** Get the top element. */
    public int top() {
        int top=Q.peek();
        return top;
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(Q.size()==0)return true;
         return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */