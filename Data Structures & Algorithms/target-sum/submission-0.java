class Solution {
    int[] nums;
    int target; 
    int cnt = 0;

    private void dfs(int idx, int currSum){
        if(idx == nums.length){
            if(currSum == target) cnt++;
            return;
        }

        dfs(idx + 1, currSum + nums[idx]);
        dfs(idx + 1, currSum - nums[idx]);

    }
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.cnt = cnt;

        dfs(0, 0);     
        return cnt;
    }
}
