/**
 * The gamePlayGUI class provides a graphical user interface for a spelling game,
 * displaying a set of buttons to go to a specific level like 1,2,3.
 * 
 * @author Mridul
 */

 import java.awt.EventQueue;

 import javax.swing.ImageIcon;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.GroupLayout;
 import javax.swing.GroupLayout.Alignment;
 import javax.swing.JList;
 import javax.swing.LayoutStyle.ComponentPlacement;
 import java.awt.BorderLayout;
 import java.awt.Color;
 import javax.swing.event.ListSelectionListener;
 import javax.swing.event.ListSelectionEvent;
 import javax.swing.JButton;
 import java.awt.Font;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 
 public class LevelSelectionGUI {
 
     JFrame frame;
     private int width, height;
     private JPanel drawingPanel;
     private ImagePicture background;
     private Gameplay game;
     private gamePlayGUI gUI;
 
     /**
      * Launch the application.
      * @param
      */
     public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
             public void run() {
                 try {
                     LevelSelectionGUI window = new LevelSelectionGUI();
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
     public LevelSelectionGUI() {
         initialize();
     }
 
     /**
      * Initialize the contents of the frame.
      */
     private void initialize() {
         
         width = 1000;
         height = 700;
         
         game = new Gameplay();
         
         // initializing the frame, background, panel and btns
         frame = new JFrame("Bee Spellin");
         drawingPanel = new JPanel();
         
         background = new ImagePicture(new ImageIcon("lock.png"));
         background.setBounds(-100, 0, width, height);
         
         drawingPanel.setBounds(0, 0, width, height);
         drawingPanel.setLayout(null);
         
         // button to go to level 1
         JButton btnLev1 = new JButton("Level 1");
         btnLev1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         try {
                             gamePlayGUI window = new gamePlayGUI();
                             window.frame.setVisible(true);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
             }
         });
         btnLev1.setFont(new Font("ROG Fonts", Font.PLAIN, 40));
         btnLev1.setBackground(new Color(255, 165, 0));
         
         // button to go to level 2
         JButton btnLev2 = new JButton("Level 2");
         btnLev2.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         try {
                             gamePlayGUIL2 window = new gamePlayGUIL2(0);
                             window.frame.setVisible(true);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
             }
         });
         btnLev2.setFont(new Font("ROG Fonts", Font.PLAIN, 40));
         btnLev2.setBackground(new Color(255, 165, 0));
         
         // button to go to level 3
         JButton btnLev3 = new JButton("Level 3");
         btnLev3.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         try {
                             gamePlayGUIL3 window = new gamePlayGUIL3(0);
                             window.frame.setVisible(true);
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
             }
         });
         btnLev3.setFont(new Font("ROG Fonts", Font.PLAIN, 40));
         btnLev3.setBackground(new Color(255, 165, 0));
         // adding the panel to the frame
         frame.getContentPane().add(drawingPanel);
         
         // adding the group layout to the panel
         GroupLayout gl_drawingPanel = new GroupLayout(drawingPanel);
         gl_drawingPanel.setHorizontalGroup(
             gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                     .addGap(10)
                     .addGroup(gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                         .addComponent(btnLev1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnLev2, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnLev3, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
                     .addGap(6)
                     .addComponent(background, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE))
         );
         gl_drawingPanel.setVerticalGroup(
             gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                     .addGap(59)
                     .addComponent(btnLev1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                     .addGap(65)
                     .addComponent(btnLev2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                     .addGap(60)
                     .addComponent(btnLev3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                     .addGap(11)
                     .addComponent(background, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
         );
         // adding the layout to the panel and setting bounds to the frame
         drawingPanel.setLayout(gl_drawingPanel);
         frame.setBounds(150, 30, width, height);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
 }
 