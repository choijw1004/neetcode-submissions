class Solution {
    HashSet<String> set = new HashSet<>();
    HashSet<String> visited = new HashSet<>();
    String target;

    //rotate logic
    private String rotate(String curr, int idx, int dir){
        int t = curr.charAt(idx) - '0';
        char[] arr = curr.toCharArray();

        int up = t + 1;
        int down = t - 1;

        if(up == 10) up = 0;
        if(down == -1) down = 9;
        
        if(dir == 1) arr[idx] = Character.forDigit(up,10);
        if(dir == -1) arr[idx] = Character.forDigit(down,10);

        return new String(arr);
    }

    //8방 탐색 bfs
    private int bfs(){
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();

            //start bfs cycle;
            for(int s = 0; s < size; s++){
                //candidate currrent node;
                String curr = q.poll(); 
                if(curr.equals(target)) return cnt;
                
                //candidate next node;
                //8 direction rotate by 4 index
                for(int i = 0; i < 4; i++){
                    //up

                    //rotate param(String, index, up(1) or down(int) (-1))
                    String next_1 = rotate(curr, i, 1);
                    if(!set.contains(next_1) && !visited.contains(next_1)) {
                        q.offer(next_1);
                        visited.add(next_1);
                    }
                    
                    //down
                    String next_2 = rotate(curr, i , -1);
                    if(!set.contains(next_2) && !visited.contains(next_2)) {
                        q.offer(next_2);
                        visited.add(next_2);
                    }
                }

            }

            cnt++;
        }
        return -1;
    }
    public int openLock(String[] deadends, String target) {
        this.target = target;  
        this.visited = new HashSet<>();
        visited.add("0000");

        for(var s : deadends){
            set.add(s);
        }     

        if(set.contains("0000")) return -1;

        return bfs();
    }
}