class Solution {
    static class Pair{
        int index1;
        int index2;
        Pair(int index1,int index2){
            this.index1=index1;
            this.index2=index2;
        }
    }
     int max=0;
    public void find(int mentor,int total,List<Pair>L,int students[][],int mentors[][],int dp[]){
        if(mentor>=total){
            int sum=0;
           for(Pair ob:L){
               int mentor_number=ob.index1;
               int childern=ob.index2;
              // System.out.println(mentor_number+" "+childern);
               for(int i=0;i<students[0].length;++i){
                   if(mentors[mentor_number][i]==students[childern][i]){
                       ++sum;
                   }
               }
               
           }
            max=Math.max(sum,max);
            return;
        
        }
        for(int i=0;i<total;++i){
              if(dp[i]==-1){
                  dp[i]=1;
                  L.add(new Pair(i,mentor));
                  find(mentor+1,total,L,students,mentors,dp);
                  L.remove(L.size()-1);
                  dp[i]=-1;
              }
        }
    }
    
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        //For every mentor there are m choices then ni 
        int dp[]=new int[mentors.length+1];
        Arrays.fill(dp,-1);
        List<Pair>L=new ArrayList<>();
        find(0,mentors.length,L,students,mentors,dp);
        return max;
        
    }
}