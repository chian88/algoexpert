package LongestStringChain;

import java.util.*;

class Program {

    static class StringChain{
        int length;
        String nextString;

        StringChain(int length, String nextString) {
            this.length = length;
            this.nextString = nextString;
        }


    }


    public static List<String> longestStringChain(List<String> strings) {
        // Write your code here.
        if (strings.isEmpty()) return new ArrayList<String>();

        strings.sort((a,b) -> a.length() - b.length());
        Map<String, StringChain> structure = new HashMap<>();

        for (String string : strings) {
            structure.put(string, new StringChain(1, ""));
        }

        for (int i = 0; i < strings.size(); i++) {
            String current = strings.get(i);
            StringChain currentStringChain = structure.get(current);

            for (int j = 0; j < current.length(); j++) {
                String subStr = current.substring(0, j) + current.substring(j+1, current.length());
                if (structure.containsKey(subStr)) {
                    StringChain subStrStringChain = structure.get(subStr);

                    if (subStrStringChain.length >= currentStringChain.length) {
                        currentStringChain.length = subStrStringChain.length + 1;
                        currentStringChain.nextString = subStr;
                    }
                }
            }
            structure.put(current, currentStringChain);
        }

        int longestLength = Integer.MIN_VALUE;
        String longestChain = "";

        Iterator it = structure.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            StringChain chain = (StringChain) pair.getValue();
            String str = (String) pair.getKey();

            if (chain.length > longestLength) {
                longestLength = chain.length;
                longestChain = str;
            }
        }

        ArrayList<String> result = new ArrayList<>();

        if (longestLength <= 1) return result;

        StringChain longestStringChain =  structure.get(longestChain);
        result.add(longestChain);

        while(longestStringChain.nextString != "") {
            result.add(longestStringChain.nextString);
            longestStringChain = structure.get(longestStringChain.nextString);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList(new String[]{"abcdefg1", "1234c", "abdefg2", "abdfg", "123", "122", "bgg", "g", "1a2345", "12a345"}));
        longestStringChain(strings);
    }
}
