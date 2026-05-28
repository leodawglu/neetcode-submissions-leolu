class Solution {
    /*
    Start from "safe"/edge 0s: cannot be surrounded
    - Mark all 0s connected to safe 0s
    - All the unsafe 0s are naturally surrounded
    */
    int rLen=0, cLen=0;
    boolean[][] safe;
    int[][] DIR = {{0,1},{0,-1},{1,0},{-1,0}};
    char[][]board;
    public void solve(char[][] board) {
        this.board = board;
        rLen = board.length;
        cLen = board[0].length;

        safe = new boolean[rLen][cLen];//defaults all unsafe

        //left & right edges
        for(int r=0; r<rLen; r++){
            if(board[r][0]=='O') dfs(r,0);
            if(board[r][cLen-1]=='O') dfs(r,cLen-1);
        }

        for(int c=0; c<cLen; c++){
            if(board[0][c]=='O') dfs(0,c);
            if(board[rLen-1][c]=='O')dfs(rLen-1,c);
        }

        //overlay safe boolean board onto main board
        for(int r=0; r<rLen; r++){
            for(int c=0; c<cLen; c++){
                if(!safe[r][c])board[r][c]='X';
            }
        }
    }


    private void dfs(int row, int col){
        safe[row][col]=true;

        for(int[] d: DIR){
            int r = row+d[0];
            int c = col+d[1];
            if(r<0 || c<0 || r>=rLen || c>=cLen)continue;
            if(board[r][c]=='X') continue;
            if(safe[r][c]) continue;
            dfs(r,c);
        }
    }
}
