package ClassPhoto;

import java.util.*;

class Program {

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.

        redShirtHeights.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        blueShirtHeights.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int tallestRed = redShirtHeights.get(0);
        int tallestBlue = blueShirtHeights.get(0);

        if (tallestBlue > tallestRed) {
            // blue  in the back
            for (int i = 0; i < blueShirtHeights.size(); i++) {
                if (redShirtHeights.get(i) >= blueShirtHeights.get(i)) return false;
            }

        } else if (tallestBlue < tallestRed) {
            // red in the back.
            for (int i = 0; i < redShirtHeights.size(); i++) {
                if (blueShirtHeights.get(i) >= redShirtHeights.get(i)) return false;
            }
        } else {
            return false;
        }

        return true;
    }
}
