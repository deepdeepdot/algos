class Solution {
    public boolean isPalindrome(int x) {
        String value = "" + x;
        for (int i = 0; i < value.length()/2; i++) {
            if (value.charAt(i) != value.charAt(value.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
