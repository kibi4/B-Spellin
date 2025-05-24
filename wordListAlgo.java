import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class generates a list of words based on randomly chosen letters and a special letter.
 * The words are selected from an English word list file, ensuring they meet certain criteria.
 * The class also provides utility methods for generating random letters, loading English words,
 * checking the validity of a word based on the selected letters, and converting letters to a string.
 * <p>
 * The main method generates a word list with a minimum of 10 words using random letters and a special letter.
 * It then prints out the chosen letters, special letter, and generated word list.
 * </p>
 * <p>
 * @author fmahmo3
 * </p>
 */
public class wordListAlgo {
    /**
     * The minimum length of words to be considered valid.
     */
    public static final int MIN_WORD_LENGTH = 4;
    /**
     * Random object for generating random values.
     */
    public static final Random random = new Random();

    /**
     * The main method generates a list of words based on randomly chosen letters and a special letter.
     * It ensures that the word list contains at least 10 words.
     * It then prints out the chosen letters, special letter, and generated word list.
     *
     * @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        char specialLetter = ' ';
        List<Character> letters = new ArrayList<>();

        while (wordList.size() < 10) {
            letters = generateRandomLetters(7, 3);
            specialLetter = letters.get(random.nextInt(letters.size()));
            Set<String> englishWords = loadEnglishWords();
            wordList = generateWordList(letters, englishWords, specialLetter);
        }

        System.out.println("Letters Chosen: " + lettersToString(letters));
        System.out.println("Special Letter: " + specialLetter);
        System.out.println("Generated Word List:");
        for (String word : wordList) {
            System.out.println(word);
        }
    }

    /**
     * Generates a list of random letters with a specified count and maximum number of vowels.
     *
     * @param count     The number of letters to generate.
     * @param maxVowels The maximum number of vowels allowed in the generated letters.
     * @return A list of randomly generated letters.
     */
    public static List<Character> generateRandomLetters(int count, int maxVowels) {
        List<Character> letters = new ArrayList<>();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int vowelsCount = 0;
        while (letters.size() < count) {
            char randomLetter = (char) ('a' + random.nextInt(26));
            if (!letters.contains(randomLetter)) {
                if (vowels.contains(randomLetter)) {
                    if (vowelsCount < maxVowels) {
                        letters.add(randomLetter);
                        vowelsCount++;
                    }
                } else {
                    letters.add(randomLetter);
                }
            }
        }
        return letters;
    }

    /**
     * Loads English words from a file and stores them in a set.
     *
     * @return A set containing English words loaded from the file.
     */
    public static Set<String> loadEnglishWords() {
        Set<String> englishWords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                englishWords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return englishWords;
    }

    /**
     * Generates a word list based on the selected letters, English words, and a special letter.
     *
     * @param letters       The list of selected letters.
     * @param englishWords  The set of English words.
     * @param specialLetter The special letter.
     * @return A list of words generated based on the criteria.
     */
    public static List<String> generateWordList(List<Character> letters, Set<String> englishWords, char specialLetter) {
        List<String> wordList = new ArrayList<>();
        for (String word : englishWords) {
            if (isValidWord(word, letters, specialLetter)) {
                wordList.add(word);
            }
        }
        return wordList;
    }

    /**
     * Checks if a word is valid based on the selected letters and special letter.
     *
     * @param word          The word to check.
     * @param letters       The list of selected letters.
     * @param specialLetter The special letter.
     * @return True if the word is valid, false otherwise.
     */
    public static boolean isValidWord(String word, List<Character> letters, char specialLetter) {
        if (word.length() < MIN_WORD_LENGTH) {
            return false;
        }
        Set<Character> letterSet = new HashSet<>(letters);
        if (!letterSet.contains(specialLetter)) {
            return false;
        }
        for (char c : word.toCharArray()) {
            if (!letterSet.contains(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts a list of letters to a string representation.
     *
     * @param letters The list of letters to convert.
     * @return A string representation of the letters.
     */
    public static String lettersToString(List<Character> letters) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.size(); i++) {
            sb.append(letters.get(i));
            if (i < letters.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}