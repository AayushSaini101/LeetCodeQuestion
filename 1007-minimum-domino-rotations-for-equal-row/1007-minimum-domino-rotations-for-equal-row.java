class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
     int min=Integer.MAX_VALUE;
     boolean first=true;
     boolean second=true;
     for(int i=0;i<tops.length-1;++i){
          if(tops[i]!=tops[i+1]){
              first=false;
          }
          if(bottoms[i]!=bottoms[i+1]){
              second=false;
          }
     }
        if(first||second){
            return 0;
        }
     for(int i=1;i<=6;++i){
         int count=-1;
       
         for(int j=0;j<tops.length;++j){
             if(tops[j]!=i){
                 if(bottoms[j]!=i){
                     count=-1;
                     break;
                 }
                 else{
                     if(count==-1){
                         count=0;
                     }
                     ++count;
                 }
             }
           
         }
         
         if(count!=-1){
             min=Math.min(min,count);
         }
     }
        
    for(int i=1;i<=6;++i){
         int count=-1;
         int check=0;
         for(int j=0;j<bottoms.length;++j){
             if(bottoms[j]!=i){
                  
                 if(tops[j]!=i){ count=-1;
                     break;
                 }
                 else{
                     if(count==-1){
                         count=0;
                     }
                     ++count;
                 }
             }
            
         }
       
      //   System.out.println(count+" "+i);
         if(count!=-1){
             min=Math.min(min,count);
         }
     }
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return min;
        }
    }
}