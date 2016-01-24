import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

   public class LinkListMainclass extends JApplet implements ActionListener  {
   private static final long serialVersionUID = 1L;
   private JButton addBut, addLastBut, addFirstBut,deletFirstBut,deletLastBut ,debugBut, removeBut, sizeBut, exitButton;
   private JPanel buttonPanel;
   private JPanel textPanel;
   private JTable table;
   private final String pData[] []= new String [ 100 ] [ 2 ];
   private final String columnNames[] = {"Record ID", "Node Value" } ;
   private JTextField text1 ;
   private JLabel label1 , label2 ;
   private Container c ;
   private int width = 500, height = 400 , intTextValue ;
   private final LinkedList LL  = new LinkedList() ;
   public  Graphics gVal;
   boolean buttonPressed = false ,  myDebug = false ;
   //Initialization method 
   @Override
    public void init()   {
      c = getContentPane();
      setupText() ;
      setupButtons();
      InitLL() ;
      LL.toArray(  pData ) ;
      table = new JTable( pData, columnNames ) ;
      table.setEnabled( true );
      c.add( table , BorderLayout.CENTER) ;
      c.add( new JScrollPane ( table ) );
      c.validate();

      c.add( textPanel,  BorderLayout.NORTH );
      c.add( buttonPanel, BorderLayout.SOUTH );
   }
   public void setupText() {

      label1= new JLabel("   " + "Enter 1 number.");
      label2= new JLabel("   " + "    ");
      textPanel= new JPanel();
      text1= new JTextField(5);
      textPanel.setLayout(new GridLayout( 1, 3 ) );
      textPanel.add(label1);
      textPanel.add(text1);
      textPanel.add(label2);
      buttonPanel = new JPanel();
      buttonPanel.setLayout( new GridLayout( 1, 7 ) );
      text1.addActionListener( this );
   }
   // Allocate and set up the JButtons 
    // Add the buttons to a JPanel
    // 3- Add an event listner to the buttons 
   public void setupButtons() {

      addBut= new JButton( "Add" );
      addBut.setBackground(Color.CYAN);
      addLastBut= new JButton( "Add Last" );
      addLastBut.setBackground(Color.CYAN);
      addFirstBut= new JButton( "Add First" );
      addFirstBut.setBackground(Color.CYAN);
      debugBut= new JButton( "Debug" );
      debugBut.setBackground( Color.GREEN);
      debugBut.setForeground( Color.white);
      deletFirstBut =new JButton("DeletFirst");
      deletLastBut =new JButton("DeletLast");     
      removeBut= new JButton( "Delete" );
      removeBut.setBackground( Color.MAGENTA);
      removeBut.setForeground( Color.white);
      sizeBut= new JButton( "Get Size" );
      sizeBut.setBackground(Color.WHITE);
      exitButton= new JButton( "Exit" );
      exitButton.setBackground( Color.red);
      exitButton.setForeground( Color.white);

      buttonPanel.add( addBut );
      buttonPanel.add( addLastBut );
      buttonPanel.add( addFirstBut );
      buttonPanel.add( debugBut );
      buttonPanel.add(deletFirstBut);
      buttonPanel.add(deletLastBut);
      buttonPanel.add( removeBut );
      buttonPanel.add( sizeBut );
      buttonPanel.add( exitButton );

      addBut.addActionListener( this );
      addLastBut.addActionListener( this );
      addFirstBut.addActionListener( this );
      debugBut.addActionListener( this );
      removeBut.addActionListener( this );
      sizeBut.addActionListener( this );
      exitButton.addActionListener( this );
   }
    // Initialize the list with some initial values.
   public void InitLL() {
      LL.add(110);
      LL.add(93);
      LL.add(250);
      LL.add(77);
      LL.add(11);
      LL.add(150);
      LL.add(215);
      LL.add(34);
      LL.add(81);
      LL.add(47);
      LL.add(55);
      LL.add(62);
      LL.add(211);
   }
   /* The Redisplay() method is called to redisplay the JTable when the value(s) have changed.
     1- Call the Linked List toArray() method to get the updated entries
     2- Delete the old table 
     3- Create a new table 
     4- Add the new table to the frame context 
     5- Add a scroll pane to this context 
     6- Cause the updated table to show on the screen */
   public void Redisplay() {
      LL.toArray(  pData ) ;
      c.remove( table ) ;
      table = new JTable( pData, columnNames ) ;
      table.setEnabled( true );
      c.add( table , BorderLayout.CENTER) ;
      c.add( new JScrollPane ( table ) );
      c.validate();
   }
    // The actionPerformed( ActionEvent e ) s called when a 
     //GUI event, such as a button being pressed, occurs.
   @Override
    public void actionPerformed( ActionEvent e )  {
      if ( e.getSource() == text1 ) {
         if ( checkFields( e,  addBut, 0 ) )
             checkFieldsChange( e );
            //drawingArea.setCurrentChoice( 0 );
         sysPrint("Textfield processing started.") ;
      }
      else  if ( e.getSource() == addBut ) {
         sysPrint("Add Button processing started.") ;
         buttonPressed = true ;
         if ( checkFields( e,  addBut, 1 ) )
             checkFieldsChange( e );
         LL.add( intTextValue );
         Redisplay() ;
      }
      else if ( e.getSource() == addLastBut ) {
         sysPrint("addLast Button processing started.") ;
         buttonPressed = true ;
         if ( checkFields( e,  addLastBut, 2 ) )
            checkFieldsChange( e );
         LL.addLast( intTextValue );
         Redisplay() ;
      }
      else if ( e.getSource() == addFirstBut ) {
         buttonPressed = true ;
         sysPrint("addFirst Button processing started.") ;
         if ( checkFields( e,  addFirstBut, 3 ) )
                    checkFieldsChange( e );
         LL.addFirst( intTextValue );
         Redisplay() ;
      }
      else if ( e.getSource() == debugBut ) {
         buttonPressed = true ;
         sysPrint("Debug Button processing started.") ;
         myDebug = true ;
      }
      else if ( e.getSource() == removeBut ) {
         sysPrint("remove Button processing started.") ;
         buttonPressed = true ;
         if ( checkFields( e,  removeBut, 4 ) )
                    checkFieldsChange( e ) ;
          LL.Remove( intTextValue );
         Redisplay() ;
      }
      else if ( e.getSource() == sizeBut ) {
         sysPrint("size Button processing started.") ;
         buttonPressed = true ;
         int sizeOfLL = LL.size() - 1 ;
         JOptionPane.showMessageDialog(null,"The size of the linked list is " + sizeOfLL ,
                 "Size of linked list", JOptionPane.INFORMATION_MESSAGE ) ;
      }
      else if ( e.getSource() == exitButton ) {
         buttonPressed = true ;
         sysPrint("exitButton processing started.") ;
         sysExit( 0 );
      }
   }
   // sysPrint() - is used for debugging
   public void sysPrint( String str  )   {
      if ( myDebug ) {
         System.out.println( str );
      }
   }

   //Set the width of frame to 600 if w less than 0.
   public void setWidth( int w )
      { width = ( w >= 0 ? w : 600 ); }

   //Set the height to 600 if h less than 0 
   public void setHeight( int h )
      { height = ( h >= 0 ? h : 400 ); }

   //Make sure that the data entered is a digit 
   public boolean  checkDigit(String strVal) {

       int strLength = 0;
       boolean notDig = true;

       strLength = strVal.length();

       for (int ii = 0; ii < strLength; ii++) {
          if (!Character.isDigit(strVal.charAt(ii)) ) {
             notDig = false;
             break;
          }
       }
       return notDig;
   }

   //Check if data in the text fields has changed 
   public void checkFieldsChange( ActionEvent e ) {
       
   }
   //Retrieve data from the text fields 
   public int getTextValues() {
      return Integer.parseInt( text1.getText() );
   }

   // Ensure that the data is not null 
   public boolean checkFields( ActionEvent e, JButton choice, int i ) {
      boolean checkedOK = false;

      if ( text1.getText().equals("")     ) {
         JOptionPane.showMessageDialog(null, "Please enter a valid whole number.\n",
                 "Invalid Number", JOptionPane.ERROR_MESSAGE ) ;
      }
      else if( !checkDigit( text1.getText())  ) {
         JOptionPane.showMessageDialog(null, "Please enter a valid whole number.\n" +
                 "\"" + text1.getText() + "\" is not a valid number.","Invalid Number", JOptionPane.ERROR_MESSAGE ) ;
      }
      else {
         intTextValue  = getTextValues() ;
         checkedOK = true;
         if ( !buttonPressed ) {
             buttonPressed = false ;
             JOptionPane.showMessageDialog(null,"Please press a button.\n" , "No Button", JOptionPane.INFORMATION_MESSAGE ) ;
         }
      }
      return checkedOK;
   }
   public void sysExit( int a ) {
      System.exit( a );
   }
   @SuppressWarnings("deprecation")
public static void main( String args[] )   {
      int width = 790, height = 550;
      // create window in which applet will execute
      JFrame appMain =
         new JFrame( "Linked List Application" );

      appMain.addWindowListener(
         new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e )
            {
               System.exit(0);
            }
         }
      );

      //create one applet instance 
      LinkListMainclass appBar = new LinkListMainclass();
      appBar.setWidth( width );
      appBar.setHeight( height );
      
      //call applet's init and start methods 
      appBar.init();
      appBar.start();

      /** attach applet to center of window */
      appMain.getContentPane().add( appBar );

      //set the window's size .
      appMain.setSize( appBar.width, appBar.height );
      appMain.show();
   }
}





