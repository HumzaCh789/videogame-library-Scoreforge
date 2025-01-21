//Filename: SearchInput.java 
//Authors: Ajanth Suthan and Alex Bangu
//Date: June 9, 2023  
//Description: Gets the keyboard input of the value to be searched and deleted. It calls the search method 
//from the Search.class. 

import java.io.*;

/** SearchInput has a method which takes the keyboard input for the item to be searched.
* 
* @author Alex Bangu, Costa Giannaras, Humza Chaudhry*/

class SearchInput {//prepare keyboard to receive data
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
      Search s = new Search();
      input = searchedItem;
      if (input != null)
      {
         searchResult = s.searching(fileName, data, item, input);
      }
      return(searchResult);
   }// End keyInput
}//end searchinput     
