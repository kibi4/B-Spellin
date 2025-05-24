import java.util.*;

/**
 * The Letters class generates a list of unique letters containing 3 random vowels
 * and 4 random consonants.
 */
public class Letters {
    private final char[] VOWELS = {'a','e','i','o','u'};
    private final char[] CONSTS = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};

    /**
     * Generates a list of unique letters containing 3 random vowels and 4 random consonants.
     *
     * @return List of unique letters.
     */
    public List<Character> generateLetters() {
        Random rand = new Random();
        Set<Character> uniqueLetters = new LinkedHashSet<>(); // Using LinkedHashSet to maintain order and prevent duplicates

        // Add 3 random vowels
        while (uniqueLetters.size() < 3) {
            uniqueLetters.add(VOWELS[rand.nextInt(VOWELS.length)]);
        }

        // Add 4 random consonants
        while (uniqueLetters.size() < 7) {
            uniqueLetters.add(CONSTS[rand.nextInt(CONSTS.length)]);
        }

        return new ArrayList<>(uniqueLetters); // Convert Set to List to return
    }

    public void removeDuplicates(List<String> list) {
        Set<String> uniqueWords = new HashSet<>(list); // Convert list to set to remove duplicates
        list.clear(); // Clear the original list
        list.addAll(uniqueWords);
    }
}