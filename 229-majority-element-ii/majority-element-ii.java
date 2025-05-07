class Solution {
    public ArrayList<Integer> majorityElement(int[] nums) {
        int count = 1;
        int n = nums.length;
        ArrayList<Integer> num = new ArrayList<>();
        if(n == 1){
            num.add(nums[0]);
        }
        else if(n==2){
            num.add(nums[0]);
            if(num.contains(nums[1]) == false){
                num.add(nums[1]);
            }
        }
        else{
            Arrays.sort(nums);
        
            for(int i=1;i<nums.length;i++){
                if(nums[i] == nums[i-1]){
                    count++;
                }
                if(count > n/3){
                    //num.add(nums[i-1]);
                    if(num.contains(nums[i-1]) == false){
                        num.add(nums[i-1]);
                        count = 1;
                    }
                }
                else if(nums[i] != nums[i-1]){
                    count = 1;
                }
            }
        }

        return num; 
    }
}