class Solution {
    public boolean check(String curr,int high){
        if(curr.length()==0){
            return false;
        }
        String max=""+Integer.MAX_VALUE;
        if(max.compareTo(curr)<0){
            return  true;
        }
        else{
            if(new Integer(curr)<=high){
                return true;
            }
            return false;
        }
    }
    public boolean check(int low,int high,String curr){
        int value=new Integer(curr);
        if(value>=low&&value<=high){
            return true;
        }
         return false;
    }
    List<Integer>ans=new LinkedList<>();
    public void find(int low,int high,String curr){
        
       // System.out.println(curr);
        
         if(check(curr,high)&&check(low,high,curr)){
         if(ans.contains(new Integer(curr))==false)
            ans.add(new Integer(curr));
         }
        
       
        int lastdigit=curr.charAt(curr.length()-1)-48;
        
        if(lastdigit==9){
            return;
        }
        else{
            //There are two option 
            find(low,high,curr+(lastdigit+1));
            find(low,high,curr.substring(1)+(lastdigit+1));
        }
        
    }
    public List<Integer> sequentialDigits(int low, int high) {
      List<Integer>lst=new ArrayList<>();
     
      int length= (int) Math.log10(low)+1;
     // System.out.println(length+" sdf");
      StringBuffer ans=new StringBuffer("");
        
        for(int i=1;i<=length;++i){
            ans.append(i);
        }
        
        find(low,high,ans.toString());
        
        Collections.sort(this.ans);
        
        return this.ans;
    
        
          
        
        
 
    
    }
}