class Solution {

    private final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    private int n;
    private int m;
    private boolean[][] visited;
    public int numIslands(char[][] grid) {
        int islands = 0;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for(int r=0; r<n;r++){
            for(int c=0; c<m;c++){
                if(grid[r][c]=='0' || visited[r][c]) continue;
                exploreIsland(grid, r,c);
                islands++;
            }
        }

        return islands;
    }

    private void exploreIsland(char[][] grid, int row, int col){
        if(visited[row][col]) return;
        visited[row][col] =true;

        for(int[] d: DIRECTIONS){
            int r = row+d[0], c = col+d[1];
            if(r<0 || r>=n || c<0 || c>=m)continue;
            if(grid[r][c]=='1')exploreIsland(grid, r,c);
        }

    }



}
