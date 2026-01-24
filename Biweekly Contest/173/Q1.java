class Solution {
    public String reversePrefix(String s, int k) {

        // Step 1: Convert string to character array
        char[] arr = s.toCharArray();

        // Step 2: Initialize two pointers
        int left = 0;
        int right = k - 1;

        // Step 3: Reverse the first k characters
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        // Step 4: Convert back to string and return
        return new String(arr);
    }
}

