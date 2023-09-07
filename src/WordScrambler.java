public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) { // wordArr -> even-length array
        scrambledWords = mixedWords(wordArr);
    }

    private String recombine(String word1, String word2) {
        if (word1.contains(" ") || word2.contains(" ")) {
            throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
        }
        String subString1 = word1.substring(0, word1.length()/2);
        String subString2 = word2.substring(word2.length()/2);
        return subString1 + subString2;
    }

    private String[] mixedWords(String[] words) {
        if (words.length % 2 == 1) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        String[] arr = new String[words.length];
        for (int i = 0; i < words.length; i += 2) {
            arr[i] = recombine(words[i], words[i+1]);
            arr[i+1] = recombine(words[i+1], words[i]);
        }
        return arr;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}