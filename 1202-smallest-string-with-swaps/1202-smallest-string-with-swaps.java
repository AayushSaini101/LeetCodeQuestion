class Solution {
    static int find(int x,int parent[]){
        if(x==parent[x]){
            return x;
        }
       return find(parent[x],parent);
    }
    static void union(int x,int y,int parent[]){
        int root1=find(x,parent);
        int root2=find(y,parent);
        if(root1!=root2){
            parent[root2]=root1;
        }
        
    }
    static void DFS(List<List<Integer>>L,int index,boolean bl[],ArrayList<Integer>no,ArrayList<Character>ch,String m){
        bl[index]=true;
        no.add(index);
        ch.add(m.charAt(index));
        for(int connected:L.get(index)){
            if(bl[connected]==false){
                
                bl[connected]=true;
                DFS(L,connected,bl,no,ch,m);
            }
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    List<List<Integer>>L=new ArrayList<>();
    for(int i=0;i<=s.length();++i){
        L.add(new ArrayList<>());
    }
        char ans[]=s.toCharArray();
        for(int i=0;i<pairs.size();++i){
            List<Integer>temp=pairs.get(i);
            L.get(temp.get(0)).add(temp.get(1));
            L.get(temp.get(1)).add(temp.get(0));
        }
        boolean bl[]=new boolean[s.length()];
        for(int i=0;i<s.length();++i){
            ArrayList<Integer>index=new ArrayList<Integer>();
            ArrayList<Character>ch=new ArrayList<Character>();
            if(bl[i]==false){
                 DFS(L,i,bl,index,ch,s);
             
            Collections.sort(ch);
                Collections.sort(index);
                   System.out.println(index+" "+ch);
                int ide=0;
                for(int elements:index){
                    ans[elements]=ch.get(ide++);
                }
            }
        }
        StringBuffer anss=new StringBuffer("");
        for(int i=0;i<ans.length;++i){
            anss=anss.append(""+ans[i]);
        }
        return anss.toString();
    }
}