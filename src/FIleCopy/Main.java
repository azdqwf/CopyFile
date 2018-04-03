package FIleCopy;
import java.io.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private final static int SIZE = 1_000_000;

    public static void main(String[] args) {

        String filePath1 = "C:\\file1.txt";
        String filePath2 = "C:\\file2.txt";
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        long startTime = System.currentTimeMillis();
        try (InputStream fis = new FileInputStream(file1); OutputStream fous = new FileOutputStream(file2)) {
            byte[] buffer = new byte[SIZE];

            int count;

            for (int i = 0; i < file1.length(); i += SIZE) {
                count = fis.readNBytes(buffer, 0, SIZE);
                fous.write(buffer, 0, count);
            }
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println(totalTime);
        } catch (IOException e) {

            logger.warning(e.toString());
        }

    }
}
