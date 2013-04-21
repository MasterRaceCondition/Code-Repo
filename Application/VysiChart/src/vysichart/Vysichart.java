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
        Calendar endProj = Calendar.getInstance();
        endProj.set(2010, 5, 11, 7, 30);

        
        Task makeBreak = new Task("Make Breakfast", startProj, endProj);
        int[] cal = makeBreak.getTotalTime();
        String[] timeFrames = {"year", "month", "week", "day", "hour", 
                                "minute", "second"};
        
        Calendar startMakeCerial = Calendar.getInstance();
        Calendar endMakeCerial = Calendar.getInstance();
        startMakeCerial.set(2010, 5, 11, 6, 00);
        endMakeCerial.set(2010, 5, 11, 6, 30);
        Task makeCerial = new Task("Make Cerial", makeBreak, startMakeCerial, endMakeCerial);
        
        Calendar startMakeJuice = Calendar.getInstance();
        Calendar endMakeJuice = Calendar.getInstance();
        startMakeJuice.set(2010, 5, 11, 6, 35);
        endMakeJuice.set(2010, 5, 11, 6, 50);
        Task makeJuice = new Task("Make Juice", makeBreak, startMakeJuice, endMakeJuice);
        
        Calendar startEatBreakfast = Calendar.getInstance();
        Calendar endEatBreakfast = Calendar.getInstance();
        startEatBreakfast.set(2010, 5, 11, 6, 50);
        endEatBreakfast.set(2010, 5, 11, 7, 30);
        Task eatBreakfast = new Task("Eat Breakfast", makeBreak, startEatBreakfast, endEatBreakfast);
        
        Calendar startGetBowl = Calendar.getInstance();
        Calendar endGetBowl = Calendar.getInstance();
        startGetBowl.set(2010, 5, 11, 6, 00);
        endGetBowl.set(2010, 5, 11, 6, 5);
        Task getBowl = new Task("Get Bowl", makeCerial, startGetBowl, endGetBowl);
        
        Calendar startPourCerial = Calendar.getInstance();
        Calendar endPourCerial = Calendar.getInstance();
        startPourCerial.set(2010, 5, 11, 6, 00);
        endPourCerial.set(2010, 5, 11, 6, 5);
        Task pourCerial = new Task("Pour Cerial", makeCerial, startPourCerial, endPourCerial);
        
        Calendar startAddMilk = Calendar.getInstance();
        Calendar endAddMilk = Calendar.getInstance();
        startAddMilk.set(2010, 5, 11, 6, 10);
        endAddMilk.set(2010, 5, 11, 6, 20);
        Task addMilk = new Task("Add Milk", makeCerial, startAddMilk, endAddMilk);
      
        Calendar startEatCerial = Calendar.getInstance();
        Calendar endEatCerial = Calendar.getInstance();
        startEatCerial.set(2010, 5, 11, 6, 50);
        endEatCerial.set(2010, 5, 11, 7, 5);
        Task eatCerial = new Task("Eat Cerial", eatBreakfast, startEatCerial, endEatCerial);
        
        Calendar startDrinkJuice = Calendar.getInstance();
        Calendar endDrinkJuice = Calendar.getInstance();
        startDrinkJuice.set(2010, 5, 11, 7, 10);
        endDrinkJuice.set(2010, 5, 11, 7, 30);
        Task drinkJuice = new Task("Drink Juice", eatBreakfast, startDrinkJuice, endDrinkJuice);


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
