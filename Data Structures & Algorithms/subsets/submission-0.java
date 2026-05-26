class Solution {
    List<List<Integer>> list;
    int[] nums;
    int n;

    private void dfs(int idx, List<Integer> tmp){
        if(idx == n){
            list.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[idx]);
        dfs(idx + 1, tmp);

        tmp.remove(tmp.size() - 1);
        dfs(idx + 1, tmp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.list = new ArrayList<>();
        this.nums = nums;
        this.n = nums.length;

        dfs(0, new ArrayList<>());
        return list;
    }
}
