class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] grid;
    boolean[][] visited;
    int r, c;

    
    private int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        visited[sx][sy] = true;

        q.offer(new int[]{sx,sy});
        int cnt = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            cnt++;
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if(visited[nx][ny]) continue;
                if(grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        this.r = grid.length;
        this.c = grid[0].length;
        this.visited = new boolean[r][c];
        this.grid = grid;
        int ans = 0;

        for(int i = 0 ; i < r; i++){
            for(int j = 0; j < c; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ans = Math.max(bfs(i, j), ans);
                }
            }
        }

        return ans;
    }
}
