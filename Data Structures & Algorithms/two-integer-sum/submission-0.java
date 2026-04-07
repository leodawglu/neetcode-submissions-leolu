class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int diff = target-curr;
            if(numMap.containsKey(diff)){
                return new int[]{numMap.get(diff),i};
            }
            numMap.put(curr,i);
        }
        return new int[]{};
    }
}
