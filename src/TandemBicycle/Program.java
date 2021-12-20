package TandemBicycle;

import java.util.*;

class Program {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        int result = 0;
        Arrays.sort(blueShirtSpeeds);
        Arrays.sort(redShirtSpeeds);
        if (fastest) {
            for (int i = 0; i < blueShirtSpeeds.length; i++) {
                int blue = blueShirtSpeeds[i];
                int red = redShirtSpeeds[redShirtSpeeds.length - 1 - i];

                result += Math.max(blue, red);
            }
        } else {
            for (int i = 0; i < blueShirtSpeeds.length; i++) {
                int blue = blueShirtSpeeds[i];
                int red = redShirtSpeeds[i];

                result += Math.max(blue, red);
            }
        }

        return result;
    }
}
