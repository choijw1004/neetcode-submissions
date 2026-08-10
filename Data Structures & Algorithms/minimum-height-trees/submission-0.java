class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int[] degree = new int[n];
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.offer(i);   
        }

        int remaining = n;
        while (remaining > 2) {               
            int size = q.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int next : graph.get(curr)) {
                    if (--degree[next] == 1) q.offer(next);  
                }
            }
        }

        return new ArrayList<>(q);
    }
}