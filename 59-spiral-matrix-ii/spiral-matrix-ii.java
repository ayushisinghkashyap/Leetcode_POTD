class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int val=1;

        int top=0;
        int down=n-1;

        int left=0;
        int right=n-1;

        int dir=0;

        while(left<=right && top<=down){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    matrix[top][i]=val++;
                }
                top++;
            }
            if(dir==1){
                for(int i=top;i<=down;i++){
                    matrix[i][right]=val++;
                }
                right--;
            }
            if(dir==2){
                for(int i=right;i>=left;i--){
                    matrix[down][i]=val++;
                }
                down--;
            }
            if(dir==3){
                for(int i=down;i>=top;i--){
                    matrix[i][left]=val++;
                }
                left++;
            }
            dir++;
            if(dir==4){
                dir=0;
            }
        }
        return matrix;
    }
}