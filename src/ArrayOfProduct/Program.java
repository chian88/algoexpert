package ArrayOfProduct;

public class Program {
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.

        int[] leftProduct = new int[array.length];
        int[] rightProduct = new int[array.length];
        int[] answer = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProduct[i] = leftRunningProduct;
            leftRunningProduct = leftRunningProduct * array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0 ; i--) {
            rightProduct[i] = rightRunningProduct;
            rightRunningProduct = rightRunningProduct * array[i];
        }

        for (int i = 0 ; i < array.length; i++) {
            answer[i] = leftProduct[i] * rightProduct[i];
        }
        return answer;
    }
}
