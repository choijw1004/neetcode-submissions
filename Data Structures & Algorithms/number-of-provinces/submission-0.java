class Solution {
    int n;
    List<List<Integer>> g;
    boolean[] visited;
    
    private void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(var next : g.get(curr)){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        this.g = new ArrayList<>();
        this.n = isConnected.length;
        this.visited = new boolean[n];

        int cnt = 0;

        for(int i = 0 ; i < n; i++){
            g.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 0) continue;

                g.get(i).add(j);
                g.get(j).add(i);
            }
        }
        
        for(int i = 0 ; i < n; i++){
            if(!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        return cnt;
    }
}