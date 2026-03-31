import java.io.*;

public class BufferedStreams {
    static final int CHUNK = 4096;

    static long copyUnbuffered(String src, String dest) throws IOException {
        long start = System.nanoTime();

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);

        byte[] buf = new byte[CHUNK];
        int n;
        while ((n = fis.read(buf)) != -1) {
            fos.write(buf, 0, n);
        }

        fis.close();
        fos.close();
        return System.nanoTime() - start;
    }

    static long copyBuffered(String src, String dest) throws IOException {
        long start = System.nanoTime();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

        byte[] buf = new byte[CHUNK];
        int n;
        while ((n = bis.read(buf)) != -1) {
            bos.write(buf, 0, n);
        }

        bis.close();
        bos.close();
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        String src = "bigfile.bin";
        try {
            long t1 = copyUnbuffered(src, "copy_unbuffered.bin");
            long t2 = copyBuffered(src, "copy_buffered.bin");

            System.out.println("Unbuffered (ms): " + (t1 / 1_000_000));
            System.out.println("Buffered   (ms): " + (t2 / 1_000_000));
        } catch (IOException e) {
            System.out.println("Copy error: " + e.getMessage());
        }
    }
}
