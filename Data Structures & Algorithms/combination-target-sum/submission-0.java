class Solution {
    private List<List<Integer>> validUniqueCombos;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        validUniqueCombos = new ArrayList<>();
        backtracking(nums, 0, 0, target, new ArrayList<>());
        return validUniqueCombos;
        
    }

    private void backtracking(int[] nums, int startIdx, int sum, int target, List<Integer> combo){
        if(sum==target){
            List<Integer> deepCopy = new ArrayList<>(combo);
            validUniqueCombos.add(deepCopy);
            return;
        }
        if(sum>target) return;

        for(int i=startIdx; i<nums.length; i++){
            combo.add(nums[i]);
            backtracking(nums, i, sum+nums[i], target, combo);
            combo.removeLast();
        }
    }
}
