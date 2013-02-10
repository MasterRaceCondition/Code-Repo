
package vysichart;

/**
 *
 * @author UP612136, UP619902, [paddy's jupiter]
 */
public class Vysichart {

    /**
     * @param args Command-line arguments.
     */
    public static void debug(){
        // debug stuff in here!
        Project myProject = new Project("project1", "C:/System32/VysiChart");
        Task task1 = new Task();
        Task task2 = new Task();
        
        task1.setTaskName("FirstTask");
        task2.setTaskName("SecondTask");
        task2.setTaskParent(task1);
        
        myProject.addTask(task1);
        myProject.addTask(task2);
        
        myProject.printOut();
        
    }
    
    public static void main(String[] args) {
        debug();
        //GraphicalUserInterface.main(null); // run GUI
    }
}
