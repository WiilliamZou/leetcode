import java.util.HashMap;

/**
 * Created by yunxiaozou on 6/3/16.
 */
public class ValidWordAbbr02 {
    HashMap<String, String> map;
    public ValidWordAbbr02(String[] dictionary) {
        map = new HashMap<>();
        for (String str: dictionary) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(str)) {
                    if (!map.get(key).equals(str)) {
                        map.put(key, "");// means this key is not unique.
                    }
                }
            } else {
                map.put(key,str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }

    private String getKey(String str) {
        if(str.length()<=2) return str;
        return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    }
}
