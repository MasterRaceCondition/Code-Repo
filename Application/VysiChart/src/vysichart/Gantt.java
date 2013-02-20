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

    private int boxLength; // calculated by the ratio of taskDuraion / timeFrame
    private float timeFrame;

    public Gantt() {
        //default constructor
    }

    public Gantt(ArrayList<Task> tasks) {
        super(tasks); // calls constructor from chart
        boxLength = 2 * (int) currentTask.getTaskDuration(); // 2 is 'multiplier'
    }

    public Gantt(ArrayList<Task> tasks, float timeFrame) {
        super(tasks); // calls constructor from chart
        this.timeFrame = timeFrame;
        if (tasks.isEmpty() == false) { // no tasks
            boxLength = 2 * (int) currentTask.getTaskDuration(); // 2 is 'multiplier'
        }
    }


    
    public void getNextCoords() {
        int newY1 = currentY + 50; // 50 is default box height
        int newX1 = 0; // will equal currentTask.endDate (int somehow)
        // update attributes
        currentX = newX1;
        currentY = newY1;

        //TODO 
    }

    @Override
    public String getString() {
        // Gantt has other stuff
        String str = super.getString();
        String boxLengthStr = String.valueOf(boxLength);
        // timeFrame is contained in Project
        
        str += "\n" + boxLengthStr;

        return str;
    }
}
