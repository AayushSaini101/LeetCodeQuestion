class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        //Sorting the length of the ballonns
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int previous=-1;
        //At least one arrow required
        int countArrows=1;
        for(int i=0;i<points.length;++i){
            if(previous==-1){
                previous=points[i][1];
            }
            else{
                 if(previous>=points[i][0]){
                     continue;
                 }
                 else{
                     ++countArrows;
                     previous=points[i][1];
                 }
            }
        }
        return countArrows;
    }
}