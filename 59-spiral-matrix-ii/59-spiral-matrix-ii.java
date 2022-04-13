class Solution {
    public void print(int arr[][]){
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr.length;++j){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
       //These moments using some flag variables 
        //Let's say 
        //Top //left //Right and bottom aare the flags the 
        
        int left,right,top,bottom=0;
        
        left=0;
        
        right=n-1;
        
        top=0;
        
        bottom=n-1;
        
        int answer[][]=new int[n][n];
        
        int value=0;
        
        while(left<=right&&top<=bottom){
            
         
            
            //From left to right 
            
          // Filling the values from the left to right direction 
            
            for(int i=left;i<=right;++i){
                //Filling from the left to right values 
                  ++value;
                
                 answer[top][i]=value;
                
                
            }
            
            ++top;
            //Filling the values from the top to bootom 
            
            for(int i=top;i<=bottom;++i){
                
                 ++value;
                
                answer[i][right]=value;
            }
            
            --right;
            
            for(int i=right;i>=left;--i){
                
                ++value;
                
                answer[bottom][i]=value;
            }
            
            --bottom;
            
            
            //Printing the values from bottom to top 
            
            
            
            for(int i=bottom;i>=top;--i){
                
                ++value;
                
                answer[i][left]=value;
              
            }
            
            ++left;
            
            
           // print(answer);

        
            
        }
        
        return answer;
        
    }
}