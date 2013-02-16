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
    
    public Chart(){
        // default constructor
    }
    
    public Chart(ArrayList<Task> tasks){
        tasks = new ArrayList<Task>();
        this.tasks = tasks; // share the same pointer, allows for dynamic edit
        currentX = 0;
        currentY = currentX; // coords default as 0, 0
        // X2 and Y2 not defined, calc depends on chart type
        isValid = true; // default as true
        currentTask = tasks.get(0);
        
    }
    
    // --- Accessors ---
    

    public ArrayList<Task> getTasks(){
        return tasks;
    }
    
    public boolean getValidity(){
        return isValid; // only accessor, no mutator, as it's calculated
    }
    
    public int getCurrentX1(){
        return currentX;
    }
    
    public int getCurrentY1(){
        return currentY;
    }
    
    public int getCurrentX2(){
        return currentX;
    }
    
    public int getCurrentY2(){
        return currentY;
    }
    
    // --- Mutators ---
    
    public void setTasks(ArrayList<Task> tasks){
        this.tasks = tasks;
    }
    
    public void setCurrentX1(int newX){
        currentX = newX;
    }
    
    public void setCurrentY1(int newY){
        currentY = newY;
    }
    
    public void setCurrentX2(int newX){
        currentX = newX;
    }
    
    public void setCurrentY2(int newY){
        currentY = newY;
    }
    
    public void setCoords(int newX, int newY){
        currentX = newX;
        currentY = newY;
        // x2 and y2 calculated respectivley
    }
    
    // --- Abstract Methods ---
    
    protected abstract void drawNode();
    
    protected abstract void drawChart();
    
    
    
}
