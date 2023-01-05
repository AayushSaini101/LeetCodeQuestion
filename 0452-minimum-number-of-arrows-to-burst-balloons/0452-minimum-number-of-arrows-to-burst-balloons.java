class Solution {
    
   
    public int findMinArrowShots(int[][] points) {
        
        if(points.length==0)return 0;
        
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        
        int count=0;
        
        //Finding the overlapping the segments of hte points 
        
        int previous=0;
        
        
        for(int i=0;i<points.length;++i){
        
         //   System.out.println(points[i][0]+" "+points[i][1]);
            
           if(points[previous][1]<points[i][0]){
                
                previous=i;
                
                ++count;
            }
            
    }
        
        return count+1;
        
        
   
        
    
    }
}