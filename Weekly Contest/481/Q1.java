class Solution {
    public int mirrorDistance(int n) {

        // Step 1: Store the original number
        int original = n;

        // Step 2: Initialize variable to store reversed number
        int reversed = 0;

        // Step 3: Reverse the digits of the number
        while (n > 0) {

            // Step 3.1: Extract the last digit
            int digit = n % 10;

            // Step 3.2: Append digit to reversed number
            reversed = reversed * 10 + digit;

            // Step 3.3: Remove the last digit from n
            n /= 10;
        }

        // Step 4: Compute the mirror distance
        int difference = Math.abs(original - reversed);

        // Step 5: Return the result
        return difference;
    }
}

