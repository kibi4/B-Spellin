import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {
    @Test
    void testGetRandomWord() {
        Hint hint = new Hint();
        List<String> wordList = Arrays.asList("apple", "banana", "cherry");
        String randomWord = hint.getRandomWord(wordList);

        // Check if the random word is in the list
        assertTrue(wordList.contains(randomWord));

        // Test with an empty list
        String message = hint.getRandomWord(Collections.emptyList());
        assertEquals("No words available", message);
    }

    @Test
    void testUseHint() {
        Hint hint = new Hint();
        Gameplay gameplay = new Gameplay();
        gameplay.totalScore = 100;

        int pointsToSubtract = 10;
        hint.useHint(gameplay, pointsToSubtract);

        // Check if the points were subtracted correctly
        assertEquals(90, gameplay.totalScore);
    }
}
