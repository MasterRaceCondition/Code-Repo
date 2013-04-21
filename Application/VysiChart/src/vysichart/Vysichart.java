package vysichart;

import java.util.Calendar;

/**
 *
 * @author UP612136, UP619902, [paddy's jupiter]
 */
public class Vysichart {

    /**
     * @param args Command-line arguments.
     */
    public static void test1() {
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

        myProject.printOut();


    }

    public static void test2() {
        //make breakfast!
        Project makeBreakfast = new Project("Breakfast Maker", "D:/Documents/MRC/Vysichart/Breakfast");

        
        Calendar startProj = Calendar.getInstance();
        startProj.set(2010, 5, 11, 6, 00);
        Calendar startCal = Calendar.getInstance();
        startCal.set(2010, 5, 11, 6, 00);
        Calendar endCal = Calendar.getInstance();
        endCal.set(2010, 5, 11, 6, 50);
        Task makeBreak = new Task("Make Breakfast", startProj, endCal);
        int[] cal = makeBreak.getTotalTime();
        String[] timeFrames = {"year", "month", "week", "day", "hour", 
                                "minute", "second"};
        endCal.set(2010, 5, 11, 6, 30);
        Task makeCerial = new Task("Make Cerial", makeBreak, startCal, endCal);
        startCal.set(2010, 5, 11, 6, 35);
        endCal.set(2010, 5, 11, 6, 50);
        Task makeJuice = new Task("Make Juice", makeBreak, startCal, endCal);
        startCal.set(2010, 5, 11, 6, 50);
        endCal.set(2010, 5, 11, 7, 30);
        Task eatBreakfast = new Task("Eat The Breakfast", makeBreak, startCal, endCal);
        startCal.set(2010, 5, 11, 6, 00);
        endCal.set(2010, 5, 11, 6, 5);
        Task getBowl = new Task("Get Bowl", makeCerial, startCal, endCal);
        startCal.set(2010, 5, 11, 6, 5);
        endCal.set(2010, 5, 11, 6, 10);
        Task pourCerial = new Task("Pour Cerial", makeCerial, startCal, endCal);
        startCal.set(2010, 5, 11, 6, 10);
        endCal.set(2010, 5, 11, 6, 20);
        Task addMilk = new Task("Add Milk To Cerial", makeCerial, startCal, endCal);
        
        startCal.set(2010, 5, 11, 6, 50);
        endCal.set(2010, 5, 11, 7, 5);
        Task eatCerial = new Task("Eat Cerial", eatBreakfast, startCal, endCal);
        startCal.set(2010, 5, 11, 7, 10);
        endCal.set(2010, 5, 11, 7, 30);
        Task drinkJuice = new Task("Drink Juice", eatBreakfast, startCal, endCal);

        eatBreakfast.addDependantNode(makeCerial);
        eatBreakfast.addDependantNode(makeJuice);

        System.out.println("time Difference between makeBreak and drinkJuice: " + Project.getTimeDifference(makeBreak, drinkJuice));
        
        pourCerial.addDependantNode(getBowl);
        addMilk.addDependantNode(pourCerial);

        System.out.println("Percentage of makeBreak: " + Project.getTaskPercentage(makeBreak));
        System.out.println("Percentage of eatBreak: " + Project.getTaskPercentage(eatBreakfast));

        //makeBreakfast.printOut();

        //System.out.println(makeBreakfast.getString());

        GraphicalUserInterface gui = new GraphicalUserInterface(makeBreakfast);
        
        
        // no default contructor
        gui.main(null);

    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //test1();
        test2();
        
        //Project welcome = new Project("Welcome To Vysichart", "/Projects/Welcome");
        //Task useVysi = new Task("Use VysiChart");
        //Task addTasks = new Task("Add Tasks");
        //Task make
        
        

        // node, testN classes are debugging classes, they have no real implication
        
        //Gantt g = new Gantt();
        //GanttRender gr = new GanttRender(g);
        //gr.run(); //debug



        //GraphicalUserInterface.main(null); // run GUI

        long endTime = System.currentTimeMillis();
        System.out.println("Computation Time: " // check how fast it is
                + (endTime - startTime) + " ms");
    }
}
