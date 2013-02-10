/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vysichart;

/**
 *
 * @author Harry, Todd
 */
import java.util.ArrayList;

public class Gantt extends Chart {

    public Gantt() {
        //default constructor
    }

    public Gantt(ArrayList<Task> tasks) {
        super(tasks); // calls constructor from chart
    }
    
    public void drawNode(){
        //TODO
    }
    
    
}
