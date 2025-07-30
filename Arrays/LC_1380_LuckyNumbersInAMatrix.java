class Solution {
    // Topic : Array, Matrix
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minRow = matrix[i][0];
            int minCol = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < minRow) {
                    minRow = matrix[i][j];
                    minCol = j;
                }
            }
            
            boolean isLucky = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minCol] > minRow) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) result.add(minRow);
        }
        return result;
    }
}