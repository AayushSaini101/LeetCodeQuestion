class Solution {
    public boolean can(int task[][],int mid){
        int energy=mid;
        for(int i=0;i<task.length;++i){
            int required=task[i][0];
            int min=task[i][1];
            if(energy<min){
                return false;
            }
            else{
                energy-=required;
            }
        }
        return true;
    }
    public int minimumEffort(int[][] task) {
        // 4 12          
        // 4 23             
      Arrays.sort(task,new Comparator<int[]>(){
          @Override
          public int compare(int a[],int b[]){
            return Integer.compare(a[0]-a[1],b[0]-b[1]);
              
              
          }
      });
        
       //Let's do binary search
        int min=Integer.MAX_VALUE;
        
        int max=0;
        
        for(int i=0;i<task.length;++i){
            min=Math.min(min,task[i][0]);
            max+=task[i][0]+task[i][1];
        }
        int answer=0;
        while(min<=max){
            
            int mid=(min+max)>>1;
            
            if(can(task,mid)){
                answer=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return answer;
    }
}