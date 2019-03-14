import java.util.*;

class Main {
    public static int BOMBED = -345234352;

    int uniqueCount(int[] values) {
        int dupCount = 0;
        for (int i = 0; i < values.length-1; i++) {
            if (values[i] == values[i+1]) {
                dupCount++;
            }
        }
        return values.length - dupCount;
    }

    int removeDuplicates(int[] values) {
        int uniques = uniqueCount(values);

        // System.out.println("Uniques: " + uniques);

        // Bomb the soldier (do it backwards!)
        for (int i = values.length-1; i>0; i--) {
            if (values[i-1] == values[i]) {
                values[i] = BOMBED;
            }
        }
        int nextLiveIdx = 0;
        for (int i = 0; i < uniques; i++) {
            values[i] = values[nextLiveIdx++];

            // Find next live soldier
            for (int j = nextLiveIdx; j < values.length; j++) {
                if (values[nextLiveIdx] != BOMBED) {
                    break;
                }
                nextLiveIdx++;
            }
        }
        return uniques;
    }

    public static void main(String[] args) {
        Main program = new Main();
        int[] values = new int[] { 0,0,1,1,1,2,2,3,3,4 };
        program.removeDuplicates(values);

        for (int val: values) {
            System.out.println(val);
        }
    }
}
