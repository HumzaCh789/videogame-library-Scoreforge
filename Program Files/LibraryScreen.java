//Filename: LibraryScreen.java 
//Authors: Alex Bangu, Costa Giannaras, Humza Chaudhry
//Date: June 9, 2023  
//Description: Generates the Library screen which allows user to search, sort,
//add, and delete records.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/** Generates the library screen from the opening screen
*@author Alex Bangu, Costa Giannaras, Humza Chaudhry */
public class LibraryScreen extends JFrame implements ActionListener {

   /**Search bar textfield */
   private JTextField searchBar;
   
   /**Sort by combo box */
   private JComboBox sortByComboBox;
   
   /**Table which displays all the records */
   private JTable tableList;
   
   /**Back to home button */
   private JButton backButton;
   
   /**Add record button */
   private JButton addRecord;
   
   /**Delete record button */
   private JButton delRecord;
   
   
   /**Name of file holding records */
   static String fileName = "records.txt";
   
   /**Integer to limit the amount of records that can be stored */
   final int MAX = 20;
   
   /**Array holding header values for tableList */
   String[] header = { "Name", "Studio", "Release Date", "Rating" };
   
   /**Array used in the creation of the info array */
   String rows[] = new String[MAX];
   
   /**Array used to populate tableList */
   String info[][] = new String[MAX][7];
   
   /**Array that holds the result of a search */
   String searchResult[][] = new String[MAX][7];
   
   /**Read Data object */
   ReadData rd = new ReadData();
   
   /**Records object */
   Records re = new Records();
   
   /**Sorter object */
   Sorter s = new Sorter();
   
   /**Searchinput object */
   SearchInput si = new SearchInput();
   
