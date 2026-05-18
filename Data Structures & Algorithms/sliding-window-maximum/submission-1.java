class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while(end < n){
            //슬라이딩 미완성
            if(end - start + 1 < k){
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
                end++;
            }

            else{
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
                end++;
                
                //비즈니스 로직 계산
                list.add(map.lastKey());
                map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
                if(map.get(nums[start])<=0) map.remove(nums[start]);
                start++;
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0 ; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
