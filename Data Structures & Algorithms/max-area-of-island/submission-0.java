class Solution {

    final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}}; 
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c]==0||grid[r][c]==-1) continue;
                maxArea = Math.max(exploreIslandArea(grid,r,c),maxArea);
            }
        }
        return maxArea;
    }

    private int exploreIslandArea(int[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || 
            grid[row][col]==0 || grid[row][col]==-1) return 0;
        
        grid[row][col]=-1;//visited
        int area = 1;
        for(int[] dir: DIRECTIONS){
            area += exploreIslandArea(grid, row+dir[0], col+dir[1]);
        }
        return area;
    }
}
