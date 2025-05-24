/**
 * The gamePlayGUI class provides a graphical user interface for a spelling game,
 * displaying a set of letters, a special letter, and a text area for inputting words.
 * It includes functionality to start the game, enter words, shuffle letters, and navigate
 * to a save/load screen. The class also updates the displayed word list based on correct or incorrect
 * word entries.
 * 
 * @author Mridul
 */

 import java.awt.EventQueue;

 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.GroupLayout;
 import javax.swing.ImageIcon;
 import javax.swing.GroupLayout.Alignment;
 import javax.swing.JTextArea;
 import java.awt.Color;
 import java.awt.Font;
 import javax.swing.JButton;
 import javax.swing.LayoutStyle.ComponentPlacement;
 import javax.swing.JTextField;
 import java.awt.event.ActionListener;
 import java.util.List;
 import java.util.Timer;
 import java.util.TimerTask;
 import java.awt.event.ActionEvent;
 
 public class gamePlayGUI {
 
     JFrame frame;
     private JPanel drawingPanel;
     private ImagePicture background;
     private int width, height, points;
     private String s;
     private newGameplay game;
     private JTextField text;
     private TextPicture logo, sl, l;;;
     
     /**
      * Launch the application.
      * @param
      */
     public static void main(String[] args) {
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
 
     /**
      * Create the application.
      */
     public gamePlayGUI() {
         initialize();
     }
 
     /**
      * Initialize the contents of the frame.
      */
     private void initialize() {
 
         width = 1000;
         height = 700;
         
         points = 0;
 
         game = new newGameplay();
 
         s = "Words Done:\n";
 
         frame = new JFrame("Bee Spellin");
         drawingPanel = new JPanel();
 
         logo = new TextPicture(20);
         sl = new TextPicture(10);
         l = new TextPicture(10);
         
 
         List<Character> let = game.generateLetters();
 
         // Choose a special letter
         char specialLetter = game.chooseSpecialLetter(let);
 
         // Generate word list based on the selected letters and special letter
         List<String> wordList = game.generateWordList(let, specialLetter);
         
         // Here for the coders convinience to get the correct words
         System.out.println(wordList);
         
         // setting up the main letters, the special letter, and level number
         logo.setTitle(game.lettersToString(let));
         logo.setF(new Font("Stencil", Font.PLAIN, 90));
         logo.setyPos(100);
         logo.setColor(new Color(153, 0, 0));
         logo.setBounds(150, 60, 1000, 200);
         
         sl.setTitle("The Special Letter is: " + specialLetter);
         sl.setF(new Font("Stencil", Font.PLAIN, 30));
         sl.setyPos(100);
         sl.setColor(new Color(153, 0, 0));
         sl.setBounds(300, 125, 1000, 200);
         
         l.setTitle("Level 1");
         l.setF(new Font("Stencil", Font.PLAIN, 30));
         l.setyPos(30);
         l.setColor(new Color(153, 0, 0));
         l.setBounds(450, 0, 400, 100);
         
         // adding each and repainting the frame
         drawingPanel.add(logo);
         drawingPanel.add(sl);
         drawingPanel.add(l);
         frame.repaint();
         frame.repaint();
         frame.repaint();
 
         // Background image and setting its bounds
         background = new ImagePicture(new ImageIcon("hon.jpg"));
         background.setBounds(0, 0, width, height);
 
         drawingPanel.setBounds(0, 0, width, height);
         drawingPanel.setLayout(null);
 
         // setting up textArea to show the words done
         JTextArea textArea = new JTextArea();
         textArea.setWrapStyleWord(true);
         textArea.setSelectedTextColor(new Color(255, 218, 185));
         textArea.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 25));
         textArea.setText(s);
         textArea.setEditable(false);
         textArea.setBackground(new Color(218, 165, 32));
         // adding a scroller to the text area
         JScrollPane sp = new JScrollPane(textArea);
         
         // setting up buttons and there actions
         
         // Save and load button
         JButton btnSL = new JButton("Save/Load");
         btnSL.addActionListener(new ActionListener() {
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
         btnSL.setBackground(new Color(255, 228, 196));
         btnSL.setFont(new Font("ROG Fonts", Font.PLAIN, 15));
 
         // btn to show a hint
         JButton btnHint = new JButton("Hint");
         btnHint.setFont(new Font("ROG Fonts", Font.PLAIN, 11));
         btnHint.setBackground(new Color(255, 69, 0));
 
         //textField to input the words
         text = new JTextField();
         text.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 17));
         text.setBackground(new Color(255, 255, 255));
         text.setColumns(10);
 
         // enter button to check if it is right or wrong
         JButton btnEnter = new JButton("Enter");
         // action feature
         btnEnter.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 // checking if time finishes
                 if(game.timerFinished) {
                     // dissapearing the letters and launching the next level
                     logo.setTitle("");
                     sl.setTitle("");
                     frame.repaint();
                     frame.repaint();
                     frame.setVisible(false);
                     EventQueue.invokeLater(new Runnable() {
                         public void run() {
                             try {
                                 gamePlayGUIL2 window = new gamePlayGUIL2(points);
                                 window.frame.setVisible(true);
                             } catch (Exception e) {
                                 e.printStackTrace();
                             }
                         }
                     });
                     
                 }
                 // checking for the word if it is correct or not
                 String input = text.getText();
                 if(game.isCorrect(input, wordList)) {
                     points = points + 1;
                     s = s + input + " (Correct!!)\n";
                     textArea.setText(s);
                     text.setText("");
                 }
                 else {
                     s = s + input + " (Wrong)\n";
                     textArea.setText(s);
                     text.setText("");
                 }
 
             }
         });
         // setting up the font
         btnEnter.setFont(new Font("ROG Fonts", Font.PLAIN, 12));
 
         // shuffle button
         JButton btnShuffle = new JButton("Shuffle");
         btnShuffle.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
 
             }
         });
         btnShuffle.setFont(new Font("ROG Fonts", Font.PLAIN, 16));
 
         // start button to start the timer
         JButton btnStart = new JButton("Start");
         btnStart.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 game.startTimer();
                 
             }
 
         });
         btnStart.setFont(new Font("ROG Fonts", Font.PLAIN, 16));
         
         // group layout for the panel
         GroupLayout gl_drawingPanel = new GroupLayout(drawingPanel);
         gl_drawingPanel.setHorizontalGroup(
                 gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                         .addGroup(gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addGap(84)
                                         .addGroup(gl_drawingPanel.createParallelGroup(Alignment.LEADING, false)
                                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                                         .addComponent(text, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
                                                         .addGap(18)
                                                         .addComponent(btnEnter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                 .addComponent(sp, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE))
                                         .addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE))
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addGap(368)
                                         .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                         .addPreferredGap(ComponentPlacement.UNRELATED)
                                         .addComponent(btnShuffle))
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addContainerGap()
                                         .addComponent(btnSL, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                         .addPreferredGap(ComponentPlacement.RELATED, 749, Short.MAX_VALUE)
                                         .addComponent(btnHint)))
                         .addContainerGap())
                 );
         gl_drawingPanel.setVerticalGroup(
                 gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                 .addGroup(gl_drawingPanel.createSequentialGroup()
                         .addContainerGap()
                         .addGroup(gl_drawingPanel.createParallelGroup(Alignment.LEADING)
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addComponent(btnHint)
                                         .addContainerGap())
                                 .addGroup(gl_drawingPanel.createSequentialGroup()
                                         .addComponent(btnSL, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                         .addGap(191)
                                         .addGroup(gl_drawingPanel.createParallelGroup(Alignment.BASELINE)
                                                 .addComponent(btnShuffle)
                                                 .addComponent(btnStart))
                                         .addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                         .addGroup(gl_drawingPanel.createParallelGroup(Alignment.BASELINE)
                                                 .addComponent(text, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                         .addPreferredGap(ComponentPlacement.UNRELATED)
                                         .addComponent(sp, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                         .addGap(47))))
                 );
         // inputting the layout in the panel and adding the background
         drawingPanel.setLayout(gl_drawingPanel);
         drawingPanel.add(background);
         // adding the panel to the frame and setting bounds
         frame.getContentPane().add(drawingPanel);
         frame.setBounds(150, 30, width, height);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
 }
 