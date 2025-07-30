class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
       int[] target = new int[nums.length];
       for(int i = 0; i < target.length; i++) {
        target[i] = -1;
       }
       for(int i = 0; i < nums.length; i++) {
        if (target[index[i]] != -1) {
            moveRight(target, index[i]);
            target[index[i]] = nums[i];
        } else {
            target[index[i]] = nums[i];
        }
       }
       return target;
    }
    void moveRight(int[] arr, int start) {
        for(int i = arr.length - 2; i >= start; i--) {
            arr[i + 1] = arr[i];
        }
    }
}