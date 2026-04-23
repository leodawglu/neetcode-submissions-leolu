/*
Questions.
1a. side of map can collect water? NO

Break down of problem

- shortest wall l v r * width (min 1)
- sides of map cannot collect water 

*/


class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int lMax=height[l], rMax=height[r];
        int vol=0;
        while(l<r){
            if(lMax<rMax){
                l++;
                if(lMax<height[l])lMax=height[l];
                vol += lMax - height[l];
            }else if(rMax<=lMax){
                r--;
                if(rMax<height[r])rMax=height[r];
                vol += rMax - height[r];
            }
        }
        return vol;
    }
}
