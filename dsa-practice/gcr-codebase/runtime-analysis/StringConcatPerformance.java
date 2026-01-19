public class StringConcatPerformance {

    // String Concatenation O(N²)
    static String concatString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a"; 
        }
        return result;
    }

    // StringBuilder Concatenation O(N)
    static String concatStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return sb.toString();
    }

    // StringBuffer Concatenation O(N)
    static String concatStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 1_000_000; 

        long start = System.currentTimeMillis();
        concatString(n); 
        System.out.println("String Concatenation Time: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        concatStringBuilder(n);
        System.out.println("StringBuilder Concatenation Time: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        concatStringBuffer(n);
        System.out.println("StringBuffer Concatenation Time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
