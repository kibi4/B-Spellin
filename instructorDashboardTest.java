// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;

// import static org.junit.Assert.*;
// import org.junit.*;

// import java.io.*;
// import java.util.*;

// public class instructorDashboardTest {
// 	//check if file exists
//     private final String testCSV = "highScoreTable.csv";

//     @BeforeClass
//     public static void setup() {
//         // Create a test CSV file
//         try (PrintWriter out = new PrintWriter("highScoreTable.csv")) {
//             out.println("Name,Date,Score,Time");
//             out.println("Kibi Paskaran,2022-01-01,85,10:30");
//             out.println("Paskaran Kibi,2022-01-02,90,9:45");
//         } catch (FileNotFoundException e) {
//             e.printStackTrace();
//         }
//     }

//     @Test
//     public void testPasswordCorrect() {
//         instructorDashboard dashboard = new instructorDashboard(testCSV);
//         assertTrue("Password validated", dashboard.validate("cs2212"));
//     }

//     @Test
//     public void testPasswordIncorrect() {
//         instructorDashboard dashboard = new instructorDashboard(testCSV);
//         assertFalse("Incorrect password validated", dashboard.validate("WRONG"));
//     }

//     @Test
//     public void testGenerateReport() {
//         instructorDashboard dashboard = new instructorDashboard(testCSV);
//         dashboard.validate("cs2212");
//         String report = dashboard.generateReport();

//         assertNull("Report null", report != null);
//         assertTrue("Report contains header", report.contains("Name Date Score Time"));
//         assertTrue("Report contains Kibi Paskarans's score", report.contains("Kibi Paskaran"));
//         assertTrue("Report contains Paskaran Kibi's score", report.contains("Paskaran Kibi"));
//     }

//     @AfterClass
//     public static void cleanup() {
//         // Deletes the test CSV file used
//         new File("highScoreTable.csv").delete();
//     }
// }

