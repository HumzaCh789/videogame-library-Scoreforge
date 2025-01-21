//Filename: OpeningScreen.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Generates the Opening screen which is the first screen the user sees
//after opening scoreforge. It allows them to access the library, help, or credits page.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Generates the library screen from the opening screen
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
public class OpeningScreen extends JFrame implements ActionListener
{
   //initialize variables
   
   /**Open help button */
   private JButton btnHelp;
   
   /**Open library button */
   private JButton btnLibrary;
   
   /**Open credits button */
   private JButton btnCredits;

   public OpeningScreen() //constructor
   { 
      initialize();
   
      JPanel mainPanel = 
         new JPanel(null) 
         {
            protected void paintComponent(Graphics g) 
            {
               super.paintComponent(g);
               drawBackground(g);
            }
         };
   
      btnHelp = new JButton("Help");
      btnHelp.setFont(new Font("Impact", Font.PLAIN, 40));
      btnHelp.setBounds(300, 250, 300, 200);
      btnHelp.addActionListener(this);
   
      btnCredits = new JButton("Credits");
      btnCredits.setFont(new Font("Impact", Font.PLAIN, 40));
      btnCredits.setBounds(300, 450, 300, 200);
      btnCredits.addActionListener(this);
   
      btnLibrary = new JButton("Library");
      btnLibrary.setFont(new Font("Impact", Font.PLAIN, 60));
      btnLibrary.setBounds(600, 250, 350, 400);
      btnLibrary.addActionListener(this);
   
      mainPanel.add(btnHelp);
      mainPanel.add(btnCredits);
      mainPanel.add(btnLibrary);
      add(mainPanel);
   }
   
   /**Sets screensize, name, and makes the x button work  */
   private void initialize() //a method that sets screensize, name, and makes x button work
   { 
      setTitle("SCOREFORGE");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //uses a default operation to make the x button close the program
      setSize(1280,720);
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null); //centres screen
   }
   
   /**Creates graphics for the opening screen */
   private void drawBackground(Graphics g)
   {        
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image background = tk.getImage("mainpage_background.png"); //Background photo for homescreen.
      g.drawImage(background, 0, 0, this);
   
      Image logo = tk.getImage("scoreforgegif.gif"); //scoreforge logo gif.
      g.drawImage(logo,350,30,this);
   }

   /**Listens for action events and reacts to them  */
   public void actionPerformed(ActionEvent e) 
   {
      if (e.getSource() == btnHelp) 
      {
         HelpPage helpPage = new HelpPage();
         helpPage.setVisible(true);
         dispose();
      }
      
      else if (e.getSource() == btnLibrary)
      {
         LibraryScreen libraryScreen = new LibraryScreen();
         libraryScreen.setVisible(true);
         dispose(); // Close the current OpeningScreen
      }
      
      else if (e.getSource() == btnCredits)
      {
         AboutUsPage CreditsScreen = new AboutUsPage();
         CreditsScreen.setVisible(true);
         dispose(); // Close the current OpeningScreen
      }
   }
}