/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vysichart;

/**
 *
 * @author Harry
 */

import java.util.ArrayList;

public class Project {
    
    private ArrayList<Task> tasks; //ALL the tasks, they're fed through to Chart
    private Chart gantt;//    \
    private Chart pert;//     |  ALL the charts
    private Chart wbt;//      /
    private String name; //name of project
    private String filePath; // file path for save/load
    private float timeFrame; //total timeframe (in hrs), calculated from tasks (used to be in Chart)
    
    public Project(){
        // default constructor
    }
    
    public Project(String name, String filePath){
        tasks = new ArrayList<Task>(); // init
        gantt = new Gantt(); // init
        pert = new PERT(); // init
        wbt = new WBT(); // init
        
        this.name = name; // read in
        this.filePath = filePath; // read in
        
        timeFrame = 0; // 0 tasks = 0 timeFrame
        
    }
    
    // --- accessors ---
    
    public ArrayList<Task> getTasks(){
        return tasks;
    }
    
    public Chart getGantt(){
        return gantt;
    }
    
    public Chart getPERT(){
        return pert;
    }
    
    public Chart getWBT(){
        return wbt;
    }
}
