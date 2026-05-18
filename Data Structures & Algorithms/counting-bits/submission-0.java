class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <=n; i++){
            String bit = Integer.toBinaryString(i);
            int cnt = 0;
            for(int j = 0; j < bit.length(); j++){
                if(bit.charAt(j) == '1') cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
