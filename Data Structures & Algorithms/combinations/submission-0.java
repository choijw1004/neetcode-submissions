class Solution {
    List<List<Integer>> ans;
    int n, k;

    private void dfs(List<Integer> tmp, int start) {
        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.ans = new ArrayList<>();
        dfs(new ArrayList<>(), 1);
        return ans;
    }
}