class Solution {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean[] zeroRow = new boolean[n];
        boolean[] zeroCol = new boolean[m];
        
        // 1) 0이 있는 행/열 마킹
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }
        
        // 2) 마킹된 행/열 전체를 0으로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (zeroRow[i] || zeroCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
