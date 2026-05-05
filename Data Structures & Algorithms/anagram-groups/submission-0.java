class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0 ; i < n; i++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);

            String str = new String(tmp);
            map.computeIfAbsent(str, x -> new ArrayList<>()).add(strs[i]);
        }

        for(var e : map.entrySet()){
            ans.add(e.getValue());
        }

        return ans;
    }
}
