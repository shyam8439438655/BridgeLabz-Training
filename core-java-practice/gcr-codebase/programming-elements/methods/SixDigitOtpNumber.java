import java.util.Scanner;

class OTPUtility {

    //  6-digit OTP generate karne ka method
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    //  Check karo ki OTP unique hain ya nahi
    // Agar sab unique → return true
    // Agar ek bhi same → return false
    public static boolean isUnique(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    return false;  // Unique nahi hai
                }
            }
        }
        return true; // Sab OTP unique hain
    }
}

public class SixDigitOtpNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Kitne OTP generate karne hain? : ");
        int n = sc.nextInt();

        int[] otpArray = new int[n];

        System.out.println("\nGenerated OTPs:");
        for (int i = 0; i < n; i++) {
            otpArray[i] = OTPUtility.generateOTP();
            System.out.println(otpArray[i]);
        }

        // Yaha sirf true ya false aayega
        boolean result = OTPUtility.isUnique(otpArray);

        System.out.println("\nUnique OTPs? : " + result);
        sc.close();
    }
}
