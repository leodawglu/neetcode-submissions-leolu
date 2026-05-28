class Solution {
    /*
    Left, Right, Top, Down edges are touching the waters
    - move up from edge cells
    - use 2 matrices, 1 each for pacific and atlantic
    - matrix tracks which cells can reach one water
    - overlay both matrices to find cells that accesses both waters
    */
    final int[][] DIR = {{0,1},{0,-1},{1,0},{-1,0}};
    private int rLen=0, cLen=0;
    private boolean[][] atlReachable;
    private boolean[][] pacReachable;
    private int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rLen = heights.length;
        cLen = heights[0].length;
        this.heights = heights;
        if(rLen==0||cLen==0)return new ArrayList<>();
        atlReachable = new boolean[rLen][cLen]; //default false
        pacReachable = new boolean[rLen][cLen];

        //top & down cells
        for(int c=0; c<cLen; c++){
            dfsFlowUp(0,c,pacReachable);
            dfsFlowUp(rLen-1,c,atlReachable); 
        }

        //left & right cells
        for(int r=0; r<rLen; r++){
            dfsFlowUp(r,0,pacReachable);
            dfsFlowUp(r,cLen-1,atlReachable);
        }

        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (pacReachable[i][j] && atlReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;

    }

    private void dfsFlowUp(int row, int col, boolean[][] ocean){
        ocean[row][col]=true;
        for(int[] d: DIR){
            int newRow = row+d[0];
            int newCol = col+d[1];
            if(newRow<0 || newCol<0 || newRow>=rLen || newCol>=cLen)continue;
            if(ocean[newRow][newCol])continue;
            if(heights[newRow][newCol]<heights[row][col])continue;
            dfsFlowUp(newRow, newCol, ocean);
        }
    }
}
