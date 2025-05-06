class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        int k=0;
        for(int i=n-1;i>=0;i--){
            for(int j =0;j<n;j++){
                temp[j][k] = matrix[i][j];
            }
            k++;
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                matrix[i][j] = temp[i][j];
            }
        }
        
    }
}