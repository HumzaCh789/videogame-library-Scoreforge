//Filename: ScoreForge.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Runs when the program is first launched. Immediately generates an Opening screen.

import javax.swing.SwingUtilities;

public class Scoreforge
{
   public static void main(String[] args) 
   {
      OpeningScreen OS = new OpeningScreen(); // creating an Opening screen
      OS.setVisible(true); // displaying the Opening screen
   }
}
