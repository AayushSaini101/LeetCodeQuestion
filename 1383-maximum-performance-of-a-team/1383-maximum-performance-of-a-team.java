class Solution {
static class Pair{
    int speed;
    int efficiency;
    Pair(int speed,int efficiency){
        this.speed=speed;
        this.efficiency=efficiency;
    }
}    
public int maxPerformance(int n, int[] speed, int[] efficency, int k) {
Pair ob[]=new Pair[speed.length];
for(int i=0;i<ob.length;++i){
    ob[i]=new Pair(speed[i], efficency[i]);
}
Arrays.sort(ob,(x,y)->y.efficiency-x.efficiency);
for(Pair obb:ob){
    System.out.println(obb.speed+" "+obb.efficiency);
}
System.out.println();
PriorityQueue<Integer>P=new PriorityQueue<>();
long sum=0;
long max=0;
for(int i=0;i<speed.length;++i){
   sum+=ob[i].speed;
  P.add(ob[i].speed);
  if(i>=k){
     
sum-=P.poll();

  }

  max=Math.max(sum*ob[i].efficiency,max);
 
}
return (int)(max%1000000007);
        
    }
}