import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) throws Exception {
        int repetitions = 1000000;
        String text = "hello";

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < repetitions; i++) {
            sbuf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        FileReader fr = new FileReader("largefile.txt");
        BufferedReader br = new BufferedReader(fr);
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        br.close();
        endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount);
        System.out.println("FileReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("largefile.txt"), "UTF-8");
        BufferedReader br2 = new BufferedReader(isr);
        wordCount = 0;
        while ((line = br2.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        br2.close();
        endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount);
        System.out.println("InputStreamReader time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
