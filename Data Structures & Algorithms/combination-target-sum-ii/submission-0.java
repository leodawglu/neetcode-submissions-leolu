class Solution {
    /*
    - set elements contains duplicate numbers
    - an element can only be used once, but could be the same number
    - cannot contain duplicate combos

    Observations:
    - cannot repeat same element
    - return elements in any order
    strategy:
    1. backtracking
    2. at start of loop check if sum has met target then add to list
    3. then check if sum exceeds target if so return
    FOR LOOP EACH ELEMENT AFTER PREV
    4. take the current tempList and iterate through existing lists to add new element
    5. loop to start
    6. remove the added element
    */

    private List<List<Integer>> validUniqueCombos;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        validUniqueCombos = new ArrayList<>();

        backtracking(candidates, 0, target, 0, new ArrayList<>());
        return validUniqueCombos;

    }


    private void backtracking(int[] cand, int sum, int target, int startIdx, List<Integer> combo){
        if(sum==target){
            List<Integer> deepCopy = new ArrayList<>(combo);
            validUniqueCombos.add(deepCopy);
            return;
        }
        if(sum>target) return;

        for(int i=startIdx; i<cand.length; i++){
            if(i>startIdx && cand[i]==cand[i-1]) continue;
            combo.add(cand[i]);
            backtracking(cand, sum+cand[i], target, i+1, combo);
            combo.removeLast();
        }

    }
}
