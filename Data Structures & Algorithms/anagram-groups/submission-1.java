class Solution {
    /*
    - count num of each char in word
    - compare with existing list with same count and add to list/ create new list
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapStrs = new HashMap<>();

        for(String s: strs){
            String count = charCounts(s);
            List<String> sList = mapStrs.getOrDefault(count, new ArrayList<>());
            sList.add(s);
            mapStrs.put(count,sList);
        }

        List<List<String>> grp = new ArrayList<>();

        for(List<String> list: mapStrs.values()){
            grp.add(list);
        }

        return grp;
    }


    private String charCounts(String word){
        char[] count = new char[26];
        for(char c: word.toLowerCase().toCharArray()){
            count[c-'a']++;
        }
        return new String(count);
    }
}
