//Filename: GameInputPage.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date Finalized: June 9, 2023  
//Description: Generates the GameInput page which allows users to add records to records.txt

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.File;

/** Generates the GameInput page from the ScoreForge
*library screen which allows users to add records to records.txt
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */

public class GameInputPage extends JFrame {

   /**Game name */
   String gName;
   
   /**Game studio */
   String gStudio;
   
   /**Game release date */
   String gRelease;
   
   /**Game metacritic score */
   String gScore;
   
   /**Game description */
   String gDescription;
   
   /**Game background image */
   String gBG;
   
   /**Game thumbnail image */
   String gTH;
   
   /**Game background image */
   String backGround;
   
   /**Game thumbnail image */
   String thumbNail;
   
   /**Sets the filename (in our case, records.txt). */
   static String fileName = "records.txt";
   
   /**Creates the KeyInput object */
   KeyInput ki = new KeyInput();
   
   /**Creates the NewRecord object */
   NewRecord nr = new NewRecord();
   
   /**Creates the GameInput page. */
   public GameInputPage() {
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
   
      // Create panel for the scoreforge.png image
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
   
      JLabel nameLabel = new JLabel(" Name:      ");
      nameLabel.setFont(labelFont);
      JTextField nameTextField = new JTextField();
      nameTextField.setFont(textFieldFont);
   
      JLabel studioLabel = new JLabel(" Studio:     ");
      studioLabel.setFont(labelFont);
      JTextField studioTextField = new JTextField();
      studioTextField.setFont(textFieldFont);
   
      JLabel releaseDateLabel = new JLabel(" Release:  ");
      releaseDateLabel.setFont(labelFont);
      JTextField releaseDateTextField = new JTextField();
      releaseDateTextField.setFont(textFieldFont);
   
      JLabel ratingLabel = new JLabel(" Rating:     ");
      ratingLabel.setFont(labelFont);
      JTextField ratingTextField = new JTextField();
      ratingTextField.setFont(textFieldFont);
   
      JLabel descriptionLabel = new JLabel(" Description: ");
      descriptionLabel.setFont(labelFont);
      JTextArea descriptionTextArea = new JTextArea();
      descriptionTextArea.setFont(textFieldFont);
      JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
   
      JLabel backgroundImageLabel = new JLabel("Background Image File:");
      backgroundImageLabel.setFont(labelFont);
   
      JButton backgroundImageButton = new JButton("Browse Images");
      backgroundImageButton.setFont(labelFont);
      JTextField backgroundImageTextField = new JTextField();
      backgroundImageTextField.setFont(textFieldFont);
      backgroundImageTextField.setEditable(false);
   
      JLabel thumbnailLabel = new JLabel("Thumbnail File:");
      thumbnailLabel.setFont(labelFont);
   
      JButton thumbnailButton = new JButton("Browse Images");
      thumbnailButton.setFont(labelFont);
      JTextField thumbnailTextField = new JTextField();
      thumbnailTextField.setFont(textFieldFont);
      thumbnailTextField.setEditable(false);
   
      // Set the preferred number of rows and columns for the description text area
      descriptionTextArea.setRows(6);
      descriptionTextArea.setColumns(30);
      
      // Adjust the width of the text fields
      int textFieldWidth = 22;
   
      // Set the width of the text fields
      nameTextField.setColumns(textFieldWidth);
      studioTextField.setColumns(textFieldWidth);
      releaseDateTextField.setColumns(textFieldWidth);
      ratingTextField.setColumns(textFieldWidth);
      backgroundImageTextField.setColumns(textFieldWidth);
      thumbnailTextField.setColumns(textFieldWidth);
   
      // Add labels and text fields to the panel
      textFieldsPanel.add(nameLabel);
      textFieldsPanel.add(nameTextField);
      textFieldsPanel.add(studioLabel);
      textFieldsPanel.add(studioTextField);
      textFieldsPanel.add(releaseDateLabel);
      textFieldsPanel.add(releaseDateTextField);
      textFieldsPanel.add(ratingLabel);
      textFieldsPanel.add(ratingTextField);
      textFieldsPanel.add(descriptionLabel);
      textFieldsPanel.add(descriptionScrollPane);
      textFieldsPanel.add(backgroundImageLabel);
      textFieldsPanel.add(backgroundImageButton);
      textFieldsPanel.add(thumbnailLabel);
      textFieldsPanel.add(thumbnailButton);
   
      backPanel.add(textFieldsPanel, BorderLayout.CENTER);
   
      outerPanel.add(backPanel, BorderLayout.NORTH);
      outerPanel.add(textFieldsPanel, BorderLayout.CENTER);
   
      // Create button panel for the "Back to Home" button
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JButton backButton = new JButton("Back to Home");
      JButton addToLibraryButton = new JButton("Add to Library");
      buttonPanel.add(backButton);
      buttonPanel.add(addToLibraryButton);
   
      // Add the button panel to the outer panel at the bottom
      outerPanel.add(buttonPanel, BorderLayout.SOUTH);
   
      // Add action listeners for the image file chooser buttons
      backButton.addActionListener(e -> { dispose(); });
      
      addToLibraryButton.addActionListener(
         e -> {
            gName = nameTextField.getText();
            gStudio = studioTextField.getText();
            gRelease = releaseDateTextField.getText();
            gScore = ratingTextField.getText();
            gDescription = descriptionTextArea.getText();
            gBG = backGround;
            gTH = thumbNail;
            
            String newRec = ki.entries(gName, gStudio, gRelease, gScore, gDescription, gBG, gTH);
            nr.addRecord(fileName, newRec);
            
            LibraryScreen libraryScreen = new LibraryScreen();
            libraryScreen.setVisible(true);
            dispose(); // Close the current GameInputPage
            
         });
        
      backButton.addActionListener(
         e -> {
            LibraryScreen libraryScreen = new LibraryScreen();
            libraryScreen.setVisible(true);
            dispose(); // Close the current GameInputPage
         });
      
      backgroundImageButton.addActionListener(
         e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(GameInputPage.this);
            if (option == JFileChooser.APPROVE_OPTION) {
               File selectedFile = fileChooser.getSelectedFile();
               backGround = selectedFile.getAbsolutePath();
            }
         });
   
      thumbnailButton.addActionListener(
         e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(GameInputPage.this);
            if (option == JFileChooser.APPROVE_OPTION) {
               File selectedFile = fileChooser.getSelectedFile();
               thumbNail = selectedFile.getAbsolutePath();
            }
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
   /**Creates graphics for the Game Input page */
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
