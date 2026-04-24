class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r=0; r<board.length; r++){
            if(!validRow(r,board))return false;
        }
        for(int c=0; c<board[0].length; c++){
            if(!validCol(c,board))return false;
        }
        for(int r=0; r<board.length; r+=3){
            for(int c=0; c<board[0].length; c+=3){
                if(!validBox(r,c,board))return false;
            }
        }
        return true;
    }
    
    private boolean validBox(int row, int col, char[][] board) {
        Set<Character> seen = new HashSet<>();
        for(int r=row; r<board.length&&r<row+3; r++){
            for(int c=col; c<board[row].length&&c<col+3; c++){
                if(board[r][c]=='.')continue;
                if(seen.contains(board[r][c]))return false;
                seen.add(board[r][c]);
            }
        }
        return true;
    }

    private boolean validRow(int r, char[][] board){
        Set<Character> seen = new HashSet<>();
        for(int c=0; c<board[r].length; c++){
            if(board[r][c]=='.')continue;
            if(seen.contains(board[r][c]))return false;
            seen.add(board[r][c]);
        }
        return true;
    }

    private boolean validCol(int c, char[][] board){
        Set<Character> seen = new HashSet<>();
        for(int r=0; r<board.length; r++){
            if(board[r][c]=='.')continue;
            if(seen.contains(board[r][c]))return false;
            seen.add(board[r][c]);
        }
        return true;
    }
}
