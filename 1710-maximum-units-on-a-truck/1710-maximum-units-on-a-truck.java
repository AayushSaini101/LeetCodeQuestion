class Solution {
    static class Pair{
        int a;
        int b;
        public Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int maximumUnits(int[][] boxTypes, int trucksize) {
        PriorityQueue<Pair>P=new PriorityQueue<>((x,y)->y.b-x.b);
        for(int i=0;i<boxTypes.length;++i){
            P.add(new Pair(boxTypes[i][0],boxTypes[i][1]));
        }
        int sum=0;
        
        while(P.size()!=0){
         Pair ans=P.poll();
         if(ans.a<=trucksize){
             sum+=ans.a*ans.b;
             trucksize-=ans.a;
         }
            else{
                sum+=trucksize*ans.b;
                break;
            }
        

        }
        return sum;
    }
}