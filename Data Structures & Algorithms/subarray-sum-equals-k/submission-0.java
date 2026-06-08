class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum=0;
        prefixSum.put(sum,1);

        int subArrCount=0;
        for(int n: nums){
            sum+=n;
            int diff = sum-k;
            if(prefixSum.containsKey(diff)){
                subArrCount += prefixSum.get(diff);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        }
        return subArrCount;
    }
}