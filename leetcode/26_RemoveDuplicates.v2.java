class Solution {

    int removeDuplicates(int[] values) {
        int BOMBED = -345232352;
        int dupCount = 0;

        // Bomb the soldier (do it backwards!)
        for (int i = values.length-1; i>0; i--) {
            if (values[i-1] == values[i]) {
                values[i] = BOMBED;
                dupCount++;
            }
        }

        int uniques = values.length - dupCount;
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
}
