class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int l = 0, r = 0, maxsum = 0, curr = 0;

        while (r < nums.length) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                curr -= nums[l];
                l++;
            }
            set.add(nums[r]);
            curr += nums[r];
            maxsum = Math.max(maxsum, curr);
            r++;
        }

        return maxsum;
    }
}