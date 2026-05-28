class Solution {
    /*Nearest | Shortest distance to a treasure chest 
    - Breadth first search: Queue/Level-order search
    - Start from the treasures themselves
    - MUST COLLECT ALL TREASURES into the Queue first or else not a true level-ordered search
    - If treasures are not explored level by level, another treasure with longer path would be logged 

    

    */
    final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};
    final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        if(grid==null || grid.length==0) return;
        Queue<int[]> q = new LinkedList<>();
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col]!=0) continue;
                q.offer(new int[]{row,col});
            }
        }

        
        

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d: DIR){
                int r = d[0]+curr[0];
                int c = d[1]+curr[1];

                if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) continue;
                if(grid[r][c]==-1 || grid[r][c] != INF) continue;
                grid[r][c] = grid[curr[0]][curr[1]] + 1;
                q.offer(new int[]{r,c});
            }
        }
    }
}
