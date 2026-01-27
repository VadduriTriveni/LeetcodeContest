class Solution {

    public int[] minOperations(int[] nums) {
      // Step 1: Create result array
        int[] ans = new int[nums.length];

        // Step 2: Process each number
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Step 3: Already palindrome
            if (isBinaryPalindrome(num)) {
                ans[i] = 0;
                continue;
            }

            int downCost = Integer.MAX_VALUE;
            int upCost = Integer.MAX_VALUE;

            // Step 4: Search downward
            for (int down = num - 1; down >= 1; down--) {
                if (isBinaryPalindrome(down)) {
                    downCost = num - down;
                    break;
                }
            }

            // Step 5: Search upward
            for (int up = num + 1; ; up++) {
                if (isBinaryPalindrome(up)) {
                    upCost = up - num;
                    break;
                }
            }

            // Step 6: Choose minimum
            ans[i] = Math.min(downCost, upCost);
        }

        return ans;
    }

    // Helper: check binary palindrome
    private boolean isBinaryPalindrome(int num) {
        String binary = Integer.toBinaryString(num);
        int left = 0, right = binary.length() - 1;

        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
