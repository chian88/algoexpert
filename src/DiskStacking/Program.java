package DiskStacking;
import java.util.*;

public class Program {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        disks.sort(Comparator.comparingInt(disk -> disk[2]));

        int[] heights = new int[disks.size()];

        for (int i = 0; i < disks.size() ; i++) {
            heights[i] = disks.get(i)[2];
        }

        int[] sequences = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            sequences[i] = Integer.MIN_VALUE;
        }

        int maxHeightIdx = 0;
        for (int i = 0; i < disks.size() ; i++) {
            for (int j = 0; j < i ; j++) {
                Integer[] currentDisk = disks.get(i);
                Integer[] otherDisk = disks.get(j);

                if(otherDisk[0] < currentDisk[0] &&
                   otherDisk[1] < currentDisk[1] &&
                        otherDisk[2] < currentDisk[2] )  {

                    if (heights[i] <= currentDisk[2] + heights[j]) {
                        heights[i] = currentDisk[2] + heights[j];
                        sequences[i] = j;
                    }
                }

            }

            if (heights[i] >= heights[maxHeightIdx]) {
                maxHeightIdx = i;
            }
        }
        return buildSequence(disks, sequences, maxHeightIdx);

    }

    public static List<Integer[]> buildSequence(List<Integer[]> array,
                                                int[] sequences, int currentIdx) {
        List<Integer[]> sequence = new ArrayList<Integer[]>();
        while(currentIdx != Integer.MIN_VALUE) {
            sequence.add(0, array.get(currentIdx));
            currentIdx = sequences[currentIdx];
        }

        return sequence;
    }

    public static void main(String[] args) {
        Integer[][] question = new Integer[][]{{2,1,2}, {3,2,3}, {2,2,8}, {2,3,4}, {1,3,1}, {4,4,5} };
        List<Integer[]> que = Arrays.asList(question);

        diskStacking(que);

    }
}
