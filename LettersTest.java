import java.util.List;

public class LettersTest extends Letters {

    @Test
    public void testGenerateLetters() {
        Letters letters = new Letters();
        List<Character> generatedLetters = letters.generateLetters();

        if(!generatedLetters.isEmpty()){
            System.out.println("Passed 1");
        }
        else{
            System.out.println("Failed 1");
        }
        if(generatedLetters.size() == 7){
            System.out.println("Passed 1");
        }else{
            System.out.println("failed 1");
        }
    }

    @Test
    public void testRemoveDuplicates() {
        Letters letters = new Letters();
        List<String> wordList = List.of("apple", "banana", "apple", "orange", "banana");
        int originalSize = wordList.size();

        letters.removeDuplicates(wordList);

        if(wordList.size() == 3 && wordList.contains("apple") && wordList.contains("banana") && wordList.contains("orange")){
            System.out.println("Passed 3");
        }
        else{
            System.out.println("Failed 3");
        }
    }

    private void isVowel(char letter) {
        if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
            System.out.println("Passed 4");
        }
        else{
            System.out.println("Failed 3");
        }
    }

    public static void main(String[] args) {
        LettersTest test1 = new LettersTest();
        test1.testGenerateLetters();
        //test1.removeDuplicates(null);
    }

}
