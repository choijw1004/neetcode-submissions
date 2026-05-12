class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int ans = -1;

        while(start < end){
            int tmp = (end - start) * Math.min(heights[end], heights[start]);
            
            if(tmp > ans){
                ans = tmp;
            }

            if(heights[start] > heights[end]) {
                end--;
            }
            else if(heights[end] > heights[start]) {
                start++;
            }
            else start++;
        }
        return ans;
    }
}
