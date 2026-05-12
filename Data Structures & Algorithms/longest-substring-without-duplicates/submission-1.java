class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        String ans;

        while(right < len){
            //슬라이딩 늘리고
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;

            while(map.size() != right - left){
                char start = s.charAt(left);
                map.put(start, map.getOrDefault(start, 0) - 1);
                if(map.get(start) <= 0) map.remove(start);
                left++;
            }

            if(right - left>= maxLen){
                maxLen = right - left;
            }
        }
        return maxLen;
    }
}
