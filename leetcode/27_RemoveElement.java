class Solution {

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] nums = new int[] {3, 2, 2, 3};
        int[] nums = new int[] {0,1,2,2,3,0,4,2};

        int count = sol.removeElement(nums, 2);

        for (int n: nums) {
            System.out.println(n);
        }
    }
}
