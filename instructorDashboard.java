//imported java utilities
import java.util.*;
import java.io.*;

/**
 * Represents the instructor's dashboard. Instructors can only enter with a
 * password. Reads the name, date, score, and time from a CSV file, generates a
 * report of these scores, a`nd display this report.
 * 
 * @author Kibi Paskaran
 */

public class instructorDashboard {
	// password needed to enter instructor dashboard
	// Needs to be securely hashed later on
	private static final String PASSWORD = "cs2212";
	// keep track if password is valid
	private boolean validated = false;
	// variable to store csv file
	private String csvFile;

	// get csv file path
	/**
	 * 
	 * @param csvFile the path to the CSV file
	 * 
	 */
	public instructorDashboard(String csvFile) {
		this.csvFile = csvFile;
	}

	// Method to check if password is correct
	/**
	 * Check is the password entered is valid
	 * 
	 * @param password validate.
	 * @return true if the password is correct, false otherwise.
	 */
	public boolean validate(String password) {
		this.validated = PASSWORD.equals(password);
		// returns the result if valid password or not
		return this.validated;
	}

	/**
	 * read csv file and return list of records
	 * 
	 * @return a list of maps of each column in the CSV file
	 */
	private List<Map<String, String>> readCSV() {
		List<Map<String, String>> information = new ArrayList<>();
		// checks if user is validated beforehand
		if (!validated) {
			System.out.println("Access Denied");
			// Returns empty if not authorized
			return information;
		}
		// If user is authorized
		// reads csv file
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			// gets first line because it is the headers
			String rows;
			String[] headers = br.readLine().split(",");
			// iterates through the other lines in the csv file
			while ((rows = br.readLine()) != null) {
				String[] values = rows.split(",");
				Map<String, String> info = new HashMap<>();
				// value for each value mapped to headers
				for (int i = 0; i < headers.length && i < values.length; i++) {
					info.put(headers[i], values[i]);
				}
				information.add(info);
			}
			// if file cannot be read
		} catch (IOException e) {
			System.err.println("Cannot Read CSV File: " + e.getMessage());
		}

		return information;
	}

	// no basic or advanced report just one report displayed
	/**
	 * generates formatted report from the csv file
	 * 
	 * @return string representation of the report
	 */
	public String generateReport() {
		StringBuilder report = new StringBuilder();
		List<Map<String, String>> records = readCSV();

		// lengths to make sure the report is displayed in a straight organized format
		int nameLength = 15;
		int dateLength = 10;
		int scoreLength = 5;
		int timeLength = 5;

		// format for headers and corresponding columns
		String headerFormat = "%-" + nameLength + "s %-" + dateLength + "s %-" + scoreLength + "s %-" + timeLength
				+ "s\n";
		report.append(String.format(headerFormat, "Name", "Date", "Score", "Time"));

		String rowFormat = "%-" + nameLength + "s %-" + dateLength + "s %-" + scoreLength + "d %-" + timeLength + "s\n";
		// goes through each line of the csv file
		for (Map<String, String> record : records) {
			report.append(String.format(rowFormat,
					// gets each item and formats
					record.get("Name"), record.get("Date"), Integer.parseInt(record.get("Score")), record.get("Time")));
		}
		// returns the report as string
		return report.toString();
	}

	// prints the report
	/**
	 * displays generated report to the console
	 * 
	 * @return prints string representation of the report
	 */
	public void displayReport(String report) {
		// check is user is valid
		if (!validated) {
			System.out.println("Access Denied");
		} else {
			// prints out report
			System.out.println(report);
		}
	}

	// main method
	/**
	 * Main Method of the program
	 * 
	 * @param args not used currently, for future use
	 */
	public static void main(String[] args) {
		// gets csv file
		instructorDashboard dashboard = new instructorDashboard("highScoreTable.csv");

		// password to validate check
		if (dashboard.validate("cs2212")) {
			// call to generate and print report
			String report = dashboard.generateReport();
			dashboard.displayReport(report);
		} else {
			System.out.println("Access Denied");
		}
	}

}
