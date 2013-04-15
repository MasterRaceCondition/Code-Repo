/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vysichart;

/**
 *
 * @author Harry, Todd, Paddy
 */
import java.util.ArrayList;

public abstract class Chart {

    protected ArrayList<Task> tasks; // read in from project
    protected Task currentTask;
    protected boolean isValid; //are all the relationships valid? 
    protected int currentX;
    protected int currentY;

    public Chart() {
        // default constructor
    }

    public Chart(ArrayList<Task> tasks) {
        tasks = new ArrayList<>();
        this.tasks = tasks; // share the same pointer, allows for dynamic edit
        currentX = 0;
        currentY = currentX; // coords default as 0, 0
        // X2 and Y2 not defined, calc depends on chart type
        isValid = true; // default as true
        if (tasks.isEmpty() == false) {
            currentTask = tasks.get(0);
        }
    }

    // --- Accessors ---
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public boolean getValidity() {
        return isValid; // only accessor, no mutator, as it's calculated
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public float getTimeFrame() {
        return 0; // for Gantt
    }

    // --- Mutators ---
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setCurrentX(int newX) {
        currentX = newX;
    }

    public void setCurrentY(int newY) {
        currentY = newY;
    }

    public void setCoords(int newX, int newY) {
        currentX = newX;
        currentY = newY;
        // x2 and y2 calculated respectivley
    }

    public void setTimeFrame(float timeFrame) {
        // empty method for override
    }

    //--- Utility Methods ---
    protected String getString() {
        // string interpretation of class

        // tasks already stored in Project, not needed to be stored



        String validStr = String.valueOf(isValid);
        String curXStr = String.valueOf(currentX);
        String curYStr = String.valueOf(currentY);

        String str = validStr + "\n" + curXStr + "\n" + curYStr;

        return str;

    }

    public ArrayList<Task> getNodesThatDepend(Task t) {
        ArrayList<Task> nodesThatDepend = new ArrayList<Task>();
        for (Task current : tasks) {
            if (current.getDependentNodes().contains(t)) {
                nodesThatDepend.add(current);
            }
        }
        return nodesThatDepend;
    }
}
