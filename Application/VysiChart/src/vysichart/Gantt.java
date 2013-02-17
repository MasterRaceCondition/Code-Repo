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

    private int boxLength; // relies on current tasks duration/timeFrame
    private float timeFrame;
    private int currentX2; // bottom right coords
    private int currentY2;

    public Gantt() {
        //default constructor
    }

    public Gantt(ArrayList<Task> tasks) {
        super(tasks); // calls constructor from chart
        currentY2 = 50; //default box height
        boxLength = 2 * (int) currentTask.getTaskDuration(); // 2 is 'multiplier'
        currentX2 = currentX + boxLength;
    }

    public Gantt(ArrayList<Task> tasks, float timeFrame) {
        super(tasks); // calls constructor from chart
        this.timeFrame = timeFrame;
        currentY2 = 50; //default box height
        if (tasks.isEmpty() == false) { // no tasks
            boxLength = 2 * (int) currentTask.getTaskDuration(); // 2 is 'multiplier'
        }
        currentX2 = currentX + boxLength;
    }
    @Override
    public void drawNode() {
        //TODO
    }
    @Override
    public void drawChart() {
        //TODO
    }

    public void getNextCoords() {
        int newY1 = currentY2;
        int newY2 = currentY2 + 50; // 50 is default box height
        int newX1 = 0; // will equal currentTask.endDate (int somehow)
        int newX2 = newX1 + boxLength;
        // update attributes
        currentX = newX1;
        currentX2 = newX2;
        currentY = newY1;
        currentY2 = newY2;

        //TODO 
    }
}
