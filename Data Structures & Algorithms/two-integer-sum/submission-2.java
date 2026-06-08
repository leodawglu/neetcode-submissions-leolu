class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            if(seenMap.containsKey(diff)) return new int[]{seenMap.get(diff),i};
            seenMap.put(nums[i],i);
        }

        return new int[]{};
    }
}
