import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SaveLoadAlgoTest {
    private Gameplay gameplay;
    private final int testSlot = 1;
    private final String testFilePath = "save.txt/save_slot_" + testSlot + ".txt";

    @BeforeEach
    void setUp() {
        // Set up a test Gameplay object
        gameplay = new Gameplay();
        gameplay.currentLevel = 3;
        gameplay.totalScore = 100;
        gameplay.correctWords = Arrays.asList("word1", "word2", "word3");
    }

    @AfterEach
    void tearDown() {
        // Delete the test save file after each test
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSave() {
        // Test the save method
        SaveLoadAlgo.save(gameplay, testSlot);

        // Check if the file was created
        File file = new File(testFilePath);
        assertTrue(file.exists());
    }

    @Test
    void testLoad() {
        // First, save the test data
        SaveLoadAlgo.save(gameplay, testSlot);

        // Now, load the data
        Gameplay loadedGameplay = SaveLoadAlgo.load(testSlot);

        // Check if the loaded data matches the expected values
        assertNotNull(loadedGameplay);
        assertEquals(gameplay.currentLevel, loadedGameplay.currentLevel);
        assertEquals(gameplay.totalScore, loadedGameplay.totalScore);
        assertArrayEquals(gameplay.correctWords.toArray(), loadedGameplay.correctWords.toArray());
    }
}
