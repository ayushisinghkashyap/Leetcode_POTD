import java.util.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num[] = new int[m+n];
        int i = m;
        int j = 0;
        while(i<n+m){
            nums1[i] = nums2[j];
            j++;
            i++;
        }
        Arrays.sort(nums1);
    }
}