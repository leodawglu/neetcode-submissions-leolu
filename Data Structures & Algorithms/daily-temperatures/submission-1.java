class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        Stack<Integer> mono = new Stack<>();
        mono.push(0);
        int[] days = new int[size];

        for(int i=1; i<size; i++){
            while(!mono.isEmpty()&&temperatures[i]>temperatures[mono.peek()]){
                int prev = mono.pop();
                days[prev] = i-prev;
            }
            mono.push(i);
        }
        return days;
    }
}
