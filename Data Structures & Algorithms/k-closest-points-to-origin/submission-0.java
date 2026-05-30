class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(manhattan(a),manhattan(b)));

        for(int[] point: points){
            minHeap.offer(point);
        }

        int[][] kClosests = new int[k][2];

        for(int i=0; i<k; i++){
            kClosests[i] = minHeap.poll();
        }

        return kClosests;
    }

    private int manhattan(int[] arr){
        return arr[0]*arr[0] + arr[1]*arr[1];
    }
}
