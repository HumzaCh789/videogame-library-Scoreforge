//Filename: Search.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Looks for a item  in the records. 
//It searches for data given in a two dimensional array, the item and value to be searched.

import java.io.*;

/** Looks for a item  in the records. 
*It searches for data given in a two dimensional array, 
*the item and value to be searched.
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
class Search {
   
   /**Searches for data in a two dimensional array.
   *@param fileName This is the records.txt file.
   *@param data This is the two dimensional array containing records.
   *@param item This is what is being looked for.  
   *@param input This is also what is being looked for.   
   */
   public String[][] searching (String fileName, String data[][], int item, String input){
   
      String searchResult[][] = new String[1][7];
      boolean found = false;
      for (int i=0; i<data.length; i++){ // Search for records
         if (data[i][item].equals(input)){
            found = true;
            for (int k=0; k<7; k++)
               searchResult[0][k] = data[i][k];
            System.out.println();
         }// end if
      }// end loop
      if(!found)
         System.out.println("lol");
      return(searchResult);
   }// end searching 
}// end Search