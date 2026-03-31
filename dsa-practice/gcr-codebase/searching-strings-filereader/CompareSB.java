import java.util.*;

class CompareSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long start, end;

        StringBuffer sbuf = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) sbuf.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start));

        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) sb.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start));
    }
}
