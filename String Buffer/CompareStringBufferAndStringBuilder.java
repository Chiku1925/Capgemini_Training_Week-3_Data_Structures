
public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        int numStrings = 1000000;
        String testString = "hello";
        
        // Measure time for StringBuffer
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numStrings; i++) {
            stringBuffer.append(testString);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        
        // Measure time for StringBuilder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numStrings; i++) {
            stringBuilder.append(testString);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        
        // Output the times taken
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");
    }
}
