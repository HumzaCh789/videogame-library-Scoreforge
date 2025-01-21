 //Filename: Search.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Used to read all records and write them back to the external file, records.txt. 

import java.io.*;

/** Used to read all records and write them back to the external file, records.txt. 
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
class Search2 {//returns array after deleting 

    /**Reads all the records and writes back to the external file.
   *@param fileName This is the records.txt file.
   *@param data This is the two dimensional array containing records.
   *@param item This is what is being looked for.  
   *@param input This is also what is being looked for.   
   */
   void searching (String fileName, String data[][], int item, String input){
      //item:o=name etc
      boolean found = false;
      for (int i = 0; i<data.length; i++){//Search for records
         if (data[i][item].equals(input)) {
            found = true;
            for (int k = 0; k<7; k++){
               data[i][k]=""; //Erase the record items
            }
         }//end if 
      }//end loop 
      UpdateRecords ur = new UpdateRecords();
      ur.updateFile(fileName, data);
   }//end searching 
}//end Search2