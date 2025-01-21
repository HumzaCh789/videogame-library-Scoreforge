//Filename: UpdateRecords.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Looks for the record that has to be deleted and updates the remaining files. 

import java.io.*;

/**Looks for the record that has to be deleted and updates the remaining files.  
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
class UpdateRecords{

    /**Deletes the record and updates the rest.
   *@param fileName This is the records.txt file.
   *@param data This is the two dimensional array containing records.   
   */
   public static void updateFile(String fileName, String data[][]){//records.txt
      try{
         File in = new File(fileName);
         FileOutputStream myout = new FileOutputStream(in);
         DataOutputStream myData = new DataOutputStream(myout);
         for(int i = 0; i<data.length; i++){//update records
            String txt = "";
            if (data[i][0].equals("")) 
               continue; //Omit the record
            for(int j = 0; j<7; j++)
               txt += data[i][j]+"#";
            myData.writeBytes(txt + "\r");
         }
         myout.close();
      } catch(Exception e){}
   }
}