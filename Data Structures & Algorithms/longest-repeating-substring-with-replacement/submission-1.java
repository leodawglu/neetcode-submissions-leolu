class Solution {
    public int characterReplacement(String s, int k) {
        int[] countInWindow = new int[26];
        int l=0, maxLen=0, maxFreq=0;

        for(int r=0; r<s.length(); r++){
            char curr = s.charAt(r);
            countInWindow[curr-'A']++;
            maxFreq = Math.max(maxFreq, countInWindow[curr-'A']);

            if(r-l+1>maxFreq+k){
                countInWindow[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
