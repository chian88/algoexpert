package HeapSort;

import java.util.*;

class Program {
    public static int[] heapSort(int[] array) {
        // Write your code here.

        buildHeap(array);

        int heapEndIdx = array.length - 1;

        while (heapEndIdx > 0) {
            swap(array, 0, heapEndIdx);
            heapEndIdx --;
            siftDown(array, 0, heapEndIdx);
        }
        return array;
    }

    static void buildHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;

        for (int i = firstParentIdx; i >= 0; i--) {
            siftDown(array, i, array.length - 1);
        }
    }

    static void siftDown(int[] array, int parentIdx, int endIdx) {
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;

        if (leftChildIdx > endIdx) return;

        int leftChild = Integer.MIN_VALUE;
        int rightChild = Integer.MIN_VALUE;

        if (leftChildIdx <= endIdx) {
            leftChild = array[leftChildIdx];
        }

        if (rightChildIdx <= endIdx) {
            rightChild = array[rightChildIdx];
        }


        if (array[parentIdx] < leftChild || array[parentIdx] < rightChild) {
            if (leftChild < rightChild) {
                // swap parent with right Child
                swap(array, parentIdx, rightChildIdx);
                siftDown(array, rightChildIdx, endIdx);
            } else {
                // swap parent with left Child.
                swap(array, parentIdx, leftChildIdx);
                siftDown(array, leftChildIdx, endIdx);
            }
        }

    }

    static void swap(int[] array, int leftIdx , int rightIdx) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }

    public static void main(String[] args) {
        heapSort(new int[]{5, -2, 2, -8, 3, -10, -6, -1, 2, -2, 9, 1, 1});
    }
}
