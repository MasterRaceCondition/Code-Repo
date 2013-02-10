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
    private float timeFrame; //total timeframe (in hrs), calculated from tasks
    private boolean isValid; //are all the relationships valid? 
    private int currentX;
    private int currentY;
    
    public Chart(){
        // default constructor
        currentX = 0;
        currentY = currentX; // coords default as 0, 0
        isValid = true; // default as true
        
    }
    
    // --- Accessors ---
    
    public float getTimeFrame(){ // only accessor, no mutator, as it's calculated
        return timeFrame;
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
