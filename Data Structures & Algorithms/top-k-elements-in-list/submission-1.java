class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums){
            int count = countMap.getOrDefault(num, 0)+1;
            countMap.put(num,count);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->countMap.get(a)-countMap.get(b));
        
        for(int num: countMap.keySet()){
            minHeap.add(num);
            if(minHeap.size()>k) minHeap.poll();
        }
        int[] topK = new int[k];
        for(int i=0; i<k; i++){
            topK[i]=minHeap.poll();
        }
        return topK;
    }
}
