class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a,b) -> b.getValue() - a.getValue());

        return list.get(0).getKey();
    }
}