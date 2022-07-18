class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
		// aux[i][j] is the sum of sub-matrix which start at [0][0] and end in [i][j]
        int[][] aux = new int[m + 1][n + 1]; // padding on top and left
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
				// draw a picture, you will understand it easily~
                aux[i][j] = matrix[i - 1][j - 1] + aux[i - 1][j] + aux[i][j - 1] - aux[i - 1][j - 1]; 
            }
        }
        
        int res = 0;
		// try each sub-matrix
        for (int x1 = 1; x1 < m + 1; x1++) {
            for (int y1 = 1; y1 < n + 1; y1++) {
                for (int x2 = x1; x2 < m + 1; x2++) {
                    for (int y2 = y1; y2 < n + 1; y2++) {
                        if (target == aux[x2][y2] - aux[x2][y1 - 1] - aux[x1 - 1][y2] + aux[x1 - 1][y1 - 1])
                            res++;
                    }
                }
            }
        }
        
        return res;
    }
}
