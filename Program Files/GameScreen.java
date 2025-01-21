//Filename: GameScreen.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date Finalized: June 9, 2023  
//Description: Generates the Game screen for the game selected in library screen

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/** Generates the game screen for the game selected in library screen
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */

public class GameScreen extends JFrame implements ActionListener {
   
   /**Goes back to library screen */
   private JButton backButton;
   
   /**Background */
   public String backGround;
   
   /** Constructor for GameScreen.
   *@param selGameName The selected games name.
   *@param selGameStudio The selected games studio.
   *@param selGameRelease The selected games release date.
   *@param selGameRating The selected games metacritic rating.
   *@param selGameDes The selected games description.
   *@param selGameBg The selected games background image.
   *@param selGameTh The selected games thumbnail image.
   */
   public GameScreen(String selGameName, String selGameStudio, String selGameRelease, String selGameRating, String selGameDes, String selGameBg, String selGameTh) 
   {
      initialize(selGameName);
      backGround = selGameBg;
   
      JPanel outerPanel = 
         new JPanel(new BorderLayout()) 
         {
            protected void paintComponent(Graphics g) 
            {
               super.paintComponent(g);
               drawBackground(g);
            }
         };
      outerPanel.setBorder(new EmptyBorder(0, 300, 0, 300));
   
      JPanel backPanel = new JPanel(new BorderLayout());
   
      // Create panel for the scoreforge.png image
      JPanel logoPanel = new JPanel();
      ImageIcon logoIcon = new ImageIcon("scoreforge.png");
      Image scaledLogoImage = logoIcon.getImage().getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
      ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
      JLabel logoLabel = new JLabel(scaledLogoIcon);
      logoPanel.add(logoLabel);
   
      // Create panel for the image and description
      JPanel imageDescriptionPanel = new JPanel(new BorderLayout());
      imageDescriptionPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add a 10-pixel gap around the image
      
      ImageIcon batmanIcon = new ImageIcon(selGameTh);
      Image batmanImage = batmanIcon.getImage();
      int newHeight = 250; //variable for height of thumbnail
      int newWidth = (int) (((double) newHeight / batmanImage.getHeight(null)) * batmanImage.getWidth(null)); //proportionally changes the
      Image scaledBatmanImage = batmanImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
      ImageIcon scaledBatmanIcon = new ImageIcon(scaledBatmanImage);
      
   
      JPanel infoPanel = new JPanel(new GridLayout(0, 2));
      
      JLabel nameLabel = new JLabel(" Name:");
      JTextField nameTextField = new JTextField(selGameName);
      nameTextField.setEditable(false);
      
      JLabel studioLabel = new JLabel(" Studio:");
      JTextField studioTextField = new JTextField(selGameStudio);
      studioTextField.setEditable(false);
      
      JLabel releaseLabel = new JLabel(" Release Date:");
      JTextField releaseTextField = new JTextField(selGameRelease);
      releaseTextField.setEditable(false);
      
      JLabel ratingLabel = new JLabel(" Rating:");
      JTextField ratingTextField = new JTextField(selGameRating);
      ratingTextField.setEditable(false);
     
      infoPanel.add(nameLabel);
      infoPanel.add(nameTextField);
      infoPanel.add(studioLabel);
      infoPanel.add(studioTextField);
      infoPanel.add(releaseLabel);
      infoPanel.add(releaseTextField);
      infoPanel.add(ratingLabel);
      infoPanel.add(ratingTextField);
     
      JLabel imageLabel = new JLabel(scaledBatmanIcon);
     
      
      imageDescriptionPanel.add(logoPanel, BorderLayout.NORTH);
      imageDescriptionPanel.add(infoPanel, BorderLayout.CENTER);
      imageDescriptionPanel.add(imageLabel, BorderLayout.WEST);
   
      // Create panel for the body paragraph
      JTextArea bodyTextArea = new JTextArea(selGameDes);
      bodyTextArea.setEditable(false);
      bodyTextArea.setLineWrap(true);
      bodyTextArea.setWrapStyleWord(true);
      bodyTextArea.setFont(bodyTextArea.getFont().deriveFont(Font.PLAIN, 14));
      bodyTextArea.setBorder(new EmptyBorder(10,10,10,10)); //add 10 px border to the text area
   
      // Create scroll pane and add the image description panel and body text area
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setViewportView(bodyTextArea);
      scrollPane.setColumnHeaderView(imageDescriptionPanel);
   
      backPanel.add(scrollPane, BorderLayout.CENTER);
   
      outerPanel.add(backPanel, BorderLayout.NORTH);
      outerPanel.add(scrollPane, BorderLayout.CENTER);
   
      // Create button panel for the "Back to Home" button
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      backButton = new JButton("Back to Library");
      backButton.addActionListener(this);
      buttonPanel.add(backButton);
   
      // Add the button panel to the outer panel at the bottom
      outerPanel.add(buttonPanel, BorderLayout.SOUTH);
   
      add(outerPanel);
   }
   /**Sets screensize, name, and makes the x button work
   *@param selGameName This is the game name.  
   */
   private void initialize(String selGameName) //a method that sets screensize, name, and makes x button work
   {
      setTitle(selGameName);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(1280, 720);
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null);
   }
   /**Creates graphics for the Game screen */
   private void drawBackground(Graphics g) 
   {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image background = tk.getImage(backGround);
      g.drawImage(background, 0, 0, this);
   }
   
   /**Listens for action events and reacts to them  */
   public void actionPerformed(ActionEvent e) 
   {
      if (e.getSource() == backButton) 
      {
         LibraryScreen libraryScreen = new LibraryScreen();
         libraryScreen.setVisible(true);
         dispose(); // Close the current LibraryScreen
      }
   }
}
