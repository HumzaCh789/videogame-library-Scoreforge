//Filename: DeletePage.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date Finalized: June 9, 2023  
//Description: Generates the Delete page from the ScoreForge library screen which allows users
//to delete records from records.txt 

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.File;

/** Generates the Delete page from the ScoreForge
*library screen which allows users to delete records from records.txt
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */

public class DeletePage extends JFrame {
   
   /**Name of record to be deleted */
   String gName;
   
   /**Name of file holding records */
   static String fileName = "records.txt";
   
   /**Initializes SearchInput2 object */
   SearchInput2 si2 = new SearchInput2();
   
   /**Creates the Delete page, uses the 2d array info to find the record to be deleted */
   public DeletePage(String[][] info) {
      initialize();
   
      JPanel outerPanel = 
         new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               drawBackground(g);
            }
         };
      outerPanel.setBorder(new EmptyBorder(0, 200, 0,0)); // Adjusted border size for the smaller screen
   
      JPanel backPanel = new JPanel(new BorderLayout());
   
      // Create panel for scoreforge.png image
      JPanel logoPanel = new JPanel();
      ImageIcon logoIcon = new ImageIcon("scoreforge.png");
      Image scaledLogoImage = logoIcon.getImage().getScaledInstance(-1, 75, Image.SCALE_SMOOTH); // Adjusted image height for the smaller screen
      ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
      JLabel logoLabel = new JLabel(scaledLogoIcon);
      logoPanel.add(logoLabel);
   
      // Create panel for the text fields and buttons
      JPanel textFieldsPanel = new JPanel(new FlowLayout()); // 8 rows, 2 columns, 10-pixel gap between components
   
      Font labelFont = new Font("Arial", Font.BOLD, 14); // Adjusted font size for the smaller screen
      Font textFieldFont = new Font("Arial", Font.PLAIN, 14); // Adjusted font size for the smaller screen
   
      JLabel nameLabel = new JLabel("Game to be deleted (name):      ");
      nameLabel.setFont(labelFont);
      JTextField nameTextField = new JTextField();
      nameTextField.setFont(textFieldFont);
      
      // Adjust the width of the text fields
      int textFieldWidth = 22; 
   
      // Set the width of the text fields
      nameTextField.setColumns(textFieldWidth);
   
      // Add labels and text fields to the panel
      textFieldsPanel.add(nameLabel);
      textFieldsPanel.add(nameTextField);
       
      backPanel.add(textFieldsPanel, BorderLayout.CENTER);
   
      outerPanel.add(backPanel, BorderLayout.NORTH);
      outerPanel.add(textFieldsPanel, BorderLayout.CENTER);
   
      // Create button panel for the backButton button
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JButton backButton = new JButton("Back to Home");
      JButton delLibraryButton = new JButton("Delete from library");
      buttonPanel.add(backButton);
      buttonPanel.add(delLibraryButton);
   
      // Add the button panel to the outer panel at the bottom
      outerPanel.add(buttonPanel, BorderLayout.SOUTH);
   
      // Add action listeners for the image file chooser buttons
      backButton.addActionListener(
         e -> {
            LibraryScreen libraryScreen = new LibraryScreen();
            libraryScreen.setVisible(true);
            dispose(); 
         
         });
      
      delLibraryButton.addActionListener(
         e -> {
            gName = nameTextField.getText();
            si2.keyInput(fileName, info, gName, 0);
            
            LibraryScreen libraryScreen = new LibraryScreen();
            libraryScreen.setVisible(true);
            dispose(); // Close the current GameInputPage
            
         });
   
      add(outerPanel);
   }
     
   /**Sets screensize, name, and makes the x button work */
   private void initialize() {
      setTitle("Game Input");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(600, 400); // Adjusted window size for the smaller screen
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null);
   }
   /**Creates graphics for the Delete page */
   private void drawBackground(Graphics g) {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image background = tk.getImage("inputscreen_bg.png");
      g.drawImage(background, 0, 0, this);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(
         () -> {
            new GameInputPage();
         });
   }
}
