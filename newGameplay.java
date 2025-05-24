import java.util.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * The newGameplay class represents a game session where players can guess words
 * based on a set of randomly generated letters. The game consists of three levels,
 * each with its own scoring system. Players have a time limit to guess words and
 * earn points.
 */
public class newGameplay extends Letters{

    /** The total score accumulated throughout the game session. */
    public int totalScore;

    /** The list of correctly guessed words. */
    public List<String> correctWords;

    /** Indicates whether the timer has finished. */
    public boolean timerFinished = false;

    /** The current level of the game session. */
    public int currentLevel;

    /** A Random object for generating letters. */
    public final Random random = new Random();

    /** The Letters object for generating letters. */
    public Letters letterGenerator;

    /**
     * Constructs a newGameplay object.
     * Initializes totalScore, correctWords, currentLevel, and letterGenerator.
     */
    public newGameplay() {
        this.totalScore = 0;
        this.correctWords = new ArrayList<>();
        this.currentLevel = 1; // Start from level 1
        this.letterGenerator = new Letters();
    }

    /**
     * Starts a timer for 1 minute and 30 seconds.
     */
    public void startTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1 Minute 30 Seconds Timer Finished!");
                timerFinished = true;
                timer.cancel();
            }
        }, 30000); // 1 minute and 30 seconds in milliseconds
    }

    /**
     * Checks if the timer has finished.
     * 
     * @return true if the timer has finished, false otherwise.
     */
    public boolean timerIsFinished() {
        return timerFinished;
    }

    /**
     * Starts the game session.
     * Plays levels until the current level reaches 3 or the timer is finished.
     * Prints the final score when the game is finished.
     */
    public void play() {
        while (currentLevel <= 3 && !timerIsFinished()) {
            System.out.println("Starting Game: Level " + currentLevel);
            startTimer();
            switch (currentLevel) {
                case 1:
                    levelOne();
                    break;
                case 2:
                    levelTwo();
                    break;
                case 3:
                    levelThree();
                    break;
                default:
                    break;
            }
            System.out.println("Level " + currentLevel + " Done");
            currentLevel++;
            timerFinished = false;
            correctWords.clear();
        }

        System.out.println("Score: " + totalScore);
        System.out.println("Game Finished");
    }

    /**
     * Plays level one of the game.
     * Each correct guess earns 1 point.
     */
    public void levelOne() {
        playLevel(1); // 1 point for each correct guess in level 1
    }

    /**
     * Plays level two of the game.
     * Each correct guess earns 1.5 points.
     */
    public void levelTwo() {
        playLevel(1.5); // 1.5 points for each correct guess in level 2
    }

    /**
     * Plays level three of the game.
     * Each correct guess earns 2 points.
     */
    public void levelThree() {
        playLevel(2); // 2 points for each correct guess in level 3
    }

    /**
     * Plays a specific level of the game.
     * 
     * @param pointsMultiplier The multiplier for points earned in this level.
     */
    public void playLevel(double pointsMultiplier) {
        List<String> wordList = new ArrayList<>(); // Word list for the level

        while (wordList.size() < 10 && !timerIsFinished()) {
            // Generate letters for the level
            List<Character> letters = letterGenerator.generateLetters();

            // Choose a special letter
            char specialLetter = chooseSpecialLetter(letters);

            // Generate word list based on the selected letters and special letter
            wordList = generateWordList(letters, specialLetter);

            // If timer finished, exit loop
            if (timerIsFinished()) {
                break;
            }

            // Display generated letters, special letter, and word list
            System.out.println("Letters: " + lettersToString(letters));
            System.out.println("Special Letter: " + specialLetter);
            System.out.println("Word List: " + wordList);

            Scanner scanner = new Scanner(System.in);
            while (!timerIsFinished()) {
                System.out.println("Enter word: ");
                String userWord = scanner.nextLine();
                if (isCorrect(userWord, wordList)) {
                    correctWords.add(userWord);
                    System.out.println("Correct!!");
                } else {
                    System.out.println("Incorrect... Try Again");
                }
            }
        }

        // Calculate points for the level based on level criteria
        removeDuplicates(correctWords);
        int points = (int) (correctWords.size() * pointsMultiplier); // Points for each correct guess

        // Update total score
        totalScore += points;
        System.out.println("Points earned in Level " + currentLevel + ": " + points);
    }

    /**
     * Checks if the input word from user is equal to any word in the wordlist.
     * 
     * @param usrWord The word input by the user.
     * @param wordList The list of valid words for the level.
     * @return true if the input word is correct, false otherwise.
     */
    public boolean isCorrect(String usrWord, List<String> wordList) {
        return wordList.contains(usrWord);
    }

    /**
     * Converts a list of letters to a string separated by commas.
     * 
     * @param letters The list of letters to convert.
     * @return The string representation of the letters.
     */
    public String lettersToString(List<Character> letters) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.size(); i++) {
            sb.append(letters.get(i));
            if (i < letters.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Generates a word list based on the selected letters and a special letter.
     * 
     * @param letters The list of selected letters.
     * @param specialLetter The special letter for the level.
     * @return The list of valid words for the level.
     */
    public List<String> generateWordList(List<Character> letters, char specialLetter) {
        Set<String> englishWords = loadEnglishWords();
        List<String> wordList = new ArrayList<>();
        for (String word : englishWords) {
            if (isValidWord(word, letters) && word.contains(String.valueOf(specialLetter))) {
                wordList.add(word);
            }
        }
        return wordList;
    }

    /**
     * Checks if a word is valid based on the selected letters.
     * 
     * @param word The word to check.
     * @param letters The list of selected letters.
     * @return true if the word is valid, false otherwise.
     */
    public boolean isValidWord(String word, List<Character> letters) {
        final int MIN_WORD_LENGTH = 4; // Minimum length of words to be considered
        if (word.length() < MIN_WORD_LENGTH) {
            return false;
        }

        Set<Character> letterSet = new HashSet<>(letters);
        for (char c : word.toCharArray()) {
            if (!letterSet.contains(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Chooses a special letter from the generated letters.
     * 
     * @param letters The list of generated letters.
     * @return The special letter chosen.
     */
    public char chooseSpecialLetter(List<Character> letters) {
        return letters.get(random.nextInt(letters.size()));
    }

    /**
     * Loads English words from a file.
     * 
     * @return A set of English words.
     */
    public Set<String> loadEnglishWords() {
        Set<String> englishWords = new HashSet<>();
        try (Scanner scanner = new Scanner(new FileReader("words.txt"))) {
            while (scanner.hasNextLine()) {
                englishWords.add(scanner.nextLine().trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return englishWords;
    }

    public List<Character> generateLetters() {
        char[] VOWELS = {'a','e','i','o','u'};
        char[] CONSTS = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};

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
    
    /**
     * The main method to test the functionality of newGameplay.
     * 
     * @param args The command-line arguments.
     */

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        newGameplay gameplay = new newGameplay();
        gameplay.play();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

        System.out.println("Time taken: " + duration + " milliseconds");
    }
}