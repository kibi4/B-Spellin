/**
 * The gamePlayGUI class provides a graphical user interface for a spelling game,
 * displaying a set of buttons to re route to a part of the game you would like to go to.
 * It includes New game, Load Game etc.
 * 
 * @author Mridul
 */

 import java.awt.EventQueue;

 import javax.swing.JFrame;
 import javax.swing.JOptionPane;
 import javax.swing.JPanel;
 import javax.swing.JButton;
 import java.awt.BorderLayout;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 import javax.swing.SwingConstants;
 import javax.swing.border.Border;
 
 import java.awt.Font;
 import java.awt.Image;
 import java.awt.Color;
 import java.awt.FlowLayout;
 import net.miginfocom.swing.MigLayout;
 import java.awt.Rectangle;
 import java.awt.Toolkit;
 import java.awt.Dimension;
 import java.awt.Component;
 import java.awt.Point;
 
 import javax.swing.BorderFactory;
 import javax.swing.GroupLayout;
 import javax.swing.GroupLayout.Alignment;
 import javax.swing.Icon;
 import javax.swing.ImageIcon;
 import javax.swing.LayoutStyle.ComponentPlacement;
 import javax.swing.AbstractAction;
 import javax.swing.Action;
 
 public class MainMenuGUI {
     // Instance Variables for frame, panel etc
     JFrame frame;
     private JPanel drawingPanel;
     private int width, height;
     private ImagePicture background;
     private TextPicture logo;
 
     /**
      * Launch the application.
      */
     public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
             public void run() {
                 try {
                     MainMenuGUI window = new MainMenuGUI();
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
     public MainMenuGUI() {
         initialize();
     }
 
     /**
      * Initialize the contents of the frame.
      */
     private void initialize() {
 
         width = 1000;
         height = 700;
 
         // initializing frame and panels
         frame = new JFrame("Bee Spellin");
         drawingPanel = new JPanel();
 
         logo = new TextPicture(20);
         logo.setTitle("Bee Spellin");
         logo.setF(new Font("Stencil", Font.PLAIN, 90));
         logo.setyPos(100);
         logo.setColor(new Color(153, 0, 0));
         logo.setBounds(240, 0, 600, 200);
 
         drawingPanel.add(logo);
         frame.repaint();
 
         // Images and labels
         background = new ImagePicture(new ImageIcon("back.png"));
         background.setBounds(0, -50, width, height);
 
         drawingPanel.setBounds(0, 0, width, height);
         drawingPanel.setLayout(null);
 
         // Making and initializing each Button
         JButton btnNewGame = new JButton("New Game");
         btnNewGame.setForeground(new Color(0, 0, 0));
         btnNewGame.setBackground(Color.orange);
         btnNewGame.setFont(new Font("ROG Fonts", Font.PLAIN, 21));
         btnNewGame.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         try {
                             NewGame frame = new NewGame();
                             frame.setVisible(true);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
                 frame.setVisible(false);
             }
         });
         btnNewGame.setMaximumSize(new Dimension(1000, 1000));
         btnNewGame.setBounds(new Rectangle(0, 0, 60, 200));
         btnNewGame.setSize(50, 100);
         
         // btn to go to save/load game
         JButton btnLoad = new JButton("Load Game");
         btnLoad.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         try {
                             SaveLoad frame = new SaveLoad();
                             frame.setVisible(true);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
             }
         });
         btnLoad.setForeground(new Color(255, 255, 255));
         btnLoad.setBackground(new Color(25, 25, 112));
         btnLoad.setMaximumSize(new Dimension(1000, 1000));
         btnLoad.setFont(new Font("ROG Fonts", Font.PLAIN, 21));
         btnLoad.setBounds(new Rectangle(0, 0, 60, 200));
 
         // btn to go to tutorial
         JButton btnTutorial = new JButton("Tutorial");
         btnTutorial.setBackground(Color.orange);
         btnTutorial.setMaximumSize(new Dimension(1000, 1000));
         btnTutorial.setFont(new Font("ROG Fonts", Font.PLAIN, 21));
         btnTutorial.setBounds(new Rectangle(0, 0, 60, 200));
         
         // button to go to highscore
         JButton btnHighScore = new JButton("High Score");
         btnHighScore.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         try {
                             HighScoreGUI frame = new HighScoreGUI();
                             frame.setVisible(true);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
             }
         });
         btnHighScore.setForeground(new Color(255, 255, 255));
         btnHighScore.setBackground(new Color(25, 25, 112));
         btnHighScore.setMaximumSize(new Dimension(1000, 1000));
         btnHighScore.setFont(new Font("ROG Fonts", Font.PLAIN, 21));
         btnHighScore.setBounds(new Rectangle(0, 0, 60, 200));
 
         // btn to exit, accessibility and Instructor Dashboard
         JButton btnExit = new JButton("Exit");
         btnExit.setForeground(new Color(230, 230, 250));
         btnExit.setBackground(new Color(25, 25, 112));
         btnExit.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
         });
         btnExit.setMaximumSize(new Dimension(1000, 1000));
         btnExit.setFont(new Font("ROG Fonts", Font.PLAIN, 21));
         btnExit.setBounds(new Rectangle(0, 0, 60, 200));
 
         JButton btnAccesibility = new JButton("Accesibility");
         btnAccesibility.setBackground(Color.orange);
         btnAccesibility.setMaximumSize(new Dimension(1000, 1000));
         btnAccesibility.setFont(new Font("ROG Fonts", Font.PLAIN, 21));
         btnAccesibility.setBounds(new Rectangle(0, 0, 60, 200));
 
         JButton btnID = new JButton("InstructorDash");
         btnID.setBackground(new Color(255, 165, 0));
         btnID.setFont(new Font("ROG Fonts", Font.PLAIN, 9));
         btnID.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
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
         });
         // GroupLayout for the panel
         GroupLayout gl_drawingPanel = new GroupLayout(drawingPanel);
         gl_drawingPanel.setHorizontalGroup(
                 gl_drawingPanel.createParallelGroup(Alignment.TRAILING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                         .addGap(391)
                         .addGroup(gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addGap(27)
                                         .addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                         .addGap(31))
                                 .addComponent(btnAccesibility, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addGap(11)
                                         .addComponent(btnHighScore, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                         .addGap(11))
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addGap(24)
                                         .addComponent(btnTutorial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                         .addGap(24))
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addGap(15)
                                         .addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                         .addGap(15))
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addGap(13)
                                         .addComponent(btnNewGame, GroupLayout.PREFERRED_SIZE, 189, Short.MAX_VALUE)
                                         .addGap(13)))
                         .addGap(380))
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                         .addContainerGap(830, Short.MAX_VALUE)
                         .addComponent(btnID, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                         .addContainerGap())
                 );
         gl_drawingPanel.setVerticalGroup(
                 gl_drawingPanel.createParallelGroup(Alignment.TRAILING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                         .addGap(164)
                         .addComponent(btnNewGame, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                         .addGap(18)
                         .addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                         .addGap(18)
                         .addComponent(btnTutorial, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                         .addGap(18)
                         .addComponent(btnHighScore, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                         .addGap(18)
                         .addComponent(btnAccesibility, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                         .addGap(26)
                         .addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                         .addGap(44)
                         .addComponent(btnID, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                         .addContainerGap())
                 );
         // setting the layout as group in the panel and adding the background
         drawingPanel.setLayout(gl_drawingPanel);
         drawingPanel.add(background);
         // adding the panel to the frame and setting bounds
         frame.getContentPane().add(drawingPanel);
         frame.setBounds(150, 30, width, height);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
 }
 