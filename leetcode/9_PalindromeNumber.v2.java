import java.util.*;

class Main {

    public static boolean isPalindrome(int x) {
        List<Integer>digits = new ArrayList<Integer>();

        int input = Math.abs(x);
        if (x < 0) {
            digits.add(-1);
        }
        while (input > 0) {
            digits.add(input % 10);
            input = input / 10;
        }
        for (int i = 0; i < digits.size()/2; i++) {
            if (digits.get(i) != digits.get(digits.size()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(-2147483648));
    }
}
