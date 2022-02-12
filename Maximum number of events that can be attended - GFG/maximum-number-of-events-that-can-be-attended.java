// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            int[] start = new int[N];
            int[] end = new int[N];
            
            for(int i=0; i<N; i++)
            {
                start[i] = Integer.parseInt(S1[i]);
                end[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxEvents(start,end,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static class Pair{
        int start;
        int end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    static int maxEvents(int[] start, int[] end, int N) {
        // code here
        List<Pair>lst=new ArrayList<>();
        for(int i=0;i<start.length;++i){
            lst.add(new Pair(start[i],end[i]));
            
        }
        Collections.sort(lst,new Comparator<Pair>(){
            @Override
            public int compare(Pair first,Pair second){
                if(first.end==second.end){
                    //Sorting according to the end of the day
                    return first.start-second.start;
                }
                else{
                    //Sorting according to the starting of the day
                    return first.end-second.end;
                }
            }
        });
        
        //
        TreeSet<Integer>st=new TreeSet<>();
        for(int i=1;i<=100000;++i){
            //Taking the tree set 
            st.add(i);
        }
    int count=0;
     for(int i=0;i<lst.size();++i){
         int starting=lst.get(i).start;
         int ending=lst.get(i).end;
         
         if(st.contains(starting)){
             ++count;
             st.remove(new Integer(starting));
         }
         else{
             //Find the  just greater day than the Starnig day 
             if(st.ceiling(new Integer(starting))!=null){
                 int day=st.ceiling(new Integer(starting));
                 if(day<=ending){
                     ++count;
                     st.remove(new Integer(day));
                 }
             }
         }
         
     } return count;
     
    }
};