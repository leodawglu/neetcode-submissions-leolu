class Solution {

    private List<List<Integer>> permutations;
    public List<List<Integer>> permute(int[] nums) {
        permutations = new ArrayList<>();
        backtracking(nums, new ArrayList<>());

        return permutations;
    }


    private void backtracking(int[] nums, List<Integer> combo){
        if(combo.size() == nums.length){
            List<Integer> copy = new ArrayList<>(combo);
            permutations.add(copy);
            return;
        }

        for(int num: nums){
            if(combo.contains(num))continue;
            combo.add(num);
            backtracking(nums, combo);
            combo.removeLast();
        }
    }
}
