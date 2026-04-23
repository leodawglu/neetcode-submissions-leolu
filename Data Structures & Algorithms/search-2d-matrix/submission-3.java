class Solution {
    int m=-1, n=-1;
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        int l = 0, r = m*n-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            int row = mid/n, col = mid%n;
            int curr = matrix[row][col];
            if(curr==target)return true;
            if(curr>target)r = mid-1;
            else l = mid+1;
        }
        return false;
    }
}
