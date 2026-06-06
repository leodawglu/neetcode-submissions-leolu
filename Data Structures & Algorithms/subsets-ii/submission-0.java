class Solution {
    /*
    []
    [], 1, 2
    [], [1,1], [2,1]
    */

    private List<List<Integer>> subsets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int startIdx=0, endIdx=0;
        for(int i=0; i<nums.length; i++){
            startIdx=0; //always reset startIdx;
            if(i>0 && nums[i]==nums[i-1]){
                startIdx = endIdx; //set startIdx to current subset size() / end of subset
            }
            endIdx = subsets.size(); //subsets being modified so need to update endIdx / stop
            List<Integer> newSetHolder = new ArrayList<>();
            for(int j=startIdx; j<endIdx; j++){
                List<Integer> newSet = new ArrayList<>(subsets.get(j));
                newSet.add(nums[i]);
                subsets.add(newSet);
            }
        }

        return subsets;
    }

}
