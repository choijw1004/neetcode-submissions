class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        int target = nums.length / 3;

        for(var l : list){
            if(l.getValue() > target) ans.add(l.getKey());
        }

        return ans;
    }
}