import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SaveLoadAlgo} class provides methods to save and load game data
 * to and from text files. It supports multiple save slots.
 * 
 * @author Andrew Mansur
 */
public class SaveLoadAlgo {
    private static final String SAVE_DIRECTORY = "save.txt"; // Directory to store save files
    private static final int MAX_SLOTS = 5; // Maximum number of save slots

    /**
     * Saves the game data to a specified slot.
     * 
     * @param gameplay The {@code Gameplay} object containing the game data.
     * @param slot The save slot number to save the data to.
     */
    public static void save(Gameplay gameplay, int slot) {
        if (slot < 1 || slot > MAX_SLOTS) {
            System.out.println("Invalid save slot.");
            return;
        }

        File directory = new File(SAVE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir(); // Create the directory if it doesn't exist
        }

        String filePath = SAVE_DIRECTORY + "/save_slot_" + slot + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(gameplay.currentLevel);
            writer.println(gameplay.totalScore);
            for (String word : gameplay.correctWords) {
                writer.println(word);
            }
        } catch (IOException e) {
            System.out.println("Error saving game data: " + e.getMessage());
        }
    }

    /**
     * Loads the game data from a specified save slot.
     * 
     * @param slot The save slot number to load the data from.
     * @return A {@code Gameplay} object containing the loaded game data, or
     *         {@code null} if the slot is invalid or the file does not exist.
     */
    public static Gameplay load(int slot) {
        if (slot < 1 || slot > MAX_SLOTS) {
            System.out.println("Invalid save slot.");
            return null;
        }

        String filePath = SAVE_DIRECTORY + "/save_slot_" + slot + ".txt";
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Save file does not exist.");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Gameplay gameplay = new Gameplay();
            gameplay.currentLevel = Integer.parseInt(reader.readLine());
            gameplay.totalScore = Integer.parseInt(reader.readLine());
            String word;
            while ((word = reader.readLine()) != null) {
                gameplay.correctWords.add(word);
            }
            return gameplay;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading game data: " + e.getMessage());
            return null;
        }
    }
}
