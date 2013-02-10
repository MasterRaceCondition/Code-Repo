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

public abstract class Chart {
    protected ArrayList<Task> tasks; // read in from project
    protected boolean isValid; //are all the relationships valid? 
    protected int currentX;
    protected int currentY;
    
    public Chart(){
        // default constructor
    }
    
    public Chart(ArrayList tasks){
        this.tasks = tasks; // share the same pointer, allows for dynamic edit
        currentX = 0;
        currentY = currentX; // coords default as 0, 0
        isValid = true; // default as true
        
    }
    
    // --- Accessors ---
    

    public ArrayList<Task> getTasks(){
        return tasks;
    }
    
    public boolean getValidity(){
        return isValid; // only accessor, no mutator, as it's calculated
    }
    
    public int getCurrentX(){
        return currentX;
    }
    
    public int getCurrentY(){
        return currentY;
    }
    
    // --- Mutators ---
    
    public void setTasks(ArrayList<Task> tasks){
        this.tasks = tasks;
    }
    
    public void setCurrentX(int newX){
        currentX = newX;
    }
    
    public void setCurrentY(int newY){
        currentY = newY;
    }
    
    public void setCoords(int newX, int newY){
        currentX = newX;
        currentY = newY;
    }
    
    // --- Abstract Methods ---
    
    protected abstract void drawNode();
    
    protected abstract void drawChart();
    
    protected abstract int[] calculateNextCoords(); // calls calculate nX and calculate nY
    
    protected abstract int calculateNextX();
    
    protected abstract int calculateNextY();
    
}
