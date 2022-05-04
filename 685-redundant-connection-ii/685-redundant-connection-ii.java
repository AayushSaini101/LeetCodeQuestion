import java.util.*;
import java.io.*;

class Solution {
    public int find(int parent[],int value){
        if(parent[value]==-1){
            return value;
        }
        return parent[value]=find(parent,parent[value]);
        
    }
    public boolean union(int parent[],int first,int second){
        int firstParent=find(parent,first);
        int secondParent=find(parent,second);
        
        if(firstParent==secondParent){
            return false;
        }
        else{
            parent[firstParent]=secondParent;
            return true;
        }
    }
    public boolean checkCycle(int edges[][],int remove){
        int parent[]=new int[edges.length+1];
        

        Arrays.fill(parent,-1);
        
        for(int i=0;i<edges.length;++i){
            if(i==remove)continue;
            
            if(union(parent,edges[i][0],edges[i][1])==false){
                return true;
            }
        
    }
        
        return false;
    }
        
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int index1 = -1;
        int index2 = -1;

        int value = 0;

        int parent[] = new int[edges.length + 1];
        for (int i = 0; i < edges.length; ++i) {

            int u = edges[i][0];
            int v = edges[i][1];

            parent[v]++;

            if (parent[v] == 2) {
                value = v;
            }
        }

        for (int i = 0; i < edges.length; ++i) {

            if (edges[i][1] == value) {

                if (index1 == -1) {
                    index1 = i;
                } else {
                    index2 = i;

                }
            }
        }

        
        if (index1 == -1 && index2 == -1) {

            Arrays.fill(parent, -1);

            //Cycle is present in the directed finding the cyle 
            //One node has one parent only we can the union find 

            for (int i = 0; i < edges.length; ++i) {

                if (union(parent, edges[i][0], edges[i][1]) == false) {

                    return new int[]{edges[i][0], edges[i][1]};
                } else {
                    union(parent, edges[i][0], edges[i][1]);
                }

            }
        } else {

            if (checkCycle(edges, index2)) {
                return new int[]{edges[index1][0], edges[index1][1]};
            } else {
                return new int[]{edges[index2][0], edges[index2][1]};
            }


        }
        return new int[2];

    }
    
           
         
       
}