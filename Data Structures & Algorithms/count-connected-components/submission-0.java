class Solution {
    List<List<Integer>> g;
    boolean[] visited;

    private void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(var n : g.get(curr)){
                if(!visited[n]){
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
        
    }
    public int countComponents(int n, int[][] edges) {
        this.g = new ArrayList<>();
        this.visited = new boolean[n];

        for(int i = 0 ; i < n; i++){
            g.add(new ArrayList<>());
        }

        for(var e : edges){
            int u = e[0];
            int v = e[1];

            g.get(u).add(v);
            g.get(v).add(u);
        }

        int cnt = 0;

        for(int i= 0 ; i < n; i++){
            if(!visited[i]){
                bfs(i);
                cnt++;    
            }

        }

        return cnt;
    }
}
