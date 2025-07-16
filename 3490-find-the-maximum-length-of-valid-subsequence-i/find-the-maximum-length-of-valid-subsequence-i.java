class Solution {
    public int maximumLength(int[] nums) {
        if (nums.length == 0) return 0;

        int oddCount = 0, evenCount = 0, alternating = 0;
        boolean expectOdd = nums[0] % 2 == 1;

        for (int num : nums) {
            boolean isOdd = num % 2 == 1;

            if (isOdd == expectOdd) {
                alternating++;
                expectOdd = !expectOdd;
            }

            if (isOdd) oddCount++;
            else evenCount++;
        }

        return Math.max(alternating, Math.max(oddCount, evenCount));
    }
}