// { Driver Code Starts
import java.util.*;
import java.math.*;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
         int res[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(res[i], -2);
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 'B'){
                    q.add(new int[]{i, j, 0});
                    res[i][j] = 0;
                }
            }
        }
        
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int t[] = q.poll();
            for(int i = 0; i < 4; i++){
                int r = t[0]+row[i], c = t[1]+col[i];
                if(r >= 0 && r < m && c >= 0 
                	&& c < n && mat[r][c] == 'O'){
                        mat[r][c] = 'X';
                        res[r][c] = t[2]+1;
                        q.add(new int[]{r, c, t[2] + 1});
                }
            }
        }
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 'O')
                    res[i][j] = -1;
                else if(mat[i][j] == 'W')
                    res[i][j] = -1;
            }
        }
        return res;
    }
}