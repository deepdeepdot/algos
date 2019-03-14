public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            char bit = (char)(n >> i & 1);
            result = result | (bit << (31-i));
        }
        return result;
    }
}
