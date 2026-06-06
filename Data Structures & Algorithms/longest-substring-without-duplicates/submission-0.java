class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)return 0;

        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen,-1);
        int max=0;
        int left=0;

        for(int right=0; right<s.length(); right++){
            char curr = s.charAt(right);
            if(lastSeen[curr]>=left) left = lastSeen[curr]+1;
            lastSeen[curr] = right;
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
