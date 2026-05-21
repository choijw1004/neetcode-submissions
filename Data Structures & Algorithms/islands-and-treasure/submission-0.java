class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int n,m;
    int[][] grid;
    private int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        boolean[][] visited = new boolean[n][m];
        visited[sx][sy] = true;
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size; i++){
                int[] curr = q.poll();
                if(grid[curr[0]][curr[1]] == 0) return dist;
                for(int d = 0 ; d < 4; d++){
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] != -1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }   
            }
            dist++;
        }

        return Integer.MAX_VALUE;
    }
    public void islandsAndTreasure(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        System.out.println(Integer.MAX_VALUE);
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == Integer.MAX_VALUE) {
                    grid[i][j] =bfs(i,j);
                }
            }
        }
    }
}
