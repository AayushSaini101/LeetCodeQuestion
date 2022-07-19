class Solution {
    public List<List<Integer>> generate(int number) {
         List<List<Integer>>A=new ArrayList<List<Integer>>();
       
        
       for(int i=0;i<number;++i){
           int index=0;

        ArrayList<Integer>temp=new ArrayList<>();
           for(int j=0;j<i+1;++j){
               if(i<=1)
             temp.add(1);
             else
             if(i>=2){
                 if(j==0||j==i){
                     temp.add(1);
                 }
                 else{
                     temp.add(A.get(i-1).get(index)+A.get(i-1).get(++index));
                 }
             }

           
           }
           A.add(i,temp);
       }
        return A;
    }
}