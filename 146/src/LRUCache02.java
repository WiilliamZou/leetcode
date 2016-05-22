import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yunxiaozou on 5/22/16.
 */
public class LRUCache02 {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache02(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {return map.getOrDefault(key,-1);}
    public void set(int key, int value) {map.put(key,value);}
}
