class Solution {
    public boolean isAnagram(String s, String t) {
        return charCounter(s.toLowerCase()).equals(charCounter(t.toLowerCase()));
    }

    private String charCounter(String str){
        int[] charCount = new int[26];
        for(char c: str.toCharArray()){
            charCount[c-'a']++;
        }
        return Arrays.toString(charCount);
    }
}
