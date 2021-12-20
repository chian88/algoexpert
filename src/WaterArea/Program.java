package WaterArea;

import java.util.HashMap;
import java.util.*;

public class Program {
    public static int waterArea(int[] heights) {
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        int water = 0;

        int currentLeftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            leftMax[i] = currentLeftMax;
            if (heights[i] > currentLeftMax) {
                currentLeftMax = heights[i];
            }
        }

        int currentRightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            rightMax[i] = currentRightMax;
            if (heights[i] > currentRightMax) {
                currentRightMax = heights[i];
            }
        }

        for (int i = 0; i < heights.length; i++) {
            int wall = Math.min(leftMax[i], rightMax[i]);

            if ((wall - heights[i]) > 0) {
                water += (wall - heights[i]);
            }

        }
        return water;
    }



    public static void main(String[] args) {
        int[] array = new int[] {0,8,0,0,5,0,0,10,0,0,1,1,0,3};

        Program.waterArea(array);
    }
}
