/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class LC_278_FirstBadVersion extends VersionControl {
    // Topic : Binary Searcxh, Interactive
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}