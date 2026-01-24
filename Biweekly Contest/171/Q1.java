class Solution {

    public boolean isCompletePrime(int num) {

        // Step 1: Convert the number to string for easy prefix/suffix handling
        String s = String.valueOf(num);
        int len = s.length();

        // Step 2: Check all prefixes
        for (int i = 1; i <= len; i++) {
            int prefix = Integer.parseInt(s.substring(0, i));
            if (!isPrime(prefix)) {
                return false;
            }
        }

        // Step 3: Check all suffixes
        for (int i = 0; i < len; i++) {
            int suffix = Integer.parseInt(s.substring(i));
            if (!isPrime(suffix)) {
                return false;
            }
        }

        // Step 4: If all prefixes and suffixes are prime
        return true;
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int n) {

        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

