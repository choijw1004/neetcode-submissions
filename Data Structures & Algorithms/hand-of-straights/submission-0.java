class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = hand.length;

        for(int h : hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        
        if(cnt % groupSize != 0) return false;
        while(cnt > 0){
            int tmp = groupSize;

            int start = map.firstKey();
            for(int i = start; i < start + groupSize; i++){
                if(!map.containsKey(i)) return false;
            }

            for(int i = start; i < start + groupSize; i++){
                map.put(i, map.getOrDefault(i, 0) - 1);
                if(map.get(i) == 0) map.remove(i);
            }


            cnt -= groupSize;
        }
        
        return true;
    }
}
