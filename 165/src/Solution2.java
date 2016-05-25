/**
 * Created by yunxiaozou on 5/25/16.
 */
public class Solution2 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int i;
        for (i = 0; i < v1.length && i < v2.length; i++)
            if (Integer.parseInt(v1[i]) != Integer.parseInt(v2[i]))
                return Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]) ? 1 : -1;
        for (; i < v1.length; i++) if (Integer.parseInt(v1[i]) != 0) return 1;
        for (; i < v2.length; i++) if (Integer.parseInt(v2[i]) != 0) return -1;
        return 0;

    }
}
