class Solution {
    //using the conecpet of the matrix multiplication 
    
    public static int[][] multiply(int mat1[][],int mat2[][]){
        
    int res[][]=new int[2][2];
    res[0][0] = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
	res[0][1] = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
	res[1][0] = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
	res[1][1] = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];
    return res; 
        
    }
    public static int[][] multiply(int n){
        int answer[][]={{1,0},{0,1}};
        
        int temp=n;
        
        int original[][]={{1,1},{1,0}};
        while(n>0){
            
            if(n%2==1){
            
               answer=multiply(answer,original);
                // System.out.println(answer[0][0]+" "+answer[0][1]+" "+answer[1][0]+" "+answer[1][1]);
                
            }
            
            original=multiply(original,original);
            
        
            n=n>>1;
        }
        
        return answer;
        
    }
    public int fib(int n) {
        
        if(n==0){
            return 0;
        }
        else 
            if(n==1){
                return 1;
        }
        int answer[][]=multiply(n-2);
        
        return answer[0][0]+answer[1][0];
      
    }
}