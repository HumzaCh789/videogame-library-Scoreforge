//Filename: SearchInput2.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: April 29, 2023  
//Description: Gets the keyboard input of the value to be searched and deleted. It calls the search method 
//from the Search2.class. 

import java.io.*;

/** Gets the keyboard input of the value to be searched and deleted. It calls the search method 
*from the Search2.class. 
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
class SearchInput2{//Prepare keyboard to recieve data

   
   /**Gets the keyboard input for the value to be deleted and searched. 
   /** Construct a new keyinput.
   * @param fileName The external file which the search will happen in.
   * @param Data[][] The two-dimensional array where the item values are.
   * @param searched The item you want to search for.
   * @param item The array index of the item you want to search for.
   */
 
   public String[][] keyInput (String fileName, String data[][], String searched, int item) {
      String searchResult[][] = new String[1][7];
      String searchedItem = searched;
      String input;
      Search2 s = new Search2();
      input = searchedItem;
      if (input != null)
      {
         s.searching(fileName, data, item, input);
      }
      return(searchResult);
   }// End keyInput
}//end searchinput