class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int maxLen = 0;

        for (int n : set) {

            // only start counting if "n" is the start of a sequence
            if (!set.contains(n - 1)) {

                int curr = n;
                int streak = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }

                maxLen = Math.max(maxLen, streak);
            }
        }

        return maxLen;
    }
}
