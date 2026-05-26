class Solution {
    int ans;
    int[] nums;

    private void dfs(int idx, int currSum){
        if(idx == nums.length){
            ans += currSum;
            return;
        }

        dfs(idx + 1, currSum ^ nums[idx]);
        dfs(idx + 1, currSum);
    }
    public int subsetXORSum(int[] nums) {
        this.ans = 0;
        this.nums= nums;

        dfs(0, 0);

        return ans;
    }
}