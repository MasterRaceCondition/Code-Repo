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
    protected int currentX1; // 
    protected int currentY1; // top left coords
    protected int currentX2; // bottom right coords
    protected int currentY2; //
    
    public Chart(){
        // default constructor
    }
    
    public Chart(ArrayList<Task> tasks){
        tasks = new ArrayList<Task>();
        this.tasks = tasks; // share the same pointer, allows for dynamic edit
        currentX1 = 0;
        currentY1 = currentX1; // coords default as 0, 0
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
        return currentX1;
    }
    
    public int getCurrentY1(){
        return currentY1;
    }
    
    public int getCurrentX2(){
        return currentX2;
    }
    
    public int getCurrentY2(){
        return currentY2;
    }
    
    // --- Mutators ---
    
    public void setTasks(ArrayList<Task> tasks){
        this.tasks = tasks;
    }
    
    public void setCurrentX1(int newX){
        currentX1 = newX;
    }
    
    public void setCurrentY1(int newY){
        currentY1 = newY;
    }
    
    public void setCurrentX2(int newX){
        currentX2 = newX;
    }
    
    public void setCurrentY2(int newY){
        currentY2 = newY;
    }
    
    public void setCoords(int newX, int newY){
        currentX1 = newX;
        currentY1 = newY;
        // x2 and y2 calculated respectivley
    }
    
    // --- Abstract Methods ---
    
    protected abstract void drawNode();
    
    protected abstract void drawChart();
    
    protected abstract void getNextCoords(); // calls calculate nX and calculate nY
    
    
}
