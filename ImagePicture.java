import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Mridul
 * Inherits from the picture class
 * Draws ImageIcons
 *
 */
public class ImagePicture extends Picture {

	private ImageIcon image;
	
	/**
	 * constructor that takes only an image
	 */
	
	public ImagePicture(ImageIcon image) {
		super(); // calls the picture constructor
		this.image = image;
		setMyWidth(image.getIconWidth()); // calls pic setMyWidth
		setMyHeight(image.getIconHeight()); // calls pic setMyHeight
	}
	/**
	 * Constructor to allow an object to be placed in a given x and y
	 */
	public ImagePicture(ImageIcon image, int x, int y) {
		// calls the constructor picture that take x, y, w, h.
		super(x, y, image.getIconWidth(), image.getIconHeight()); // calls the picture constructor
		this.image = image;
	}
	// create a setter for the image	
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	// Override the paint method
	public void paint(Graphics g) {
		// paint my image
		this.image.paintIcon(this, g, getxPos(), getyPos());
	}

	/**
	 * 
	 */
	public static void main(String[] args) {
		// self testing
		// declare and create an imagePicture object
		JFrame f = new JFrame("Testing");
		
		f.setSize(1000, 700);
		
		ImagePicture i = new ImagePicture(new ImageIcon("Itachi.gif"));
		
		f.add(i);
		f.setVisible(true);
		
		// wait message
		JOptionPane.showMessageDialog(null, "Wait for the image to move");
		i.setxPos(350);
		i.setyPos(350);
		
		f.repaint();
		// wait message
		JOptionPane.showMessageDialog(null, "Wait for the image to move");
		
		// adding another image
		ImagePicture i2 = new ImagePicture(new ImageIcon("NarutoUzumaki.png"), 100, 50);
		f.add(i2);
		f.setVisible(true);
		
		// wait message
		JOptionPane.showMessageDialog(null, "Wait to change the icon");
		
		i2.setImage(new ImageIcon("Itachi.gif"));
		
		f.repaint();

	}

}
