public class LC_1317_IntToNoZeroInt {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (checkNoZero(a) && checkNoZero(b)) {
                return new int[] { a, b };
            }
        }
        return new int[] {};
    }

    private boolean checkNoZero(int z) {
        boolean flag = true;
        while (z > 0) {
            int num = z % 10;
            if (num == 0) {
                flag = false;
                break;
            }
            z = z / 10;
        }
        return flag;
    }
}