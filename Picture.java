import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Mridul
 * Date: March, 2022
 * Description: Draws a picture on a JFrame
 * 				Inherits from JComponent
 *
 */
public class Picture extends JComponent{

	public Color getColor() {
		return color;
	}

	// private data for picture
	private Color color;
	private int xPos, yPos, myWidth, myHeight;
	
	/**
	 * Default constructor
	 */
	public Picture() {
		// initialize my data
		this.color = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myWidth = 50;
		this.myHeight = 25;
	}
	
	/**
	 * Overloaded constructor
	 * @param color
	 */
	public Picture(int x, int y, int w, int h) {
		this.color = Color.red;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Over loading the setColor method
	 * set color using RGB
	 * @param xPos
	 */
	public void setColor(int r, int g, int b) {
		this.color = new Color (r, g, b);
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	/**
	 * method to get height
	 */
	public int getMyHeight() {
		return this.myHeight;
	}

	/**
	 *  Method to get width
	 */
	public int getMyWidth() {
		return this.myWidth;
	}

	// override the JComponent paint
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawRect(this.xPos, this.yPos, this.myWidth, this.myHeight);
		// Adding ovals to make the eagle eye
		g.drawOval(this.xPos, this.yPos, this.myWidth, this.myHeight);
		// Used different variables to center the filled oval
		g.fillOval(this.xPos + (this.myWidth/4), this.yPos, this.myWidth - (this.myWidth / 2), this.myHeight);
		
	}
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Self testing
		// Create a JFrame
		JFrame f = new JFrame("Testing only");
		f.setSize(400, 350); // sets the size of the JFrame
		Picture p = new Picture();// instantiates a picture object
		// add the object to f
		f.add(p);
		
		f.setVisible(true);
		
		// wait command
		JOptionPane.showMessageDialog(null, "Wait to change colour");
		
		// change color
		p.setColor(Color.BLUE);
		
		f.repaint();  // repaint the frame
		
		JOptionPane.showMessageDialog(null, "Wait to change colour");
		
		p.setColor(204, 0, 204);
		
		f.repaint();
		
		JOptionPane.showMessageDialog(null, "Wait to change position and size");
		
		p.setxPos(50);
		p.setyPos(100);
		p.setMyWidth(30);
		p.setMyHeight(100);
		
		f.repaint();
		
		JOptionPane.showMessageDialog(null, "Wait to create new object");
		
		Picture p1 = new Picture(100, 100, 150, 50);
		
		f.add(p1);
		f.setVisible(true);
	}
}
