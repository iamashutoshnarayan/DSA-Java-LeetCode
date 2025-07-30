class Solution {
    // Topic : Array, Bit Manipulation, Tree, Depth-First Search
    List<Integer>[] tree;
    int[] xorSubtree;
    int[] parent;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        tree = new ArrayList[n];
        for(int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for(int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        xorSubtree = new int[n];
        parent = new int[n];
        parent[0] = -1;

        int totalXor = dfs(0, -1, nums);

        int minScore = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int a = i, b = j;

                if (isDescendant(a, b)) {
                    int xor1 = xorSubtree[a];
                    int xor2 = xorSubtree[b] ^ xorSubtree[a];
                    int xor3 = totalXor ^ xorSubtree[b];
                    minScore = Math.min(minScore, getScore(xor1, xor2, xor3));
                } else if (isDescendant(b, a)) {
                    int xor1 = xorSubtree[b];
                    int xor2 = xorSubtree[a] ^ xorSubtree[b];
                    int xor3 = totalXor ^ xorSubtree[a];
                    minScore = Math.min(minScore, getScore(xor1, xor2, xor3));
                } else {
                    int xor1 = xorSubtree[a];
                    int xor2 = xorSubtree[b];
                    int xor3 = totalXor ^ xorSubtree[a] ^ xorSubtree[b];
                    minScore = Math.min(minScore, getScore(xor1, xor2, xor3));
                }
            }
        }
        return minScore;
    }

    private int dfs(int node, int par, int[] nums) {
        int xor = nums[node];
        parent[node] = par;

        for(int child : tree[node]) {
            if (child != par) {
                xor ^= dfs(child, node, nums);
            }
        }
        xorSubtree[node] = xor;
        return xor;
    }

    private boolean isDescendant(int descendant, int ancestor) {
        while (descendant != -1) {
            if (descendant == ancestor) return true;
            descendant = parent[descendant];
        }
        return false;
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b,c));
        int min = Math.min(a, Math.min(b,c));
        return max - min;
    }
}