//Filename: ReadData.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: It gets the records from the external file, 
//records.txt and stores them in a one dimensional array, data.

import java.io.*;

/** Obtains records from records.txt, external file, 
*and stores them in a one dimensional array called data.
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
class ReadData 

{//Read data from external file using readFile() method
   
   /**Constructs a one dimensional array.
   *@param fname This is the records.txt file.
   *@param max The maximum number of records.
   *@return a array of records
   */
   public String[] readFile (String fname, int max) { // fname = "records.txt"
      String data[] = new String[max]; // max = maximum number of records 
      for(int k = 0;k < max; k++) // initialize data array to store max records
         data[k]="";
      int i = 0; // Start counting records
      try{
         DataInput in = new DataInputStream(new FileInputStream(fname));
         String txt = in.readLine();
         while (txt != null) {
            data[i++]=txt; // Store record in array, data; and Increment i
            txt = in.readLine();
         }// end while
      }catch (Exception e) {};
      return data;    // return the entire array of records
   }// end readFile
}// end readData
   
   
   
   
