class Solution {
    /*
    Since same task would need to be separated by n cycles
    and tasks are represented by alphabets A to Z

    - Count tasks for each alphabet

    
    */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char t: tasks){
            counts[t-'A']++;
        }

        Arrays.sort(counts);
        int maxFreq = counts[25];
        int numMaxFreq=0;
        for(int freq: counts){
            if(freq==maxFreq)numMaxFreq++;
        }
        int totalEstimatedTime = (maxFreq-1)*(n+1)+numMaxFreq;

        return Math.max(tasks.length, totalEstimatedTime);
    }
}
