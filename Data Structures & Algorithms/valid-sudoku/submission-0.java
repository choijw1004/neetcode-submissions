class Solution {
    int[] dx = {-1,-1,-1,0,0,1,1,1};
    int[] dy = {-1,0,1,-1,1,-1,0,1};
    public boolean isValidSudoku(char[][] board) {
        //행 탐색
        HashSet<Character> set;
        
        for(int i = 0 ; i < 9; i++){
            set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char c = board[i][j];

                if(c == '.') continue;
                if(set.contains(c)) return false;

                set.add(c);
            }
        }


        //열 탐색
        for(int j = 0 ; j < 9; j++){
            set = new HashSet<>();
            for(int i = 0; i < 9; i++){
                char c = board[i][j];

                if(c == '.') continue;
                if(set.contains(c)) return false;

                set.add(c);
            }
        }

        //대각 탐색
        for(int bi = 0; bi < 9; bi += 3){
            for(int bj = 0; bj < 9; bj += 3){
                set = new HashSet<>();
                for(int i = bi; i < bi + 3; i++){
                    for(int j = bj; j < bj + 3; j++){
                        char c = board[i][j];
                        if(c == '.') continue;
                        if(set.contains(c)) return false;
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }
}
