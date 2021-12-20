package numbersInPi;
import java.util.*;

public class Program {
    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> numbersToCheck = new HashSet<String>();

        for(String num : numbers) numbersToCheck.add(num);

        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        int minSpaces = getMinSpaces(pi, numbersToCheck, cache, 0);
        return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
    }

    public static int getMinSpaces(String pi, Set<String> numbersTable, Map<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) return -1;
        if (cache.containsKey(idx)) return cache.get(idx);

        int minSpaces = Integer.MAX_VALUE;

        for (int i = idx; i < pi.length(); i++) {
            String prefix = pi.substring(idx, i+1);
            if (numbersTable.contains(prefix)) {
                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i+1);

                if (minSpacesInSuffix == Integer.MAX_VALUE) {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix);
                } else {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
                }
            }
        }
        cache.put(idx, minSpaces);
        return cache.get(idx);
    }

    public static void main(String[] args) {
        Program.numbersInPi("3141592", new String[]{"3141", "5", "31", "2", "4159", "9", "42"});
    }
}
