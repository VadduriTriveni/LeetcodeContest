public int minFlips(int n) {

    // Step 1: Convert the integer n into its binary representation
    // (without leading zeros)
    String s = Integer.toBinaryString(n);

    // Step 2: Initialize a counter to track the number of flips required
    int flips = 0;

    // Step 3: Get the length of the binary string
    int len = s.length();

    // Step 4: Compare each bit with its corresponding bit in the reversed string
    // Bit at index i should match the bit at index (len - 1 - i)
    for (int i = 0; i < len; i++) {

        // If the bits do not match, one flip is required
        if (s.charAt(i) != s.charAt(len - 1 - i)) {
            flips++;
        }
    }

    // Step 5: Return the minimum number of flips needed
    return flips;
}
