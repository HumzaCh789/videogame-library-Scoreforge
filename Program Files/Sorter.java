//Filename: Sorter.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: It sorts all the records by Names(0), Studio(1), Release Date(2) and Rating(5).


/** It sorts all the records by Names(0), Studio(1), Release Date(2) and Rating(5).
*These are provided by the two dimensional array, list. 
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
class Sorter{

   /**Sorts the records provided by certain criteria like Names.
   *@param list This is a two dimensional array containing the records.
   *@param item The criteria used to sort.*/
   public static String[][] sort (String list[][], int item) {//Input records; Item = name etc
      String temp;
      int len = list.length - 1;
      for(int i=len;i>1;i--)
         for(int j=0;j<i;j++)
            if(list[j][item].compareTo(list[j+1][item])>0){
               for(int k=0; k<7;k++)
                  if(list[j+1][item] != "")
                     swap(list, j, k);
                  else
                     break; //swapping all 4 items
            }//end if
      return list; //return sorted list 
   }// end sort
     
     /**Swaps the order of the records in the two dimension array, list based off the item.
     *@param list This is a two dimensional array containing the records.
     *@param item The criteria used to sort.
     *@param index The place where the record is */
   static void swap(String list[][], int index, int item){
      String temp;
      temp = list[index][item];
      list[index][item] = list[index + 1][item];
      list[index+1][item] = temp;
   }//end swap
} //end Sorter