//Filename: Records.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: It seperates each line of record into 7 component parts.
//Each item is stored seperately in a two dimensional array, records.

import java.util.StringTokenizer;

/** Obtains a one dimensional string array called data, 
*and breaks each line of the record into parts which get stored into 
*a two dimensional array, records.
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */

class Records {//Seperate a line of record into 7

   /**Constructs a two dimensional array.
       *@param data This is a one dimensional array containing the records.
       *@return a two dimensional array, records
       */
   public String[][] getRecords(String data[]){
      int n = data.length;
      String records[][] = new String[n][7];//Store records in 2 dimensional array 
      for (int p = 0; p<n; p++)//Intialize all records
         for (int q = 0; q<7; q++)
            records[p][q]="";
      for (int line = 0; line<n; line++){
         if (data[line].equals("")) 
            break;
         StringTokenizer st = new StringTokenizer(data[line], "#");
         int i = 0;
         while (st.hasMoreTokens() &&i<7){
            records[line][i] = st.nextToken(); //Store each item of the record
            System.out.print(records[line][i] + "\t\t");
            i++;
         }//end while 
         System.out.println();
      }//end for 
      System.out.println("\n");
      return records; //Return the 2-dimensional array records 
   } // end getRecords
} //end Records