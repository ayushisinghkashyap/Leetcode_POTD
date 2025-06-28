class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int size=nums.length;
        // Create a sorted copy to find the k largest elements
        int sorted[]=Arrays.copyOf(nums, size);
        Arrays.sort(sorted);
        // Determine the smallest value among the top-k elements
        int threshold=sorted[size-k];
        // Count how many times the threshold appears in the top-k
        int thresholdCount=0;
        for(int i=size-k;i<size;i++){
            if(sorted[i]==threshold) thresholdCount++;
        }
        int result[]=new int[k];
        int index=0;
        // Select values from the original array, preserving order
        for(int num:nums){
            if(num>threshold)
            {
                result[index++]=num;
            }
            else if(num==threshold && thresholdCount>0){
                result[index++]=num;
                thresholdCount--;
            }
            if(index == k) break;
        }
        return result;
    }
}