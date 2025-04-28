class Solution {
    public void setZeroes(int[][] arr) {
        int temp[][] = new int[arr.length][arr[0].length];
        
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0){
                    for(int k = 0;k<arr.length;k++){
                        //temp[i][k] = 0;
                        temp[k][j] = 0;
                    }
                    for(int k = 0;k<arr[0].length;k++){
                        temp[i][k] = 0;
                        //temp[k][j] = 0;
                    }
                }
                if(temp[i][j] != 0){
                    temp[i][j] = arr[i][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = temp[i][j];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}