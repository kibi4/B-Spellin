import java.util.List;
import java.util.Set;

public class newGameplayTest extends newGameplay{

    private newGameplay game;

    @Before
    public void setUp() {
        game = new newGameplay();
    }

    @Test
    public void testGenerateLetters() {

        List<Character> letters = game.generateLetters();
        if(!letters.isEmpty()){
            System.out.println("Passed 1");
        }
        else{
            System.out.println("Failed 1");
        }
    }

    @Test
    public void testLoadEnglishWords() {
        Set<String> englishWords = game.loadEnglishWords();
        if(englishWords.isEmpty()){
            System.out.println("Passed 2");
        }else{
            System.out.println("Failed 2");
        }
    }

    @Test
    public void testIsValidWord() {
        List<Character> letters = List.of('a', 'b', 'c', 'd', 'e');
        
        if(game.isValidWord("abc", letters) && game.isValidWord("def", letters)){
            System.out.println("Passed 3");
        }
        else{
            System.out.println("Failed 3");
        };
    }

    @Test
    public void testChooseSpecialLetter() {
        List<Character> letters = List.of('a', 'b', 'c', 'd', 'e');
        char specialLetter = game.chooseSpecialLetter(letters);

        if(letters.contains(specialLetter)){
            System.out.println("Passed 4");
        }
        else{
            System.out.println("Failed 4");
        }
    }

    // Add more test cases to cover other methods as needed

    public static void main(String[] args) {
        newGameplayTest test1 = new newGameplayTest();

        test1.testGenerateLetters();
        test1.testChooseSpecialLetter();
        test1.testIsValidWord();
        test1.testLoadEnglishWords();
    }
}
