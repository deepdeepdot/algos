class Solution {
    public int reverse(int x) {
        long result = 0;
        int maximus = Math.abs(x);

        while (maximus > 0) {
            int digit = maximus % 10;
            maximus = maximus / 10;
            result = result * 10 + digit;            
        }
        result = (result < Integer.MAX_VALUE)? result: 0;
        return (int)result * ((x < 0)? -1 : 1);
    }
}
