/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vysichart;

/**
 *
 * @author U AMD
 */
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.util.*; //for arraylists

public class GanttRender extends JPanel {

    private Chart gantt; // the gantt to render
    //Width in pixels is used to define one percent of the project in pixel width.
    private int xCoord, yCoord, pixelToPercent;
    private long lastTaskEndTime; //Used to keep track of last task length.

    public GanttRender(Chart gantt) // set up graphics window
    {
        super();
        //setBackground(Color.WHITE);
        this.gantt = gantt;
        xCoord = 10;
        yCoord = 30;
        pixelToPercent = 5; //Default for debugging.
    }
    
    @Override
    public void paintComponent(Graphics g) // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels



        super.paintComponent(g);

        initAxis(g);
        
        
        
        System.out.println("X-COORD: " + xCoord + "     Y-COORD:" + yCoord);
        
        //**PROTOTYPE**
        //a large arraylist will need to have a count stored instead.
        double taskPercentage = 0;
        int taskWidth = 0; //The task width in pixels when rendered.
        long timeDifference = 0; //The time difference between tasks.
        ArrayList<Task> parentTasks = Project.getParents();
        System.out.println("Size of parentTasks: " + parentTasks.size());
        
        for(Task p : parentTasks){
            ArrayList<Task> children = p.getChildren();
            taskWidth = renderTask(p, g);
            yCoord += 30;
            if(!children.isEmpty()){
                renderTaskArrayList(children, g);
            }
        }
        
        xCoord = 10;
        yCoord = 30;
        //reset

    }
    
    public void renderTaskArrayList(ArrayList<Task> tasks, Graphics g){
        int sizeOfTasks = tasks.size();
        int taskWidth = 0;
        for(int i = 0; i< sizeOfTasks; i++){
            ArrayList<Task> children = tasks.get(i).getChildren();
            taskWidth = renderTask(tasks.get(i), g);
            yCoord += 30;
            if(!children.isEmpty()){
                renderTaskArrayList(children, g);
            }
            else{
                if(i > 1){
                    long timeDifference = Project.getTimeDifference(lastTaskEndTime, tasks.get(i).getTaskStartCalendarToMillisecond());
                    xCoord += Project.getWhitespacePercentage(timeDifference);
                }
                xCoord += taskWidth;
                lastTaskEndTime = tasks.get(i).getTaskEndCalendarToMillisecond();
            }
        }
    }
    
    public int renderTask(Task task, Graphics g){
        double taskPercentage = Project.getTaskPercentage(task);
        int taskWidthInPixels = (int)taskPercentage * pixelToPercent;
        drawNode(g, xCoord, yCoord, taskWidthInPixels, task.getName());
        return taskWidthInPixels;
    }

    public void initAxis(Graphics g) {
        g.drawLine(10, 30, 790, 30); // x axis
        g.drawString("x", 800, 30);
        g.drawLine(10, 30, 10, 440); // y axis
        g.drawString("y", 10, 450);
    }

    public void drawNode(Graphics g, int x, int y, int width, String taskName) {
        // draw an individual node
        // box height = 20
        // test boxWidth = 120
        g.drawRect(x, y, width, 30);
        g.drawString(taskName, x + 10, y + 17);


    }

    public void drawChart(Graphics g) {
        //TODO
    }
    
    public void sortTasks(){
        //TODO
    }

    public void run() { // for debug
        GanttRender panel = new GanttRender(gantt);                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(800, 450);         // window is 800 pixels wide, 450 high (size of panel in GUI)
        application.setVisible(true);

    }
}
