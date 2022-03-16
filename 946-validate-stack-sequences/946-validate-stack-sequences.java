class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>S=new Stack<>();
        int index1=0;
        int index2=0;
        while(index1<pushed.length&&index2<popped.length){
            if(S.size()!=0&&popped[index2]==S.peek()){
                //Removing the element
                S.pop();
                
                ++index2;
            }
            else{
                if(S.contains(popped[index2])==false){
                   S.add(pushed[index1]);
                   
                    ++index1;
                    
                   
                }
                else{
                    break;
                }
            
            }
         
        }
        if(S.size()==0){
            return true;
        }
        
        
        while(index2<popped.length){
            if(S.peek()!=popped[index2]){
                break;
            }
            S.pop();
           ++index2;
        }
        
        if(S.size()!=0){
            return false;
        }
        return true;
        
    }
}