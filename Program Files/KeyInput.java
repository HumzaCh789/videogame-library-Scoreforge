//Filename: KeyInput.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Requires the user to enter the relevant 
//information and returns a string suitable for insertion into an existing external file. 

import java.io.*;

/** Requires the user to enter the relevant 
*information and returns a string suitable 
*for insertion into an existing external file. 
*@author Alex Bangu,Costa */
class KeyInput{ 
  
  /**Record to be added to records.txt */
   static String txt;
               
               /**Uses the information entered and returns a string. 
               *@param gName  This is the game name.
               *@param gStudio  This is the game studio.
               *@param gRelease  This is the game release date.
               *@param gRating  This is the game metacritic rating.
               *@param gDescrtiption  This is the game description.
               *@param gBG  This is the game background.
               *@param gTH  This is the game thumbnail. 
               */  
   public static String entries(String gName, String gStudio, String gRelease, String gScore, String gDescription, String gBG, String gTH){
      
         
      txt = gName + "#" + gStudio + "#" + gRelease + "#" + gScore + "#" + gDescription + "#" + gBG + "#" + gTH + "#";
         
      return txt;
   }//end entries 
}//end keyInput 

