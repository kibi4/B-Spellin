/**
 * The gamePlayGUI class provides a graphical user interface for a spelling game,
 * displaying a field and button. It includes functionality to login to the high score
 * list for the instructor.
 * 
 * @author Mridul
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class instructorDashboardLoginGUI {

	JFrame frame;
	private JPanel drawingPanel;
	private int width, height;
	private JPasswordField passwordField;
	private TextPicture logo, logo2;
	private ImagePicture background;
	private instructorDashboard iBoard;

	/**
	 * Launch the application.
	 * @param
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructorDashboardLoginGUI window = new instructorDashboardLoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public instructorDashboardLoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		width = 1000;
		height = 700;
		
		iBoard = new instructorDashboard("words.txt");
		// initializing the frame, panel, background and labels
		frame = new JFrame("Bee Spellin");
		drawingPanel = new JPanel();
		
		background = new ImagePicture(new ImageIcon("insBack.png"));
		background.setBounds(0, 0, 1000, 700);
		
		logo = new TextPicture(20);
		logo.setTitle("Password (Instructor Only)");
		logo.setF(new Font("Stencil", Font.PLAIN, 50));
		logo.setyPos(100);
		logo.setColor(new Color(153, 0, 0));
		logo.setBounds(90, 163, 810, 200);
		
		logo2 = new TextPicture(20);
		logo2.setTitle("Instructor Dash");
		logo2.setF(new Font("Stencil", Font.PLAIN, 50));
		logo2.setyPos(100);
		logo2.setColor(new Color(255, 165, 0));
		logo2.setBounds(512, 49, 460, 200);
		
		// adding them to the panel and repaints
		drawingPanel.add(logo);
		drawingPanel.add(logo2);
		frame.repaint();
		frame.repaint();
		
		// setting bounds
		drawingPanel.setBounds(0, 0, width, height);
		drawingPanel.setLayout(null);
		
		// initializing the password field
		passwordField = new JPasswordField();
		passwordField.setLocation(96, 284);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		drawingPanel.add(passwordField);
		
		// setting upb the login button to check and login is the password is correct
		JButton btnLog = new JButton("LogIn");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iBoard.validate(passwordField.getText())) {
					frame.setVisible(false);
					// launches the highscore list
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								insDashGUI window = new insDashGUI();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				// else says its the wrong password
				else {
					JOptionPane.showMessageDialog(null, "Wrong Answer!!\nPlease Try again");
				}
			}
		});
		btnLog.setForeground(new Color(255, 255, 240));
		btnLog.setBackground(new Color(128, 0, 0));
		btnLog.setFont(new Font("ROG Fonts", Font.PLAIN, 30));
		btnLog.setBounds(336, 436, 327, 95);
		drawingPanel.add(btnLog);
		
		// btn to go back
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBackground(new Color(255, 165, 0));
		btnBack.setFont(new Font("ROG Fonts", Font.PLAIN, 15));
		btnBack.setBounds(883, 600, 89, 63);
		drawingPanel.add(btnBack);
		
		// setting the group layout to easily move stuff
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
					.addGap(89))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(284)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
					.addGap(284))
		);
		// adding the background to the panel
		drawingPanel.add(background);
		// adding the layout to frame and setting bounds
		frame.getContentPane().setLayout(groupLayout);
		frame.getContentPane().add(drawingPanel);
		
		frame.setBounds(150, 30, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
