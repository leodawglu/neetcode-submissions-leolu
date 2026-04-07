class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaGroups = new HashMap<>();
        for(String s: strs){
            String lowerS = s.toLowerCase();
            int[] charCount = new int[26];
            for(char c: lowerS.toCharArray()){
                charCount[c-'a']++;
            }
            String key = Arrays.toString(charCount);
            anaGroups.computeIfAbsent(key, k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(anaGroups.values());
    }
}
