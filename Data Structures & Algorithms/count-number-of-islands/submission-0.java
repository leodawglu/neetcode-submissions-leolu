class Solution {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int islands = 0;

        for(int row=0; row<grid.length;row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col]!='1')continue;
                exploreIsland(grid,row,col);
                islands++;
            }
        }
        return islands;
    }

    private void exploreIsland(char[][] grid, int r, int c){
        grid[r][c]='2';
        for(int[] dir:directions){
            int row = r+dir[0], col = c+dir[1];
            if(row<0 || row>=grid.length || col<0 ||col>=grid[0].length)continue;
            if(grid[row][col]=='1')exploreIsland(grid,row,col);
        }
    }
}