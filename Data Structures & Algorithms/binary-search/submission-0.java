class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int curr = nums[mid];
            if(target==curr)return mid;
            if(target<curr)r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
