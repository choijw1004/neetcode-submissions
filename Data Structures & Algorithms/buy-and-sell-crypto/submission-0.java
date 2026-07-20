class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;

        for(int i = 0 ; i < n; i++){
            for(int j = i ; j < n; j++){
                int tmp = prices[j] - prices[i];
                
                max = Math.max(tmp, max);
            }
        }
        return max;
    }
}
