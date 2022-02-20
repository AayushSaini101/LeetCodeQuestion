class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
          Arrays.sort(intervals, (a,b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
       
	int max=intervals[0][1];
    int count=1;
        
        for(int i=1;i<intervals.length;i++){
            if(max<intervals[i][1] ){
                count++;
                max=intervals[i][1];
            }
        }
        return count;
    }
}