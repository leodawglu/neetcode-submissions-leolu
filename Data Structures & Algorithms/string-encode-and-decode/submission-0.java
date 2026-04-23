/*
Question, what are the information provided?
- list of strings
- indexes of each string
- length of each string
- characters of each string
- size of each string

*/
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            String curr = strs.get(i);
            sb.append("@").append(i).append("$").append(curr.length()).append("#").append(curr);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int dollarIdx = str.indexOf("$",i);
            int poundIdx = str.indexOf('#',dollarIdx);
            int wordLength = Integer.parseInt(str.substring(dollarIdx+1,poundIdx));
            int wordStart = poundIdx+1;
            String word = str.substring(wordStart,wordStart+wordLength);
            output.add(word);
            i = wordStart+wordLength;
        }
        return output;

    }
}
