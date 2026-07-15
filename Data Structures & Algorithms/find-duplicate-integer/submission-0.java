class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(var n : nums){
            if(set.contains(n)) return n;

            set.add(n);
        }

        return 0;
    }
}
