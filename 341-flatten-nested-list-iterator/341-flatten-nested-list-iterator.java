/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer>answer=new ArrayList<>();
    int index=0;;
    static int call=0;
    
    
    public void DFS(List<NestedInteger>lst,List<Integer>answer,int index){
        if(index>=lst.size()){
            return;
        }
        if(lst.get(index).isInteger()){
            
            answer.add(lst.get(index).getInteger());
            DFS(lst,answer,index+1);
        }
        else{
             DFS(lst.get(index).getList(),answer,0);
             DFS(lst,answer,index+1);
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
       
        List<Integer>answer=new ArrayList<>();
        
        DFS(nestedList,answer,0);
        
        this.answer=answer;
        
        //System.out.println(answer);
    }

    @Override
    public Integer next() {
     
    return answer.get(index++);
        
    }

    @Override
    public boolean hasNext() {
     return index<answer.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */