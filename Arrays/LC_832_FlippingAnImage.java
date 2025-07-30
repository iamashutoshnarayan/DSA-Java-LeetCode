class Solution {
    // Topics : Array, Two Pointers, Matrix, Simulation
    public int[][] flipAndInvertImage(int[][] image) {
        for(int row = 0; row < image.length; row++) {
            for(int col = 0; col < image[row].length; col++) {
                if (image[row][col] == 0) {
                    image[row][col] = 1;
                } else {
                    image[row][col] = 0;
                }
            }
            reverse(image[row]);
        }
        return image;
    }
    void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}