//Filename: HelpPage.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date Finalized: June 9, 2023  
//Description: Generates the help screen from opening screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/** Generates the help screen from the opening screen
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */

public class HelpPage extends JFrame implements ActionListener {

   /**Back to opening screen button */
   private JButton backButton;

   public HelpPage() {
      initialize();
   
      JPanel outerPanel = 
         new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               drawBackground(g);
            }
         };
      outerPanel.setBorder(new EmptyBorder(0, 300, 0, 300));
   
      JPanel backPanel = new JPanel(new BorderLayout());
   
      // Create panel for the "scoreforge.png" image
      JPanel logoPanel = new JPanel();
      ImageIcon logoIcon = new ImageIcon("scoreforge.png");      
      Image scaledLogoImage = logoIcon.getImage().getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
      ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
      JLabel logoLabel = new JLabel(scaledLogoIcon);
      logoPanel.add(logoLabel);
   
      // Create panel for the image and description
      JPanel imageDescriptionPanel = new JPanel(new BorderLayout());
      imageDescriptionPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add a 10-pixel gap around the image
   
      ImageIcon ourTeamIcon = new ImageIcon("help.png");
      Image ourTeamImage = ourTeamIcon.getImage();
      int newHeight = 250; // Variable for height of thumbnail
      int newWidth = (int) (((double) newHeight / ourTeamImage.getHeight(null)) * ourTeamImage.getWidth(null)); // Proportionally changes the width based on the height
      Image scaledOurTeamImage = ourTeamImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
      ImageIcon scaledOurTeamIcon = new ImageIcon(scaledOurTeamImage);
   
      JLabel imageLabel = new JLabel(scaledOurTeamIcon);
   
   
      imageDescriptionPanel.add(logoPanel, BorderLayout.NORTH);
      imageDescriptionPanel.add(imageLabel, BorderLayout.WEST);
      
   
      // Create panel for the body paragraph
      JTextArea bodyTextArea = new JTextArea("Upon opening this program you were greeted with 3 buttons, one of which being the hellp page which you have selected and the other two being 'Library' and 'Credits'. The Credits Page gives some information about our team of developers that worked on this program, and the library page leads you to the main functionality of our program. \n\n The Library page has 4 main functions: \n\n Search: Use this to find any game within the list.\n Sort: Use this to sort the list of games by different attributes. \n Add Record: Use this to add a game to the list in the library. \n Delete Record: Use this to delete any game from the list list in the library. \n\n To return to a previous menu seek the 'Back' button at the bottom of your screen.");
      bodyTextArea.setEditable(false);
      bodyTextArea.setLineWrap(true);
      bodyTextArea.setWrapStyleWord(true);
      bodyTextArea.setFont(bodyTextArea.getFont().deriveFont(Font.PLAIN, 16));
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
      backButton = new JButton("Back to Home");
      backButton.addActionListener(this);
      buttonPanel.add(backButton);
      
   
      // Add the button panel to the outer panel at the bottom
      outerPanel.add(buttonPanel, BorderLayout.SOUTH);
   
      add(outerPanel);
   }
   /**Sets screensize, name, and makes the x button work  */
   private void initialize() {
      setTitle("Help Page");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(1280, 720);
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null);
   }
   
   /**Creates graphics for the Help page */
   private void drawBackground(Graphics g) {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image background = tk.getImage("mainpage_background.png");
      g.drawImage(background, 0, 0, this);
   }
   
   /**Listens for action events and reacts to them  */
   public void actionPerformed(ActionEvent e) 
   {
      if (e.getSource() == backButton) 
      {
         OpeningScreen openingScreen = new OpeningScreen();
         openingScreen.setVisible(true);
         dispose(); // Close the current HelpPage
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(
         () -> {
            new AboutUsPage();
         });
   }
}
