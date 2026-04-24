class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                char curr = board[r][c];
                if(curr=='.')continue;
                if(seen.contains(curr+"row"+r)||seen.contains(curr+"col"+c)||seen.contains(curr+"row"+r/3+"col"+c/3))return false;
                seen.add(curr+"row"+r);
                seen.add(curr+"col"+c);
                seen.add(curr+"row"+r/3+"col"+c/3);
            }
        }
        return true;
    }
}
