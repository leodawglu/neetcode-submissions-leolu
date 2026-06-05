class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());

        for(int num: nums){
            List<List<Integer>> subsetsHolder = new ArrayList<>();
            for(List<Integer> currSet: powerSet){
                List<Integer> copySet = new ArrayList<>(currSet);
                copySet.add(num);
                subsetsHolder.add(copySet);
            }
            powerSet.addAll(subsetsHolder);
        }

        return powerSet;
    }
}