   /**Creates the library screen. */
   public LibraryScreen() {
      initialize();
      rows = rd.readFile(fileName, 20);
      info = re.getRecords(rows);
      
      JPanel outerPanel = 
         new JPanel(new BorderLayout()) // Outer panel for margin
         {
            protected void paintComponent(Graphics g) //paints the graphics when the panel is made
            {
               super.paintComponent(g);
               drawBackground(g);
            }
         };
      outerPanel.setBorder(new EmptyBorder(0, 300, 0, 300)); // Add 300-pixel margin on each side
   
      JPanel libraryPanel = new JPanel(new FlowLayout()); // Use FlowLayout for horizontal positioning
      
      
      String[] header = { "Name", "Studio", "Release Date", "Rating" };
      
      tableList = 
         new JTable(info, header) {
            public boolean isCellEditable(int nRow, int nCol) {
               return false;
            }
         };
         
      JScrollPane scrollPane = new JScrollPane(tableList);
      
   
      // Create the search bar
      searchBar = new JTextField();
   
      // Search bar initial settings
      JLabel searchLabel = new JLabel("Search:");
      searchBar.setPreferredSize(new Dimension(150, searchBar.getPreferredSize().height));
      searchBar.addActionListener(this);
   
      // Create the sort by combo box
      String[] sortOptions = { "Name", "Studio", "Release Date", "Rating" };
      sortByComboBox = new JComboBox<>(sortOptions);
      sortByComboBox.addActionListener(this);
      
      // Create button panel for the "Back to Home" button
      JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      backButton = new JButton("Back to Home");
      backButton.addActionListener(this);
      addRecord = new JButton("Add record");
      addRecord.addActionListener(this);
      delRecord = new JButton("Delete record");
      delRecord.addActionListener(this);
      buttonPanel.add(backButton);
      buttonPanel.add(addRecord);
      buttonPanel.add(delRecord);
   
      libraryPanel.add(searchLabel); // Add search label to the panel
      libraryPanel.add(searchBar); // Add search bar to the panel
      libraryPanel.add(new JLabel("Sort by:")); // Add a sort label in front of the combo box
      libraryPanel.add(sortByComboBox); // Add combo box to the panel
      
      scrollPane.add(libraryPanel);
   
      //add(libraryPanel, BorderLayout.NORTH); // Add the panel to the JFrame
      add(scrollPane, BorderLayout.CENTER); // Add the table to the JFrame
      add(buttonPanel, BorderLayout.SOUTH); // add the button panel to the JFrame
      
      outerPanel.add(libraryPanel, BorderLayout.NORTH); // Add the panel to the outer panel
      outerPanel.add(scrollPane, BorderLayout.CENTER); // Add the table to the outer panel
   
      add(outerPanel); // Add the outer panel to the JFrame
      
      tableList.addMouseListener( // Action listener that watches for when a table element is clicked
         new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            
               int row = tableList.getSelectedRow();
               
               String selGameName = info[row][0];
               String selGameStudio = info[row][1];
               String selGameRelease = info[row][2];
               String selGameRating = info[row][3];
               String selGameDes = info[row][4];
               String selGameBg = info[row][5];
               String selGameTh = info[row][6];
               System.out.println(info[row][5]);
               
               GameScreen gameScreen = new GameScreen(selGameName, selGameStudio, selGameRelease, selGameRating, selGameDes, selGameBg, selGameTh);
               gameScreen.setVisible(true);
               dispose(); // Close the current LibraryScreen
              
               
            }
         });
   }
   
   /**Sets screensize, name, and makes the x button work  */
   private void initialize() { //a method that sets screensize, name, and makes x button work
      setTitle("SCOREFORGE");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(1280, 720);
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null); //centres screen
   }
   
   /**Creates graphics for the library screen */
   private void drawBackground(Graphics g)
   {        
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image background = tk.getImage("mainpage_background.png"); //Background photo for homescreen.
      g.drawImage(background, 0, 0, this);
     
      ImageIcon logoIcon = new ImageIcon("scoreforge.png"); // logo image
      Image scaledLogoImage = logoIcon.getImage().getScaledInstance(-1, 50, Image.SCALE_SMOOTH);
      ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
      g.drawImage(scaledLogoImage,0,0,this);
      
      
   }
   
   /**Listens for action events and reacts to them  */
   public void actionPerformed(ActionEvent e) {
      
      //back button listener
      if (e.getSource() == backButton) 
      {
         OpeningScreen openingScreen = new OpeningScreen();
         openingScreen.setVisible(true);
         dispose(); // Close the current LibraryScreen
      }
      
      // add record listener
      if (e.getSource() == addRecord) 
      {
         GameInputPage addScreen = new GameInputPage();
         addScreen.setVisible(true);
         dispose(); // Close the current LibraryScreen
      }
      
      // delete record listners
      if (e.getSource() == delRecord) 
      {
         DeletePage delScreen = new DeletePage(info);
         delScreen.setVisible(true);
         dispose(); // Close the current LibraryScreen
      }
      
      // search listener
      if (e.getSource() == searchBar) {
         String searchText = searchBar.getText();
         String info2[][] = new String[1][7];
         info2 = si.keyInput(fileName, info, searchText, 0);
         if(info2[0][0] != null) {
         
            String selGameName = info2[0][0];
            String selGameStudio = info2[0][1];
            String selGameRelease = info2[0][2];
            String selGameRating = info2[0][3];
            String selGameDes = info2[0][4];
            String selGameBg = info2[0][5];
            String selGameTh = info2[0][6];
            System.out.println(info2[0][5]);
            
            GameScreen gameScreen = new GameScreen(selGameName, selGameStudio, selGameRelease, selGameRating, selGameDes, selGameBg, selGameTh);
            gameScreen.setVisible(true);
            dispose(); // Close the current LibraryScreen
         
         }
      }
      
      // sort listeners
      if (e.getSource() == sortByComboBox) { 
         if (sortByComboBox.getSelectedIndex() == 0) {
            System.out.println("Sorting by name!");
            info = s.sort(info, 0);
         } else if (sortByComboBox.getSelectedIndex() == 1) {
            System.out.println("Sorting by studio!");
            info = s.sort(info, 1);
         } else if (sortByComboBox.getSelectedIndex() == 2) {
            System.out.println("Sorting by release date!");
            info = s.sort(info, 2);
         } else if (sortByComboBox.getSelectedIndex() == 3) {
            System.out.println("Sorting by rating!");
            info = s.sort(info, 3);
         }
         tableList.repaint();
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(
         () -> {
            new LibraryScreen();
         });
   }
}
