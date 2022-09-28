/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int findSum(List<NestedInteger>lst,int depth){
        

       int answer=0;
        
       int extraAnswer=0;
        
       for(NestedInteger ob:lst){
           
           //Nested list contains in the list
          // System.out.println(ob.getList()+" "+ob.getInteger());
           
           if(ob.getList().size()!=0){
               
               extraAnswer+=findSum(ob.getList(),depth+1);
           }
           else{
               
               if(ob.getInteger()!=null)
               
                   answer+=ob.getInteger();
           }
       }
       // System.out.println(answer+" "+depth);
        
        return answer*depth+extraAnswer;
      
    }
    public int depthSum(List<NestedInteger> nestedList) {
    
        return findSum(nestedList,1);
    }
}