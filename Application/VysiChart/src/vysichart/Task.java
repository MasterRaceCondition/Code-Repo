
package vysichart;

import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Harry, Todd
 */
public class Task {
    private String taskName, taskNumber;
    private int taskId;
    
    //The level of the task in the tree (the parent's level plus one).
    private int taskLevel;
    private Task taskParent;
    
    //An array of all nodes that need to be done before this task.
    private Task[] dependentNodes;
    private Date startDate, endDate, lateStart, lateEnd;
    private float taskDuration, taskSlack;
    private boolean taskIsComplete;
    
    public Task (){} //Default constructor.
    
    public Task(String taskName, Task taskParent, Task[] dependentNodes,
                Date startDate, Date endDate){
    
        this.taskName = taskName;
        this.taskParent = taskParent;
        this.dependentNodes = dependentNodes;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
    //Get methods for retrieving variable data
    public String getName(){
        return taskName;
    }
    public String getTaskNumber(){
        return taskNumber;
    }
    public int getTaskId(){
        return taskId;
    }
    public int getTaskLevel(){
        return taskLevel;
    }
    public Task getTaskParent(){
        return taskParent;
    }
    public Task[] getDependentNodes(){
        return dependentNodes;
    }
    public Date getStartDate(){
        return startDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public Date getLateStart(){
        return lateStart;
    }
    public Date getLateEnd(){
        return lateEnd;
    }
    
    //set methods for modifying class variables.
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    public void setTaskNumber(String taskNumber){
        this.taskNumber = taskNumber;
    }
    
    /*Remove if not needed*/
    public void setTaskParent(Task taskParent){
        this.taskParent = taskParent;
    }
    
    public void setTaskDuration(int taskDuration){
        this.taskDuration = taskDuration;
    }
    
    public void setTaskSlack(int taskSlack){
        this.taskSlack = taskSlack;
    }
    public void setTaskIsComplete(boolean taskIsComplete){
        this.taskIsComplete = taskIsComplete;
    }
    
        //--- 'Utility' methods ---
    
    public void printOut(){
        System.out.println("Task Name:" + taskName);
        if (taskParent != null){
            System.out.println("Parent: " + taskParent.getName());
        } else {
            System.out.println("No Parent");
        }
    }
    
}
