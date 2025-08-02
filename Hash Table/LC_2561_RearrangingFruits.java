class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        // Topic : Array, HashTable, Greedy, Sort
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : basket1) freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (int num : basket2) freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (int count : freq.values()) {
            if (count % 2 != 0) return -1;
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : basket1) map1.put(num, map1.getOrDefault(num, 0) + 1);
        for (int num : basket2) map2.put(num, map2.getOrDefault(num, 0) + 1);

        List<Integer> extra1 = new ArrayList<>();
        List<Integer> extra2 = new ArrayList<>();

        for (int key : freq.keySet()) {
            int diff = map1.getOrDefault(key, 0) - map2.getOrDefault(key, 0);
            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) extra1.add(key);
            } else if (diff < 0) {
                for (int i = 0; i < -diff / 2; i++) extra2.add(key);
            }
        }

        Collections.sort(extra1);
        extra2.sort(Collections.reverseOrder());

        int minVal = Integer.MAX_VALUE;
        for (int key : freq.keySet()) {
            minVal = Math.min(minVal, key);
        }

        long cost = 0;
        for (int i = 0; i < extra1.size(); i++) {
            int x = extra1.get(i);
            int y = extra2.get(i);
            cost += Math.min(Math.min(x, y), 2 * minVal);
        }

        return cost;
    }
}