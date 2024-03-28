package cc.cyberdark.interfaces;

/**
 * The Prototype interface represents a prototype design pattern, allowing objects to be cloned.
 *
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 * 
 * @param <T> The type of object to be cloned.
 */
public interface Prototype<T> {
    
    /**
     * Creates a deep copy of the object.
     *
     * @return A clone of the object.
     */
    public T Clone();
}
