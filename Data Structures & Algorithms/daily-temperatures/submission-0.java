class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> prevTemps = new Stack<>();
        int days = temperatures.length;
        int[] res = new int[days];

        for(int d=0; d<days; d++){
            while(!prevTemps.isEmpty()&&temperatures[d]>temperatures[prevTemps.peek()]){
                int prevIdx = prevTemps.pop();
                res[prevIdx] = d-prevIdx;
            }
            prevTemps.push(d);
        }
        return res;
    }
}
