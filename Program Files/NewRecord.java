//Filename: NewRecord.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Reads data from "records.txt" and writes it back to the file 
//with the new record.

import java.io.*;

/** Reads data from "records.txt" and writes it back to the file 
*with the new record.
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
class NewRecord{

    /**Uses the information from the external file and writes back 
    *@param fileName  This is the txt file.
    *@param newRec This is the new record that is sent back.*/  
   public static void addRecord(String fileName, String newRec){
      String txt[]=new String[50];
      int count = 0;
      try{
         DataInput f1 = new DataInputStream(new
                             FileInputStream(fileName));
         txt[count] = f1.readLine();
         while(txt[count] != null) {//Read all records from file 
            ++count;
            txt[count] = f1.readLine();
         }
         DataOutput f2 = new DataOutputStream(new
                                FileOutputStream(fileName));
         for(int i=0; i<count; i++)
            f2.writeBytes(txt[i]+"\r\n"); //Write to file 
         f2.writeBytes(newRec); //Insert new record 
      }catch(Exception e) {}
   }//end addRecord    
}//end Newrecord