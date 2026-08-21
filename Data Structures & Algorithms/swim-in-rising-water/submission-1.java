class Solution {
    int n, max, mid;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    boolean[][] v;
    int[][] grid;

    
    private boolean canGo(int mid){
        if(bfs(mid)) return true;
        else return false;
    }

    private boolean bfs(int mid){
        if(grid[0][0] > mid) return false;
        
        Queue<int[]> q = new LinkedList<>();
        this.v = new boolean[n][n];
        v[0][0] = true;
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            if(cx == n-1 && cy == n -1) return true;

            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(v[nx][ny]) continue;
                if(grid[nx][ny] > mid) continue;

                v[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        this.max = -1;
        this.n = grid.length;
        this.grid = grid;

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                max = Math.max(grid[i][j], max);
            }
        }

        int left = 0;
        int right = max;
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canGo(mid)){
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }        
        return ans;
    }
}
