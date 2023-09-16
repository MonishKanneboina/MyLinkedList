public class MyLinkedList
{
   private int size;
   private ListNode head, tail;
   
   
   private class ListNode
   {
      int val;
      ListNode next;
      
      public ListNode (int val) 
      {
         this.val = val; 
      }
   }
      
   public MyLinkedList()
   {
      head = null;
      tail = null;
      size = 0;
   }
      
   public MyLinkedList(int val)
   {
      head = new ListNode(val);
      tail = head;
      size++;      
   }
   
   public void add(int newVal)
   {
      ListNode current = head;
      ListNode temp = new ListNode(newVal);
         
      if (current == null)
      {
         head = temp;
         tail = temp;
         size++;
         return;
      }
        
      tail.next = temp;
      tail = temp;
      size++;
      
   }
   
   public boolean contains(int target)
   {
      ListNode current = head;
      if (current.val == target)
      {
         return true;
      }
         
         
      while (current.next != null)
      {
         current = current.next;
      
         if (current.val == target)
         {
            return true;
         }
              
      }
         
      return false;
   }
   
   public int get(int index)
   {
      int num = 0;
      ListNode current = head;
      if(indexOf(current.val) == index)
      {
         num = current.val;
      }
      while(current.next != null)
      {
         current = current.next;
         if(indexOf(current.val) == index)
         {
            num = current.val;
         }
      }
      if(index >= size)
      {
         throw new IndexOutOfBoundsException();
      }
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }      
      return num;    
   }

   
   public int indexOf(int target)
   {
      int i = 0;
      int indexOfTarget = 0;
      ListNode current = this.head;
      if(contains(target) == false)
      {
         return -1;
      }
      if(current.val == target)
      {
         return 0;
      }
      while(current.next != null)
      {
         current = current.next;
         i++;
         if(current.val == target)
         {
            indexOfTarget = i;
            break; // will stop at the first index of the target 
         }
      } 
      return indexOfTarget; 
   
   }
   
   public void set(int newVal, int index)
   {
        
      ListNode current = head;
      if(indexOf(current.val) == index)
      {
         current.val = newVal;
      }
      while(current.next != null)
      {
         current = current.next;
         if(indexOf(current.val) == index)
         {
            current.val = newVal;
            break;
         }
      }
      if(index >= size)
      {
         throw new IndexOutOfBoundsException();
      
      }
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      
      }
     
   }
  
  
   public int size()
   {
      return size;
   }
   
   
   public int sizeRecursive()
   {
      return sizeRecursive(head);
   } 
  
   public int sizeRecursive(ListNode current)
   {
      return 1 + sizeRecursive(current.next);
   } 
   
   public boolean isEmpty()
   {
      return size == 0;
   }
   
   
   public int remove(int index)
   {
  
      int num = get(index);
      ListNode current = head;
      ListNode temp = tail;
     
      if(indexOf(current.val) == index)
      {
         head = current.next;
         size--;
         return num;
      }
      
     else {
      for (int i = 0; current.next != null && i < index - 1; i++)
         {
            current = current.next;
         }
            
            
      ListNode after = current.next.next;
      current.next = after;
      if (index == size - 1)
         {
            tail = current;
         }
      size--;
      }
      
      if(index > size)
      {
         throw new IndexOutOfBoundsException();
      }
      if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }      
      return num;    
   }
  
  public void add(int newVal, int index)
   {
      ListNode current = head;
      ListNode n = new ListNode(newVal);
      ListNode temp = tail;
      
      if (index == 0)
         {
             if(size == 0)
               {
                  add(newVal);
                  return;
               }
               
             n.next = head;
             head = n;
             size++;
             return;
         }
      if (index == size)
         {
            add(newVal);
            return;
         }
      
      while (current.next != null)
         {
              for (int i = 0; current.next != null && i < index - 1; i++)
            {
               current = current.next;
            }
            
            n.next = current.next;
            current.next = n;
            size++;
            break;
         }    
         
       if(index < 0)
      {
         throw new IndexOutOfBoundsException();
      }
   }
   
   @Override
   public String toString()
   {
      if(size == 0)
      {
         return "[]";     
      }
         
      String s = "["; 
      ListNode current = head;
         
      while (current.next != null)
      {
         s += current.val + ", ";
         current = current.next;     
      }
      
      s += current.val + "]";
      
      return s;
         
         
   }
}