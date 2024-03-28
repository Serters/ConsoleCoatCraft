package cc.cyberdark.interfaces;

/**
 * The Renderable interface represents an object that can generate and display its graphical representation.
 *
 * @author github.com/Serters
 * @author github.com/DaniloIvk
 * @version 1.1
 * @since 1.0
 */
public interface Renderable {
    
    /**
     * Generates the graphical representation of the object.
     *
     * @return An array of strings representing the graphical representation.
     */
    public String[] generate();
    
    /**
     * Displays the graphical representation of the object.
     */
    public void display();
    
    /**
     * Provides information about the object.
     */
    public void info();
}
