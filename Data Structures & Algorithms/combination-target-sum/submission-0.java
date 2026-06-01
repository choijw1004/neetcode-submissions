class Solution {
    List<List<Integer>> list;
    int[] nums;
    int n, target;
    private void dfs(int idx, int currSum, List<Integer> tmp){
        if(currSum == target){
            list.add(new ArrayList<>(tmp));
            return;
        }

        if(currSum > target) return;

        for(int i = idx; i < n; i++){
            int newSum = currSum + nums[i];
            tmp.add(nums[i]);
            dfs(i, newSum, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.list = new ArrayList<>();
        this.nums = nums;
        this.target = target;
        this.n = nums.length;
        
        dfs(0, 0, new ArrayList<>());

        return list;
    }
}
