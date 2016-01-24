import javax.swing.JOptionPane;

public class LinkedList {
   public int value;              // value of element
   public LinkedList next;        // reference to next
   private LinkedList head = null , last ;
   private final boolean myDebug ;
   
    // constructor
   public LinkedList() {
        this.myDebug = true;
      // initialize list head
      if ( head == null ) {
         head = new LinkedList( 0 , head ) ;
      }
   }
    // constructor LinkedList( LinkedList ln )
   public LinkedList( int num, LinkedList ln ) {
        this.myDebug = true;
      this.value = num ;
      //this.next = ln.next;
   }
    // sysPrint() - is used for debugging
   public void sysPrint( String str  )   {
      if ( myDebug ) {
         System.out.println( str );
      }
   }
   // Initialized add( int num )
    //add method Adds a value to the list in sorted order.
   public void add( int num ) {
      LinkedList NewNode, NodeRef, PreviousNode = null ;
      // Allocate a new node & store Num
      NewNode = new LinkedList();
      NewNode.value = num;
      
      PreviousNode = NewNode ;
        //If there are no nodes in the list... make NewNode the first node
      if ( head == null )  {
         head.next = NewNode ;
         NewNode.next = null ;
      }
      else if ( head.value > num ) {
         NewNode.next = head.next ;
         head.next = NewNode ;
      }
      else	{   
         // Otherwise, insert NewNode at end          
         //  Initialize NodeRef to head of list           
         NodeRef = head;
           // Skip all nodes whose Value member is less than Num.
         while (NodeRef != null && NodeRef.value < num)  {
            PreviousNode = NodeRef ;
            NodeRef = NodeRef.next;
         }
 	 /*
           Insert the node after the one pointed to
	   by PreviousNode and before the one pointed to
	   by NodePtr.  */          
         PreviousNode.next = NewNode;
         NewNode.next = NodeRef ;
      }
   }
    // Inisialized addLast( int num )
    //addLast method Adds a node containing the value passed  in num, to the end of the list.
   void addLast( int num) {
      LinkedList NodeRef, NewNode ;
      NodeRef = head;
      NewNode = new LinkedList();
      NewNode.value = num;
      NewNode.next = null ;
     
       // If  no nodes found in the list
       // make NewNode the first node
      if ( head == null )
         head = NewNode;
      else	{ 
          // insert NewNode at end
           // Initialize NodePtr to head of list
         NodeRef = head;

           // Find the last node in the list
         while ( NodeRef.next != null )
            NodeRef = NodeRef.next;

              // Insert NewNode as the last node
         NodeRef.next = NewNode;
      }
   }
    //Inisialized addFirst( int num ) mehtod
     //addFirst method Adds a value to the beginning of the list.
   public void addFirst( int num ) {
      LinkedList NodeRef, NewNode ;

      NewNode= new LinkedList() ;
      NewNode.next = head.next ;
      NewNode.value  =  num ;
      head.value= NewNode.value  ;
      head.next= NewNode ;
   }
    //Inisialized  DisplayLL() method
   public void DisplayLL() {
      LinkedList NodeRef ;
      NodeRef = head;

      // list all entries
      while (NodeRef != null) {
         System.out.println(NodeRef.value);
         NodeRef = NodeRef.next;
      }
   }
    // Inisialized Remove(int num) method 
   public boolean Remove(int num) {
      LinkedList NodeRef, PreviousNode = null;
      boolean found = false ;

      /** If the list is empty, do nothing.  */
      if ( !(head == null) ) {
         NodeRef = head ;

	 /** Determine if the first node is the one. */
         if (NodeRef.value == num) {
            head = NodeRef.next;
            found = true ;
         }
         else {
            /** Initialize NodeRef to head of list */
            NodeRef = head;
             //Skip all nodes whose value member is not equal to num.
            while (NodeRef != null  ) {
               if ( NodeRef.value != num ) {
                  PreviousNode = NodeRef;
                  NodeRef = NodeRef.next;
               }
               else {                 
                  // Link the previous node to the node after .. NodeRef, then delete NodeRef.
                   
                  PreviousNode.next = NodeRef.next;    
                  
                  System.out.println("\nThe number " + num + " sought has been found.\n") ;
                  break ;
               } 
            }  
           
         } 
      } 
       return false;    
  }
    // Inisialized  isEmpty() method 
    // its Determine if the linked list is empty. 
   public boolean isEmpty() {
      boolean ret ;

      if ( head == null ) {
         ret = false ;
      }
      else {
         ret = true ;
      }

      return ret ;
   }
    //Inisialized  contains( int num ) method
    // Purpose: Determine if the linked list contains the passed parameter.        
   public boolean contains( int num ) {
      LinkedList NodeRef, PreviousNode = null;
      boolean ret = false ;
      int a ;
      /** If the list is empty, do nothing.  */
      if ( !(head == null) ) {
         NodeRef = head ;	 
          // Skip all nodes whose value member is not equal to num.
          while (NodeRef != null  ) {
             if ( NodeRef.value != num ) {
                PreviousNode = NodeRef;
                NodeRef = NodeRef.next;
             }
             else {
                ret = true ;
                System.out.println("\nThe number " + num + " sought has been found.\n") ;
                break ;

            } 
         }  
      }  

      return ret ;
   }
    //Inisialized toArray(int a[]) method
    //its Returns an array containing all of the  elements in this list in the correct order.
   public void toArray(String a[][] ) {
      LinkedList NodeRef, PreviousNode = null;
      int ii = 0 ;
      /** If the list is empty, do nothing.  */
      if ( !(head == null) ) {
         NodeRef = head.next ;
          //Skip all nodes whose value member is not equal to num.
          while (NodeRef != null  ) {
             a[ ii ][ 0 ] = String.valueOf( ii ) ;
             a[ ii ][ 1 ] = String.valueOf( NodeRef.value ) ;
             ii++;
             NodeRef = NodeRef.next;

         }  
      }  

   }
    // Inisialized getLast() mehtod
    //its Return the last logical number in the linked list 
 public int getLast() {
      LinkedList NodeRef = null , PreviousNode = NodeRef ;
      int ret ;
      /** If the list is empty, do nothing.  */
      if ( !(head == null) ) {
         NodeRef = head ;

         while (NodeRef != null  ) {
            PreviousNode = NodeRef;
            NodeRef = NodeRef.next;
         }

         ret = PreviousNode.value ;
      }
      else {
         ret = -99999 ;
      }
      return  ret ;
   }  
   // Inisialized size() mehtod
   // its Returns the size of the linked list.         
   public int size() {
      LinkedList NodeRef, PreviousNode = null;
      int ret = 1 ;
      /** If the list is empty, do nothing.  */
      if ( (head != null) ) {
         NodeRef = head ;
         while (NodeRef.next != null  ) {
            NodeRef = NodeRef.next;
            ret++;
         } 
      }  
      else {
         JOptionPane.showMessageDialog( null, "The linked list is empty.","Empty linked list",JOptionPane.INFORMATION_MESSAGE ) ;
      }

      return ret  ;
   }
}

