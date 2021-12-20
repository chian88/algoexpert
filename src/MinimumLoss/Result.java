package MinimumLoss;


import java.util.*;


class Result {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

    public static int minimumLoss(List<Long> price) {

        Map<Long, Integer> mapToIdx = new HashMap<>();

        for (int i = 0; i < price.size(); i++) {
            mapToIdx.put(price.get(i), i);
        }

        price.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });

        int minLoss = Integer.MAX_VALUE;

        for (int i = 0; i < price.size() - 1; i++) {
            long current = price.get(i);
            long next = price.get(i + 1);

            int currentIdx = mapToIdx.get(current);
            int nextIdx = mapToIdx.get(next);

            int loss = (int) Math.abs(current - next);

            if (nextIdx < currentIdx && loss < minLoss) {
                minLoss = loss;
            }
        }

        return minLoss;
    }

    public static void main(String[] args) {
        minimumLoss(new ArrayList<Long>(Arrays.asList(new Long[]{20l,15l,8l,2l,12l})));
    }

}
