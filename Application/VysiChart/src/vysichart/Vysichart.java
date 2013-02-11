
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
        Project myProject = new Project("Toast Maker", "C:/System32/VysiChart");
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        Task task4 = new Task();
        Task task5 = new Task();
        
        task1.setTaskName("Make Toast");
        task2.setTaskName("Get Bread");
        task3.setTaskName("Toast Bread");
        task4.setTaskName("Butter Toast");
        task5.setTaskName("Eat The Toast");
        
        task2.setTaskParent(task1);
        task3.setTaskParent(task1);
        task4.setTaskParent(task1);
        task5.setTaskParent(task1);
        
        task3.addDependantNode(task2);
        task4.addDependantNode(task3);
        task5.addDependantNode(task4);
        
        myProject.addTask(task1);
        myProject.addTask(task2);
        myProject.addTask(task3);
        myProject.addTask(task4);
        myProject.addTask(task5);
        
        myProject.printOut();
        
    }
    
    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();
        
        debug();
        //GraphicalUserInterface.main(null); // run GUI
        
        long endTime = System.currentTimeMillis();
        System.out.println("Computation Time: " // check how fast it is
                + (endTime - startTime) + " ms");
    }
}
