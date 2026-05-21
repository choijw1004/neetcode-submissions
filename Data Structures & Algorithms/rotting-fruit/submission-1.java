class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;  
        if(q.isEmpty()) return -1; 

        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){
                int[] curr = q.poll();

                for(int d = 0; d < 4; d++){
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            time++;
        }
        for(int i = 0 ; i < n; i++){
            System.out.println();
            for(int j = 0 ; j < m; j++){
                System.out.print(grid[i][j] + " ");
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return time - 1;
    }
}
