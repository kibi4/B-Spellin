/**
 * The gamePlayGUI class provides a graphical user interface for a spelling game,
 * Displaying confidential data to the instructor.
 * 
 * @author Mridul
 */

 import java.awt.Color;
 import java.awt.EventQueue;
 import java.awt.Font;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 import javax.swing.GroupLayout;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.GroupLayout.Alignment;
 import javax.swing.JScrollPane;
 import javax.swing.JTextArea;
 import javax.swing.LayoutStyle.ComponentPlacement;
 
 public class insDashGUI {
     // instance variables
     JFrame frame;
     private int width, height;
     private JPanel drawingPanel;
     private ImagePicture background;
     private instructorDashboard ins;
 
     /**
      * Launch the application.
      * @param
      */
     public static void main(String[] args) {
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
 
     /**
      * Create the application.
      */
     public insDashGUI() {
         initialize();
     }
 
     /**
      * Initialize the contents of the frame.
      */
     private void initialize() {
 
         width = 1000;
         height = 700;
         
         ins = new instructorDashboard("highScoreTable.csv");
         
         // initializing the frame, panel and background and textarea
         frame = new JFrame("Bee Spellin");
         drawingPanel = new JPanel();
         
         background = new ImagePicture(new ImageIcon("lock.png"));
         background.setBounds(-100, 0, width, height);
         
         drawingPanel.setBounds(0, 0, width, height);
         drawingPanel.setLayout(null);
         frame.getContentPane().add(drawingPanel);
         // showing the report with the use of this text area with a scroll
         JTextArea textArea = new JTextArea();
         textArea.setBackground(new Color(255, 165, 0));
         textArea.setText(ins.generateReport());
         JScrollPane scroll = new JScrollPane(textArea);
         
         // adding the group layout
         GroupLayout gl_drawingPanel = new GroupLayout(drawingPanel);
         gl_drawingPanel.setHorizontalGroup(
             gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                     .addGap(25)
                     .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(ComponentPlacement.UNRELATED)
                     .addComponent(background, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE))
         );
         gl_drawingPanel.setVerticalGroup(
             gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                     .addGap(11)
                     .addComponent(background, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                     .addGap(84)
                     .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
         );
         // setting layout as group layout and setting bounds
         drawingPanel.setLayout(gl_drawingPanel);
         frame.setBounds(150, 30, width, height);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
 }