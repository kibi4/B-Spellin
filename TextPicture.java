import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Mridul
 * Date: March, 2022
 * Description: Creating a constructor which adds text to a JFrame
 *
 */
public class TextPicture extends Picture {
	
	// private variables for the title and font
	private String title;
	private Font f;
	private int fSize;
	
	// setter for the title
	public void setTitle(String title) {
		this.title = title;
	}
	
	// setter for the font
	public void setF(Font f) {
		this.f = f;
	}
	/**
	 * to set the font size
	 */
	public void setfSize(int fSize) {
		this.fSize = fSize;
	}

	/**
	 * Constructor to initialize the private variables
	 */
	public TextPicture(int fSize) {
		super();
		this.title = "I am Watching you ;o)";
		this.f = new Font("Algerian", Font.BOLD | Font.ITALIC, fSize);
	}

	/**
	 * Method to overwrite the paint method to make it into a text
	 */
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.setFont(this.f);
		g.drawString(this.title, this.getxPos(), this.getyPos());
	}
	public static void main(String[] args) {
		// creating a JFrame
		JFrame f = new JFrame("Tester");
		// getting the text
		TextPicture p = new TextPicture(25);
		
		// arranging the JFrame and text
		p.setxPos(100);
		p.setyPos(100);
		p.setColor(Color.BLUE);
		f.setSize(1000, 500);
		f.add(p);
		f.setVisible(true);
		
		// wait command
		JOptionPane.showMessageDialog(null, "Wait to change colour and position");
		// arranging the text
		p.setColor(Color.PINK);
		p.setxPos(50);
		p.setyPos(200);
		f.repaint();
		
		// wait command
		JOptionPane.showMessageDialog(null, "Wait to change colour and Add another object");
		// adding another text and arranging
		TextPicture p1 = new TextPicture(25);
		p1.setTitle("Mridul doesn't listen");
		p1.setxPos(200);
		p1.setyPos(300);
		p1.setColor(Color.DARK_GRAY);
		f.add(p1);
		f.setVisible(true);
	}

}
