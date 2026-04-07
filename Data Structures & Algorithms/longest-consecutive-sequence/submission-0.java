class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        int maxLength = 0;
        //remove dupes
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        for(int num : numSet){
            if(numSet.contains(num-1))continue;
            int curr = num;
            int currLength=1;
            while(numSet.contains(++curr))currLength++;
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
