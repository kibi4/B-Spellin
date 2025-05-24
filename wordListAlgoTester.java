// import org.junit.jupiter.api.Test;

// import java.util.List;
// import java.util.Set;

// import static org.junit.jupiter.api.Assertions.*;

// public class wordListAlgoTester {

//     @Test
//     public void testGenerateRandomLetters() {
//         List<Character> letters = wordListAlgo.generateRandomLetters(7, 3);
//         assertNotNull(letters);
//         assertEquals(7, letters.size());

//         int vowelCount = 0;
//         for (char letter : letters) {
//             if (isVowel(letter)) {
//                 vowelCount++;
//             }
//         }
//         assertTrue(vowelCount <= 3);
//     }

//     @Test
//     public void testLoadEnglishWords() {
//         Set<String> englishWords = wordListAlgo.loadEnglishWords();
//         assertNotNull(englishWords);
//         assertFalse(englishWords.isEmpty());
//     }

//     @Test
//     public void testGenerateWordList() {
//         List<Character> letters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g');
//         Set<String> englishWords = Set.of("dog", "cat", "bag", "face");
//         List<String> wordList = wordListAlgo.generateWordList(letters, englishWords, 'a');

//         assertNotNull(wordList);
//         assertFalse(wordList.isEmpty());
//     }

//     @Test
//     public void testIsValidWord() {
//         List<Character> letters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g');
//         char specialLetter = 'a';
//         assertTrue(wordListAlgo.isValidWord("bag", letters, specialLetter));
//         assertFalse(wordListAlgo.isValidWord("cab", letters, specialLetter));
//     }

//     @Test
//     public void testLettersToString() {
//         List<Character> letters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g');
//         String expected = "a, b, c, d, e, f, g";
//         String result = wordListAlgo.lettersToString(letters);
//         assertEquals(expected, result);
//     }

//     private boolean isVowel(char letter) {
//         return "aeiou".indexOf(letter) != -1;
//     }
// }