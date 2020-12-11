/**
 * Thrown to indicate that an argument to a Graph
 * method specified a non-existent vertex. 
 * 
 * @author sspurlock
 * @version 2019-10-21
 */
public class IllegalVertexException
    extends IllegalArgumentException {

    /**
     * Construct a new IllegalVertexException with the
     * specified detail message.
     *
     * @param s the detail message associated with this
     *          IllegalVertexException.
     */
    public IllegalVertexException(String s) {
	   super(s);
    }
}