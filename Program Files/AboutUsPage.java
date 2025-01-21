//Filename: AboutUsPage.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date Finalized: June 9, 2023  
//Description: Generates the Credits page from the ScoreForge opening screen. 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/** Generates the credits page from the 
*ScoreForge opening screen. 
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */

public class AboutUsPage extends JFrame implements ActionListener {

   /**Back to home button */
   private JButton backButton;

   /**Constructs the AboutUsPage */
   public AboutUsPage() {
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
   
      ImageIcon ourTeamIcon = new ImageIcon("ourteam.png"); 
      Image ourTeamImage = ourTeamIcon.getImage();
      int newHeight = 250; // Variable for height of thumbnail
      int newWidth = (int) (((double) newHeight / ourTeamImage.getHeight(null)) * ourTeamImage.getWidth(null)); // Proportionally changes the width based on the height
      Image scaledOurTeamImage = ourTeamImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
      ImageIcon scaledOurTeamIcon = new ImageIcon(scaledOurTeamImage);
   
      JLabel imageLabel = new JLabel(scaledOurTeamIcon);
   
      JTextArea descriptionTextArea = new JTextArea("About Us: We are a group of three aspiring computer scientists from high school who have come together to create this program out of our love for video games and programming. With a shared passion for both the gaming world and the intricacies of coding, we aim to combine our skills and knowledge to develop a beautiful videogame sorting program. Our journey began with a mutual fascination for video games and a desire to understand the technology behind them."); // first paragraph
      descriptionTextArea.setEditable(false);
      descriptionTextArea.setLineWrap(true);
      descriptionTextArea.setWrapStyleWord(true);
      descriptionTextArea.setBorder(new EmptyBorder(10,10,10,10));//add 10 px border to the text area
      
      descriptionTextArea.setFont(descriptionTextArea.getFont().deriveFont(Font.PLAIN, 16));
      imageDescriptionPanel.add(logoPanel, BorderLayout.NORTH);
      imageDescriptionPanel.add(imageLabel, BorderLayout.WEST);
      imageDescriptionPanel.add(descriptionTextArea, BorderLayout.CENTER);
      
   
      // Create panel for the body paragraph
      JTextArea bodyTextArea = new JTextArea("Throughout our collaboration, we have been inspired by the vast possibilities that programming offers. The ability to transform ideas into tangible software, to create virtual worlds, and to bring joy to others through our creations fuels our motivation. We believe that by combining our individual strengths, we can push the boundaries of what is possible and deliver innovative solutions. Our journey as aspiring computer scientists has been characterized by continuous learning, problem-solving, and a deep appreciation for the intersection of gaming and programming. We are excited to share our passion with you through this program and hope that it brings you as much enjoyment as it has brought us during its development."); // paragraphs below image
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
      /**Sets screensize, name, and makes the x button work */
   private void initialize() { //a method that sets screensize, name, and makes x button work
      setTitle("About Us");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //uses a default operation to make the x button close the program
      setSize(1280, 720);
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null); //centres screen
   }
      
    /**Creates graphics for the About us page */
   private void drawBackground(Graphics g) {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image background = tk.getImage("aboutus.png");
      g.drawImage(background, 0, 0, this);
   }
   
   /**Listens for action events and reacts to them  */
   public void actionPerformed(ActionEvent e) 
   {
      if (e.getSource() == backButton) 
      {
         OpeningScreen openingScreen = new OpeningScreen();
         openingScreen.setVisible(true);
         dispose(); // Close the current AboutUsPage
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(
         () -> {
            new AboutUsPage();
         });
   }
}
