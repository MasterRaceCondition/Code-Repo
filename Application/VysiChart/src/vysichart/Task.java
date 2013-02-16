package vysichart;

import java.util.Date;
import java.util.ArrayList;

/**
 *
<<<<<<< HEAD
 * @author Harry, Todd
=======
 * @author UP619902, OtherID1, OtherID2
>>>>>>> parent of 10784c2... Revert "Changed comments on Task.java"
 */
public class Task {

    private String taskName, taskNumber;
    private int taskId;
    //The level of the task in the tree (the parent's level plus one).
    private int taskLevel;
    private Task taskParent;
<<<<<<< HEAD
    //An array of all nodes that need to be done before this task.
    private ArrayList<Task> dependentNodes;
    private ArrayList<Task> children; // tasks children
=======
    
    //An array of all nodes that need to be completed before this task.
    private Task[] dependentNodes;
>>>>>>> parent of 10784c2... Revert "Changed comments on Task.java"
    private Date startDate, endDate, lateStart, lateEnd;
    private float taskDuration, taskSlack;
    private boolean taskIsComplete;

    public Task() {
        dependentNodes = new ArrayList<Task>();
        children = new ArrayList<Task>();
    } //Default constructor.
    
    public Task(String taskName){
        this.taskName = taskName;
        dependentNodes = new ArrayList<Task>();
        children = new ArrayList<Task>();
    }
    
    public Task(String taskName, Task taskParent){
        this.taskName = taskName;
        
        this.taskParent = taskParent;
        taskParent.addChild(this); // adds THIS as child to parent
        
        dependentNodes = new ArrayList<Task>();
        children = new ArrayList<Task>();
    }

  

    public Task(String taskName, Task taskParent,
            Date startDate, Date endDate) {

        this.taskName = taskName;
        this.taskParent = taskParent;
        this.dependentNodes = new ArrayList<Task>(); // init
        this.children = new ArrayList<Task>(); // init
        this.startDate = startDate;
        this.endDate = endDate;

        this.taskParent.addChild(this); // adds THIS as child to parent
    }
    
      public Task(String taskName, Task taskParent, ArrayList<Task> dependentNodes,
            Date startDate, Date endDate) {

        this.taskName = taskName;
        this.taskParent = taskParent;
        this.dependentNodes = dependentNodes; //  no need to init
        this.startDate = startDate;
        this.endDate = endDate;
        this.children = new ArrayList<Task>();

        this.taskParent.addChild(this); // adds THIS as child to parent
    }

    //Get methods for retrieving variable data
    public String getName() {
        return taskName;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getTaskLevel() {
        return taskLevel;
    }

    public Task getTaskParent() {
        return taskParent;
    }

    public ArrayList<Task> getDependentNodes() {
        return dependentNodes;
    }

    public ArrayList<Task> getChildren() {
        return children;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getLateStart() {
        return lateStart;
    }

    public Date getLateEnd() {
        return lateEnd;
    }
<<<<<<< HEAD

    public float getTaskDuration() {
        return taskDuration;
    }

    //set methods for modifying class variables.
    public void setTaskName(String taskName) {
=======
    
    //Set methods for modifying class variables.
    public void setTaskName(String taskName){
>>>>>>> parent of 10784c2... Revert "Changed comments on Task.java"
        this.taskName = taskName;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    /*Remove if not needed*/
    public void setTaskParent(Task taskParent) {
        this.taskParent = taskParent;
        this.taskParent.addChild(this); // adds THIS as child to parent
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskSlack(int taskSlack) {
        this.taskSlack = taskSlack;
    }

    public void setTaskIsComplete(boolean taskIsComplete) {
        this.taskIsComplete = taskIsComplete;
    }

    //--- 'Utility' methods ---
    public void printOut() {
        System.out.println("Task Name: " + taskName);
        if (taskParent != null) {
            System.out.println("Parent: " + taskParent.getName());
        } else {
            System.out.println("No Parent");
        }
        System.out.println("Depedent Nodes:");
        if (dependentNodes.isEmpty()) {
            System.out.println("    None");
        } else {
            for (Task currentTask : dependentNodes) {
                System.out.println("    " + currentTask.getName());
            }
        }
        System.out.println("Children:");
        if (children.isEmpty()) {
            System.out.println("    None");
        } else {
            for (Task currentTask : children) {
                System.out.println("    " + currentTask.getName());
            }
        }
    }

    public void addDependantNode(Task task) {
        dependentNodes.add(task);
    }

    public void removeDependentNode(Task taskToRemove) {
        dependentNodes.remove(taskToRemove);
    }

    public void addChild(Task task) {
        children.add(task);
    }

    public void removeChild(Task taskToRemove) {
        children.remove(taskToRemove);
    }

    public void changeParent(Task newParent) {
        // 'cut ties' with old parent
        this.taskParent.removeChild(this);
        // set new parent
        setTaskParent(newParent);
        //setTaskParent automatically adds THIS as child
    }
}
