class Solution {
    /*
    Minimum number of minutes 
    - therefore must start from all possible rotting fruits
    - Queue: level order traversal
    - No rotting fruits: 0min / no time
    - Fresh fruit no adjacent rotting: -1min / impossible

    1. Collect and count all grids of rotting fruits
    2. If no rotting, return 0min

    */
    final int[][] DIR = {{0,1},{0,-1},{1,0},{-1,0}};
    private int fresh = 0;
    private int rotten = 0;
    private int rLen = 0, cLen = 0;
    public int orangesRotting(int[][] grid) {
        rLen = grid.length;
        cLen = grid[0].length;
        if(rLen==0 || cLen==0)return 0;

        Queue<int[]> rotQ = new LinkedList<>();

        for(int r=0; r<rLen; r++){
            for(int c=0; c<cLen; c++){
                if(grid[r][c]==0) continue;
                if(grid[r][c]==1) fresh++;
                else{ // 2: rotten
                    rotQ.offer(new int[]{r,c});
                }
            }
        }
        rotten = rotQ.size();
        if(fresh==0)return 0;
        
        int time = 0;
        while(!rotQ.isEmpty()&&fresh>0){
            int size = rotQ.size();
            while(size>0){
                int[] f = rotQ.poll();
                int row = f[0], col = f[1];
                for(int[] d: DIR){
                    int r = row+d[0], c = col+d[1];
                    if(r<0||c<0||r>=rLen||c>=cLen) continue;
                    if(grid[r][c]==0||grid[r][c]==2) continue;
                    grid[r][c]=2;
                    rotQ.offer(new int[]{r,c});
                    rotten++;
                    fresh--;
                }
                size--;
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}
