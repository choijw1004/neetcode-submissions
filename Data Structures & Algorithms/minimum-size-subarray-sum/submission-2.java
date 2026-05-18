class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        while(end < n){
            sum += nums[end];
            
            while(sum >= target){
                if(end - start + 1 <= min && sum >= target){
                    min = end - start + 1;
                }

                sum -= nums[start];
                start++;
            }

            end++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}