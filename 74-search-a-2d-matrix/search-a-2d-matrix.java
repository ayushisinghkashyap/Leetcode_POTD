class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean count = false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(target == matrix[i][j]){
                    count = true;
                    break;
                }
            }
        }
        return count;
    }
}