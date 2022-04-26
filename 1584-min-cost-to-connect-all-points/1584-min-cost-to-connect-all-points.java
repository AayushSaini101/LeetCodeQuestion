class Solution {
    //Creating Pair class 
    
    static class Pair{
        int first;
        int second;
        int distance;
        Pair(int first,int second,int distance){
            this.first=first;
            this.second=second;
            this.distance=distance;
        }
    }
    //Function to calculate the minimum distance;
    static int distance(int x,int y,int x1,int y1){
     return Math.abs(x-x1)+Math.abs(y-y1);   
    }
    static boolean union(int x,int y,int parent[]){
        int find_x=find(parent,x);
        int find_y=find(parent,y);
        if(find_x==find_y){
            return false;
        }
        else{
            parent[find_y]=find_x;
            return true;
        }
    }
    static int find(int parent[],int x){
        if(x==parent[x]){
            return parent[x];
        }
        return find(parent,parent[x]);
    }
    
    public int minCostConnectPoints(int[][] points) {
    if(points.length==0||points.length==1){
        return 0;
    }
    int parent[]=new int[points.length+1];
        for(int i=0;i<parent.length;++i){
            //Inserting the points
            parent[i]=i;
        }
    PriorityQueue<Pair>P=new PriorityQueue<>((a,b)->a.distance-b.distance);
    for(int i=0;i<points.length;++i){
        for(int j=i+1;j<points.length;++j){
            int distance=distance(points[i][0],points[i][1],points[j][0],points[j][1]);
            //Inserting the elements in the priority Queue
            P.add(new Pair(i,j,distance));
        }
    }
        int distance=0;
        
   while(P.size()!=0){
       //Remove the first MST
       Pair ob=P.remove();
       if(union(ob.first,ob.second,parent)==true){
           distance+=ob.distance;
       }
       
   }
        return distance;
    }
}