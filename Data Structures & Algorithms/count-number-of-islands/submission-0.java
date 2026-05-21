class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    char[][] grid;
    int n,m;
    boolean[][] visited;

    private void bfs(int sx, int sy){
        visited[sx][sy] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] == '1'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

    }
    public int numIslands(char[][] grid) {
        int cnt =0;
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
