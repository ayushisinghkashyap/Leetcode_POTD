class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum =0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum > 0){
            int count = 1;
        int maxcount = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1] && nums[i-1] == 1){
                count++;
                maxcount = Math.max(count, maxcount);
            }
            else{
                count = 1;
            }
        }
        return maxcount;
        }
        else{
            return 0;
        }
    }
}