class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        Arrays.sort(nums);

        int n = nums.length;
        long sum = 0;  // why long ....... cause some testcase are above or below int range 

        for(int i = 0 ; i < n - 3 ; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skips the same number of i
            for(int j = i+1 ; j< n -2 ; j ++ ){
                 if (j > i+1 && nums[j] == nums[j - 1]) continue; // skips the same number of j
                int l = j + 1;
                int r = n -1 ;

                while( l< r){
                    sum = (long)nums[i] + nums[j] + nums[l] + nums[r] ; // typecasting the int --> long and storing sum 
                    if ( sum < target){
                        l++;
                    }
                    else if( sum > target){
                        r -- ;
                    }
                    else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[l], nums[r])); // storing the res 
                        while (l < r && nums[l] == nums[l + 1]) l++; // skips if same number 

                        while(l < r && nums[r] == nums[r -1]) r --; // skips if same number 

                        l++;
                        r--;
                    }
                }
            }
        }

        return res; 
    }
}