import java.util.List;
import java.util.Random;

/**
 *  * @author Andrew Mansur
 * Date: March, 2024
 * Description: Creating a constructor which adds text to a JFrame
 * 
 * The {@code Hint} class provides methods for managing hints in a game.
 * It includes functionality to get a random word from a list and to subtract points when a hint is used.
 */

class Hint {
    private Random random = new Random();

    /**
     * Returns a random word from the given word list.
     * If the word list is empty, it returns a default message indicating that no words are available.
     * 
     * @param wordList the list of words to choose from
     * @return a random word from the list or a default message if the list is empty
     */
    public String getRandomWord(List<String> wordList) {
        if (wordList.isEmpty()) {
            return "No words available";
        }
        return wordList.get(random.nextInt(wordList.size()));
    }

    /**
     * Subtracts a specified number of points from the total score of the gameplay when a hint is used.
     * 
     * @param gameplay the {@code Gameplay} object representing the current game state
     * @param pointsToSubtract the number of points to subtract from the total score
     */
    public void useHint(Gameplay gameplay, int pointsToSubtract) {
        gameplay.totalScore -= pointsToSubtract;
    }
}