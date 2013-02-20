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
        
public class PERT extends Chart {
    
       public PERT() {
        //default constructor
    }

    public PERT(ArrayList<Task> tasks) {
        super(tasks); // calls constructor from chart
    }
    

    
    
    public ArrayList<Task> getCriticalPath(){
        //TODO
        return null;
    }
     
}
