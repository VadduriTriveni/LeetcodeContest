class Solution {

    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;

        // Step 1: Loop through the range
        for (int n = num1; n <= num2; n++) {

            String s = String.valueOf(n);
            int len = s.length();

            // Step 2: Skip numbers with fewer than 3 digits
            if (len < 3) continue;

            // Step 3: Check each middle digit
            for (int i = 1; i < len - 1; i++) {
                int prev = s.charAt(i - 1) - '0';
                int curr = s.charAt(i) - '0';
                int next = s.charAt(i + 1) - '0';

                // Peak or Valley check
                if ((curr > prev && curr > next) ||
                    (curr < prev && curr < next)) {
                    totalWaviness++;
                }
            }
        }

        return totalWaviness;
    }
}
