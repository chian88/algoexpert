package GroupAnagram;

import java.util.*;

class Program {
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        List<String> orderedWords = new ArrayList<String>();
        for (int i = 0 ; i < words.size(); i++) {
            String str = words.get(i);

            char tempArray[] = str.toCharArray();
            Arrays.sort(tempArray);
            orderedWords.add(new String(tempArray));
        }

        Map<String, List<String>> cache = new HashMap<String, List<String>>();

        for (int i = 0 ; i < words.size(); i++) {
            String orderedWord = orderedWords.get(i);
            String word = words.get(i);
            if (cache.containsKey(orderedWord)) {
                List<String> temp = cache.get(orderedWord);
                temp.add(word);
                cache.put(orderedWord, temp);
            } else {
                cache.put(orderedWord, new ArrayList<String>(Arrays.asList(new String[]{word})) );
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();

        Iterator it = cache.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<String, List<String>> entry = (Map.Entry<String, List<String>>) it.next();

            result.add(entry.getValue());
        }


         return result;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(Arrays.asList(new String[]{"yo", "act", "tac", "flop", "foo", "cat", "oy", "olfp"}));
        groupAnagrams(words);
    }


}
