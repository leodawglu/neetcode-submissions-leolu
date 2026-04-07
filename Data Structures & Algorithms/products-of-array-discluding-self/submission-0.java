class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0]=1;
        //calculate prefix
        for(int i=1; i<nums.length; i++){
            result[i] = nums[i-1]*result[i-1];
        }

        //calculate suffix
        int right = 1;
        for(int i=nums.length-1; i>=0;i--){
            result[i] = result[i]*right;
            right = right * nums[i];
        }

        return result;
    }
}  
