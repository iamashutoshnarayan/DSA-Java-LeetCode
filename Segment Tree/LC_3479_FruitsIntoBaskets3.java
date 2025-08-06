class Solution {
    // Topic : Array, Binary Search, Segment Tree, Ordered Set
    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] baskets) {
            this.n = baskets.length;
            tree = new int[n * 4];
            build(baskets, 0, n - 1, 1);
        }

        void build(int[] baskets, int l, int r, int node) {
            if (l == r) {
                tree[node] = baskets[l];
                return;
            }
            int mid = (l + r) / 2;
            build(baskets, l, mid, node * 2);
            build(baskets, mid + 1, r, node * 2 + 1);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int l, int r, int node, int ql, int qr, int fruit) {
            if (ql > r || qr < l || tree[node] < fruit) return -1;
            if (l == r) return l;

            int mid = (l + r) / 2;
            int leftResult = query(l, mid, node * 2, ql, qr, fruit);
            if (leftResult != -1) return leftResult;
            return query(mid + 1, r, node * 2 + 1, ql, qr, fruit);
        }

        void update(int l, int r, int node, int idx, int value) {
            if (l == r) {
                tree[node] = value;
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid)
                update(l, mid, node * 2, idx, value);
            else
                update(mid + 1, r, node * 2 + 1, idx, value);

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int findAndUseBasket(int fruit) {
            int idx = query(0, n - 1, 1, 0, n - 1, fruit);
            if (idx != -1) {
                update(0, n - 1, 1, idx, 0);  // mark basket as used
            }
            return idx;
        }
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        SegmentTree segTree = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = segTree.findAndUseBasket(fruit);
            if (idx == -1) unplaced++;
        }

        return unplaced;
    }
}