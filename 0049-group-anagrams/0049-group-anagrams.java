class Solution {
    static class Pair{
        String ans;
        String updated;
        int index;
        Pair(String ans,int index){
            this.ans=ans;
            this.index=index;

        }
    }
     static String sort(String value){
        char ch[]= value.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] m) {
        ArrayList<Pair>A=new ArrayList<>();
        for(int i=0;i<m.length;++i){
            A.add(new Pair(m[i],i));
        }
        Collections.sort(A, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
             String ans=sort(o1.ans);
             o1.updated=ans;
             String ans1=sort(o2.ans);
             o2.updated=ans1;
             if(ans.compareTo(ans1)<0){
                 return -1;
             }

             return 1;

            }
        });
        List<List<String>>ans=new ArrayList<>();
        List<String>f=new ArrayList<>();


     String temp=A.get(0).updated;
     f.add(A.get(0).ans);
     for(int i=1;i<A.size();++i){
         String tep=A.get(i).updated;
         if(tep.equals(temp)){
             f.add(A.get(i).ans);
         }
         else{
             ans.add(f);
             f=new ArrayList<>();
             --i;
             temp=tep;
         }
     }
     ans.add(f);
return ans;
        
    }
}