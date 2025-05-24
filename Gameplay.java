import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gameplay {

    public int totalScore;
    public List<String> correctWords;
    public boolean timerFinished = false;
    public int currentLevel;
    public final Random random = new Random(); // Random object for generating letters

    // Constructor
    public Gameplay() {
        this.totalScore = 0;
        this.correctWords = new ArrayList<>();
        this.currentLevel = 1; // Start from level 1
    }

    // Function to calculate points based on word length
    public int calculatePoints(List<String> correctWords, int wordLength) {
        int points = 0;
        for (String word : correctWords) {
            if (word.length() == wordLength) {
                points += wordLength - 3; // Adjust points based on word length
            }
        }
        return points;
    }

    // Starts timer for 1 minute
    public void startTimer1Minute() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1 Minute Timer Finished!");
                timerFinished = true;
                timer.cancel();
            }
        }, 60000); // 1 minute in milliseconds
    }

    // Checks if the timer is finished
    public boolean timerIsFinished() {
        return timerFinished;
    }

    public void Level1(){
        int minLetters = 3;
        // Generate letters for the level
        List<Character> letters = generateLetters(minLetters);

        // Choose a special letter
        char specialLetter = chooseSpecialLetter(letters);

        // Generate word list based on the selected letters and special letter
        List<String> wordList = generateWordList(letters, specialLetter);

        System.out.println("Letters: " + lettersToString(letters));
        System.out.println("Special Letter: " + specialLetter);
        System.out.println("Word List: " + wordList);
        
        //number of points 
        //int points = 0;

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

        int points = calculatePoints(correctWords, minLetters);
        // Remove duplicates from correctWords
        removeDuplicates(correctWords);


        // Update total score
        totalScore += points;
        System.out.println("Points earned in Level 1: " + totalScore);
    }

    public void Level2(){
        int minLetters = 1 + 3;
        // Generate letters for the level
        List<Character> letters = generateLetters(minLetters);

        // Choose a special letter
        char specialLetter = chooseSpecialLetter(letters);

        // Generate word list based on the selected letters and special letter
        List<String> wordList = generateWordList(letters, specialLetter);

        System.out.println("Letters: " + lettersToString(letters));
        System.out.println("Special Letter: " + specialLetter);
        System.out.println("Word List: " + wordList);
        
        //number of points 
        int points = 0;

        Scanner scanner = new Scanner(System.in);
        while (!timerIsFinished()) {
            System.out.println("Enter word: ");
            String userWord = scanner.nextLine();
            if (isCorrect(userWord, wordList)) {
                correctWords.add(userWord);
                points = calculatePoints(correctWords, minLetters);
                System.out.println("Correct!!");
            } else {
                System.out.println("Incorrect... Try Again");
            }
        }

        // Remove duplicates from correctWords
        removeDuplicates(correctWords);


        // Update total score
        totalScore += points;
        System.out.println("Points earned in Level 2: " + points);
    }

    public void Level3(){
        int minLetters = 2 + 3;
        // Generate letters for the level
        List<Character> letters = generateLetters(minLetters);

        // Choose a special letter
        char specialLetter = chooseSpecialLetter(letters);

        // Generate word list based on the selected letters and special letter
        List<String> wordList = generateWordList(letters, specialLetter);

        System.out.println("Letters: " + lettersToString(letters));
        System.out.println("Special Letter: " + specialLetter);
        System.out.println("Word List: " + wordList);
        
        //number of points 
        //int points = 0;

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
        int points = calculatePoints(correctWords, minLetters);
        // Remove duplicates from correctWords
        removeDuplicates(correctWords);


        // Update total score
        totalScore += points;
        System.out.println("Points earned in Level 3: " + points);
    }
    public void play(){
        System.out.println("Starting Game: Level 1");

        startTimer1Minute();
        while(!timerIsFinished()){
            Level1();
        }

        System.out.println("Level 1 Done, Next Game");

        System.out.println("Starting Game: Level 2");
        timerFinished = false;
        startTimer1Minute();
        while(!timerIsFinished()){
            Level2();
        }
 
        System.out.println("Level 2 Done, Next Game");

        System.out.println("Starting Game: Level 3");
        timerFinished = false;
        startTimer1Minute();
        while(!timerIsFinished()){
            Level3();
        }

        System.out.println("Score: " + totalScore);

        System.out.println("Game Finished");
    }


    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Gameplay gameplay = new Gameplay();
        gameplay.play();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

        System.out.println("Time taken: " + duration + " milliseconds");
    }

    // Checks if the input word from user is equal to the wordlist
    public boolean isCorrect(String usrWord, List<String> wordList) {
        for (String word : wordList) {
            // Check if usrWord is equal to the current word in the list
            if (usrWord.equals(word)) {
                return true; // Return true if usrWord is equal to any word in the list
            }
        }
        return false;
    }

    // Checks if there are duplicates in correctWord List, and removes them
    public void removeDuplicates(List<String> list) {
        Set<String> uniqueWords = new HashSet<>(list); // Convert list to set to remove duplicates
        list.clear(); // Clear the original list
        list.addAll(uniqueWords);
    }

    // Convert list of letters to a string separated by commas
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

    // Load English words from file
    public Set<String> loadEnglishWords() {
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

    // Generate word list based on the selected letters
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

    // Check if the word is valid based on the selected letters
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

    // Choose a special letter from the generated letters
    public char chooseSpecialLetter(List<Character> letters) {
        return letters.get(random.nextInt(letters.size()));
    }

    // Generate letters for the level
    public List<Character> generateLetters(int level) {
        List<Character> letters = new ArrayList<>();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int minLetters = level + 3; // Adjust minimum letters based on level

        // For levels 1 and 2, require a minimum of 4 letters, for level 3 require a minimum of 5 letters
        int minVowels = minLetters / 2; // Maximum of half the number of letters should be vowels
        int vowelsCount = 0;

        while (letters.size() < minLetters) {
            char randomLetter = (char) ('a' + random.nextInt(26));
            if (!letters.contains(randomLetter)) {
                if (vowels.contains(randomLetter)) {
                    if (vowelsCount < minVowels) {
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
}