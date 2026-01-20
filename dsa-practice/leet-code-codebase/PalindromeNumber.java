class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int rev = 0, temp = x;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return x == rev;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}