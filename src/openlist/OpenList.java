package openlist;

/**
 * OpenList is a class designed to provide capabilities similar to
 * list structures in Racket. This version is fully polymorphic,
 * in that any Object can be a list element.
 * 
 * @author Robert Keller
 */

public class OpenList
{
    /**
     * the first thing in this list
     */
    
    private Object First;
    
    
    /**
     * the list of all but the first thing in this list.
     */
    
    private OpenList Rest;
    
    
    /**
     * nil represents the one-and-only empty list
     */
    
    public static OpenList nil = cons(null, null);
    
    
    /**
     * Construct an OpenList. This is not intended
     * for public use. Use the pseudo-constructor cons instead.
     * @param First the first thing in this list
     * @param Rest the list of all but the first thing in this list
     */
    
    private OpenList(Object First, OpenList Rest)
      {
        this.First = First;
        this.Rest = Rest;
      }
    
    
    /**
     * @param First the first thing in the result list
     * @param Rest the list of all but the first thing in the result list
     * @return a list consisting of First followed by the elements of Rest
     */
    
    public static OpenList cons(Object First, OpenList Rest)
      {
        return new OpenList(First, Rest);
      }
    
    
    /**
     * @return the first thing in this list
     */
    
    public Object first()
      {
        return First;
      }
    
    
    /**
     * @return the list of things in this list after the first
     */
    public OpenList rest()
      {
        return Rest;
      }
    
    
    /**
     * @return true if this list is empty
     */
    
    public boolean isEmpty()
      {
        return this == nil;
      }
    
   /**
    * 
    * @return if this list is non-empty
    */
   public boolean nonEmpty()
      {
        return this != nil;
      }

   
   /**
    * @return a String representation of this list
    */
    @Override
    public String toString()
      {
        StringBuilder buffer = new StringBuilder();
        
        buffer.append("(");
        
        OpenList L = this;
        
        if( L.nonEmpty() )
            {
            buffer.append(L.first());
            L = L.rest();
            }
        
        for( ; L.nonEmpty(); L = L.rest())
            {
            buffer.append(" ");
            buffer.append(L.first());
            }
        
        buffer.append(")");
        
        return buffer.toString();
      }
    
    
/**
 * a test program
 */
    public static void main(String[] arg)
      {
        OpenList L = cons(1, cons(2, cons(3, nil)));
        OpenList M = cons("abc", cons(L, L));
        
        System.out.println("M = " + M);
      }
    
    
}
