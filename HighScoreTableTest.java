import java.io.IOException;

public class HighScoreTableTest extends HighScoreTable {

    private HighScoreTable highScoreTable;

    @Before
    public void setUp() {
        highScoreTable = new HighScoreTable();
    }

    @Test
    public void testAddToCSV() {
        // Test adding a score to CSV file
        String name = "TestPlayer";
        String score = "100";
        String date = "2024-04-01";
        String filename = "testScores.csv";
        String time  = "18:45";

        HighScoreTable.addToCSV(name, score, date, time, filename);
        
    }

    @Test
    public void testPrintTopScores() {
        // Test printing top scores from CSV file
        String filename = "testScores.csv";

        // Print top scores
        HighScoreTable.printTopScores(filename);

        // No need to assert, as this method only prints to console
    }

 

    public static void main(String[] args) {
        HighScoreTableTest test1 = new HighScoreTableTest();

        test1.testAddToCSV();
    }
}

