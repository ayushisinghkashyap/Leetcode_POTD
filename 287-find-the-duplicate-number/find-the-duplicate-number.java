class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                n = nums[i];
                break;
            }
        }
        return n;
    }
}