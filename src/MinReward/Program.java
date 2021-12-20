package MinReward;

import java.util.*;

class Program {
    public static int minRewards(int[] scores) {
        // Write your code here.

        int[] reward = new int[scores.length];
        Arrays.fill(reward, 0);

        int score = 1;

        for (int i = 0; i < scores.length; i++) {
            int current = scores[i];

            reward[i] = score;

            int leftIdx = i-1;

            while (leftIdx >= 0 && scores[leftIdx] > scores[leftIdx+1]) {
                // increment to the left.

                int tempScore = Math.max(reward[leftIdx], reward[leftIdx+1] + 1);
                reward[leftIdx] = tempScore;
                leftIdx--;
            }

            if ((i+1) < scores.length && scores[i+1] > scores[i]) {
                score += 1;
            } else if ((i+1) < scores.length && scores[i+1] < scores[i]) {
                score = 1;
            }


        }

        int total = 0;

        for (int rew : reward) {
            total += rew;
        }


        return total;
    }

    public static void main(String[] args) {
        minRewards(new int[]{8,4,2,1,3,6,7,9,5});
    }
}
