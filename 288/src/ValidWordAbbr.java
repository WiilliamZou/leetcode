import java.util.HashMap;


public class ValidWordAbbr {
    HashMap<String, Integer> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String word: dictionary) {
            if (word != null && word.length() != 0) {
                map.put(getAbbr(word), map.getOrDefault(getAbbr(word),0)+1);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!map.containsKey(abbr) || map.get(abbr) == 1)
            return true;
        else
            return false;
    }
    private String getAbbr(String word) {
        if (word == null || word.length() == 0) return null;
        if (word.length() <= 2) return word;
        String result = "";
        result += word.charAt(0);
        result += (word.length()-2);
        result += word.charAt(word.length()-1);
        return result;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");