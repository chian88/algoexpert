package MonotonicArray;

public class Program {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        int flag = 0;
        boolean firstChange = true;

        if (array.length == 0 || array.length == 1) return true;

        for(int i = 1; i < array.length; i++) {
            int prev = array[i - 1];
            int curr = array[i];
            if (curr > prev && firstChange) {
                firstChange = false;
                flag = 1;
            } else if (curr < prev && firstChange) {
                firstChange = false;
                flag = -1;
            } else if (curr > prev && flag == -1) {
                return false;
            } else if (curr < prev && flag == 1) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, -1, -2, -5};
        Program.isMonotonic(array);
    }
}
