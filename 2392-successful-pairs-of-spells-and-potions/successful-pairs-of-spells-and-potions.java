class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        ArrayList<Integer> nums = new ArrayList<>();
        int index = potions.length;
        for (int i = 0; i < spells.length; i++) {
            int l2 = 0;
            int r2 = potions.length - 1;
            index = potions.length;
            while (l2 <= r2) {
                int mid2 = l2 + (r2 - l2) / 2;
                if ((long)spells[i] * potions[mid2] >= success) {
                    r2 = mid2 - 1;
                    index = mid2;
                } else {
                    l2 = mid2 + 1;
                }
            }
            int count = potions.length - index;
            nums.add(count);
        }
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        return arr;
    }
}