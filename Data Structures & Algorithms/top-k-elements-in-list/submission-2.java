class Solution {
    /*
    loop thru nums, count freq of each num
    store in priority queue as array {num, count}
    priority queue is in min heap and stores only k nums
    frequency less than the top of min heap is discarded/swapped
    */
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->{
            return Integer.compare(countMap.get(a), countMap.get(b));
        });

        for(int num: countMap.keySet()){
            minHeap.offer(num);
            if(minHeap.size()>k)minHeap.poll();
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i]=minHeap.poll();
        }
        return ans;

    }
}
