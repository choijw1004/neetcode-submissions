class Solution {
    List<List<Integer>> ans;
    int[] nums;
    int n;
    private void dfs(int idx, List<Integer> tmp, boolean[] visited){
        if(tmp.size() == n){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                tmp.add(nums[i]);
                visited[i] = true;
                dfs(idx + 1, tmp, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
            
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        this.nums = nums;
        this.n = nums.length;

        dfs(0, new ArrayList<>(), new boolean[n]);
        return ans;
    }
}
