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
    
    public void drawChart(){
        //TODO
    }
    
    public int[] calculateNextCoords(){
        int[] arr = {};
        return arr;
        //TODO
    }
    
    public int calculateNextX(){
        return 0;
        //TODO
    }
    
    public int calculateNextY(){
        return 0;
        //TODO
    }
}
