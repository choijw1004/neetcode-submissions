class Solution {
    private boolean isValid(String a, String b){
        int cnt = 0;

        for(int i = 0 ; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }

        return cnt == 1 ? true : false;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visitedSet = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visitedSet.add(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                //현재 String 꺼냄
                String curr = q.poll();
                
                if(curr.equals(endWord)){
                    return level;
                }

                for(int j = 0 ; j < wordList.size(); j++){
                    String next = wordList.get(j);
                    //curr이랑 next 비교 
                    if(!visitedSet.contains(next) && isValid(curr, next)){
                        visitedSet.add(next);
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
