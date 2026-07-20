class Solution {
    int[] piles;

    private int cal(int mid){
        int sum = 0;
        for(var v : piles){
            sum += (v + mid - 1) / mid;
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        this.piles = piles;

        for(var p : piles){
            max = Math.max(max, p);
        }

        int left = 1;
        int right = max;
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(cal(mid) <= h){
                ans = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }
        
        return ans;
    }
}
