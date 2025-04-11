
public class SentenceSearch {
    public static String searchSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "This is the first sentence.",
            "Another line with nothing special.",
            "Here we discuss data structures.",
            "Just a regular sentence."
        };

        String word = "data";
        String result = searchSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}
