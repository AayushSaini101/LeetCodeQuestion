class Solution {
    public class Pair{
         int start=0;
         int end=0;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public List<Integer> partitionLabels(String s) {
        int starting[]=new int[26];
        int ending[]=new int[26];
        Arrays.fill(starting,-1);
        Arrays.fill(ending,-1);
        
        for(int i=0;i<s.length();++i){
            
            if(starting[s.charAt(i)-'a']==-1){
                starting[s.charAt(i)-'a']=i;
            }
        }
         for(int i=s.length()-1;i>=0;--i){
            
            if(ending[s.charAt(i)-'a']==-1){
                ending[s.charAt(i)-'a']=i;
            }
        }
        
        //Storing the starting and the ending index of the each character 
        
        List<Pair>lst=new ArrayList<>();
        
        for(int i=0;i<26;++i){
            if(starting[i]!=-1)
            lst.add(new Pair(starting[i],ending[i]));
        }
        
        Collections.sort(lst,(a,b)->a.start-b.start);
        
        int x=0;
        int y=0;
        int max=0;
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<lst.size();++i){
            int x1=lst.get(i).start;
            int y1=lst.get(i).end;
            
            if(i==0){
                max=y1;
            }
            else{
                
                if(x1>max){
                    //This is occurs outside the range
                    ans.add(max+1);
                    
                    max=y1;
                }
                else{
                    max=Math.max(max,y1);
                }
                
            }
            
        }
        
        ans.add(max+1);
       // System.out.println(ans);
       int sum=0;
       for(int i=0;i<ans.size();++i){
           if(i==0){
               sum=ans.get(i);
           }
           else{
               int element=ans.get(i);
               ans.remove(i);
               ans.add(i,element-sum);
               sum+=ans.get(i);
           }
       }
        
        
        return ans;
        
    }
}