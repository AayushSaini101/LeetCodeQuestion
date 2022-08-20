class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
    int fuel = startFuel;
    int i = 0;
    int count = 0;
    int n = stations.length;
    while(fuel<target){
        while(i<n && fuel>=stations[i][0]){
            pq.add(stations[i++][1]);
        }
        if(pq.isEmpty())return -1;
        fuel+=pq.poll();
        count++;
    }
    return count;
}
}