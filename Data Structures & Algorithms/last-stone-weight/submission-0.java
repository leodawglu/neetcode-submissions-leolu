class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones) maxHeap.offer(stone);

        while(maxHeap.size()>1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            int res = smash(x,y);
            if(res!=0)maxHeap.offer(res);
        }

        return maxHeap.size()==0? 0 : maxHeap.poll();
        
    }

    private int smash(int x, int y){
        if(x==y)return 0;
        return x>y? x-y : y-x;
    }
}
