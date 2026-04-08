class Solution {
    public int maxArea(int[] heights) {
        int l=0, r=heights.length-1, max=0;
        while(l<r){
            int height = heights[l]<heights[r]? heights[l]:heights[r];
            int width = r-l;
            if(max<width*height)max=width*height;
            if(heights[l]<heights[r])l++;
            else r--;
        }
        return max;
    }
}
