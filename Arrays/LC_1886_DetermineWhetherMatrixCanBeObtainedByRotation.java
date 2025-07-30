class Solution {
    // Topic : Array, Matrix
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean flag = false;
        for (int rotation = 0; rotation < 4; rotation++) {
            if (isEqual(mat, target)) {
                flag = true;
            } else {
                rotate(mat);
            }
        }
        return flag;
    }

    private void rotate(int[][] arr) {
        int n = arr.length;
        int[][] temp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = arr[j][n - 1 - i];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    private boolean isEqual(int[][] a, int[][] b) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}