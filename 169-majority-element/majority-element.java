class Solution {
    public int majorityElement(int[] nums) {
        int count =1;
        int n = nums.length;
        int num = 0;
        if(n == 1){
            num = nums[0];
        }
        else{
            Arrays.sort(nums);
        
            for(int i=1;i<nums.length;i++){
                if(nums[i] == nums[i-1]){
                    count++;
                }
                if(count>n/2){
                    num = nums[i];
                    break;
                }
                else if(nums[i] != nums[i-1]){
                    count = 1;
                }
            }
        }

        return num;
    }
}