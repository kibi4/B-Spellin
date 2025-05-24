import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * HighScoreTable class represents a table to store and manage high scores.
 * It extends Gameplay class.
 */
public class HighScoreTable extends Gameplay {

    private static String name;
    private static String date;
    private static String finalScore;
    private List<String[]> csvList;

    /**
     * Constructs a HighScoreTable object.
     */
    public HighScoreTable() {
        this.name = null;
        this.date = null;

        Gameplay obj = new Gameplay();
        this.finalScore = Integer.toString(obj.totalScore);
        this.csvList = new ArrayList<>();
    }

    /**
     * Prompts the user to enter their name.
     * 
     * @return The name entered by the user.
     */
    public String getName() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String value = scnr.nextLine();

        this.name = value;
        return name;
    }

    /**
     * Prompts the user to enter the date.
     * 
     * @return The date entered by the user.
     */
    public String getDate() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Date: ");
        String value = scnr.nextLine();

        this.date = value;
        return date;
    }

    /**
     * Converts an integer value to string.
     * 
     * @param value The integer value to convert.
     * @return The string representation of the integer value.
     */
    public String convertIntToString(int value) {
        String score = Integer.toString(value);
        this.finalScore = score;
        return finalScore;
    }

    /**
     * Adds score data to a CSV file.
     * 
     * @param name     The name of the player.
     * @param score    The score achieved by the player.
     * @param date     The date when the score was achieved.
     * @param filename The name of the CSV file.
     */
    public static void addToCSV(String name, String score, String date, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, Files.exists(Paths.get(filename))))) {
            if (!Files.exists(Paths.get(filename))) {
                // If the file doesn't exist, write header
                writer.append("Name,Score,Date");
            }
            writer.append(String.format("%s,%s,%s\n", name, score, date));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the top scores from a CSV file.
     * 
     * @param csvFile The CSV file containing the scores.
     */
    public static void printTopScores(String csvFile) {
        List<String[]> scores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] scoreData = line.split(",");
                scores.add(scoreData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort scores based on score in descending order
        Collections.sort(scores, new Comparator<String[]>() {
            @Override
            public int compare(String[] score1, String[] score2) {
                return Integer.compare(Integer.parseInt(score2[1]), Integer.parseInt(score1[1]));
            }
        });

        // Print top 5 scores
        System.out.println("Top 5 Scores:");
        int count = Math.min(5, scores.size());
        for (int i = 0; i < count; i++) {
            String[] score = scores.get(i);
            System.out.println((i + 1) + ". Name: " + score[0] + ", Score: " + score[1] + ", Date: " + score[2]);
        }
    }

    /**
     * The main method to test the functionality of HighScoreTable.
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        HighScoreTable test0 = new HighScoreTable();
        String filename = "highScoreTable.csv";
        test0.printTopScores(filename);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;

        System.out.println("Time taken: " + duration + " milliseconds");
    }

}