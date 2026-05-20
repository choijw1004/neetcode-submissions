class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0;  j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;

                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] == 0) cnt++;
                }
            }
        }

        return cnt;
    }
}