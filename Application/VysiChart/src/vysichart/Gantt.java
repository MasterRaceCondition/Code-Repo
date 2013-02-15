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
    private int boxLength; // relies on current tasks duration

    public Gantt() {
        //default constructor
    }

    public Gantt(ArrayList<Task> tasks) {
        super(tasks); // calls constructor from chart
        currentY2 = 50; //default box height
        boxLength = 2 * (int)currentTask.getTaskDuration(); // 2 is 'multiplier'
        currentX2 = currentX1 + boxLength;
    }
    
    public void drawNode(){
        //TODO
    }
    
    public void drawChart(){
        //TODO
    }
    
    public void getNextCoords(){
        int newY1 = currentY2; 
        int newY2 = currentY2 + 50; // 50 is default box height
        int newX1 = 0; // will equal currentTask.endDate (int somehow)
        int newX2 = newX1 + boxLength;
        // update attributes
        currentX1 = newX1;
        currentX2 = newX2;
        currentY1 = newY1;
        currentY2 = newY2;
        
        //TODO
    }
    

  
}
