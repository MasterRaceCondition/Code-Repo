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

public class WBTRender extends JPanel {

    private Chart wbt; // the gantt to render
    private int width;
    private int height;

    public WBTRender(Chart wbt) // set up graphics window
    {
        super();
        //setBackground(Color.WHITE);

        this.wbt = wbt;
        width = getLeftMostPoint();
        height = Project.calculateLevels() * 100;
    }

    private int getLeftMostPoint() {

        int firstChilds = wbt.getTasks().get(0).getChildren().size(); // the number of children the parent has
        // this is important as the gaps are bigger for this level
        int leftTasks = getLeftMost(wbt.getTasks().get(0), 0);

        // do the maths and work out some numbers
        leftTasks *= 70; // block size + gap size
        leftTasks -= (70 * firstChilds); // making room for top later
        leftTasks += (220 * firstChilds); // top brace
        leftTasks += 100; // bug on rendering one task

        return leftTasks;


    }

    private int getLeftMost(Task current, int currentTaskDensity) {
        ArrayList<Task> tasks = current.getChildren();
        int numberOfChildren = tasks.size();
        currentTaskDensity += numberOfChildren;
        if (numberOfChildren == 0) { // recursive end state
            return currentTaskDensity;
        } else {
            Task nextChild = tasks.get(0);
            return getLeftMost(nextChild, currentTaskDensity);
        }

    }

    public int getRenderHeight() {
        return this.height;
    }

    public int getRenderWidth() {
        return this.width;
    }

    @Override
    public void paintComponent(Graphics g) // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels



        super.paintComponent(g);




        // levels have not been set up yet
        // for now use 3
        for (int i = 0; i <= Project.calculateLevels(); i++) {
            drawLevelBrace(g, i);
        }

        // calculate height
        this.height = Project.calculateLevels() * 100;

        //calculate width
        ArrayList<Task> tasks = wbt.getTasks(); // get mosts tasks on a single layer

        this.width = getLeftMostPoint();


        drawChart(g, (this.width / 2));


    }

    public void drawNode(Graphics g, int x, int y, Task task) {
        g.drawRect(x, y, 120, 50); // default node size
        g.drawString(task.getName(), x + 15, y + 25);
    }

    public void drawLevelBrace(Graphics g, int level) {
        // get y from level
        // '1' is 40 - 90
        // 40 gap between all
        // 40, 130, 220 // y = 40 + 90(l - 1)
        int y = 40 + (90 * (level - 1));
        int x = 30;
        // init line
        g.drawLine(x, y, x, y + 50);
        // bracket ends
        g.drawLine(x, y, x + 5, y);
        g.drawLine(x, y + 50, x + 5, y + 50);
        // render level number
        g.drawString("lv " + String.valueOf(level), 10, y + 25);

    }

    public void drawTree(Graphics g, Task current, int x, int y) {
        // recursivley draws tree

        drawNode(g, x, y, current);


        ArrayList<Task> childs = current.getChildren();
        int len = childs.size();

        y += 50; // move down
        x += 60; // centre
        if (childs.isEmpty() == false) {
            g.drawLine(x, y, x, y + 20);

            y += 20; // move down

            // size of break = (l-1)(b + g), where b = box width (120) and g = gap size (40)

            int lineLen = (len - 1) * (140); // 140 = 120 + 20

            g.drawLine(x - lineLen / 2, y, x + lineLen / 2, y);

            x -= lineLen / 2;
            for (int i = 0; i < len; i++) {
                g.drawLine(x, y, x, y + 20);
                drawTree(g, childs.get(i), x - 60, y + 20);
                // draw node for x
                x += 140;
            }

        } // else do nothing

    }

    public void drawChart(Graphics g, int x) {
        if (wbt.getTasks().isEmpty() == false) {
            // init vars, draw first child

            int y = 40; // near the top
            Task currentTask = wbt.getTasks().get(0); // root node
            drawNode(g, x, y, currentTask); // draw current node

            ArrayList<Task> childs = currentTask.getChildren();
            int len = childs.size();

            y += 50; // move down
            x += 60; // centre

            if (childs.isEmpty() == false) {
                g.drawLine(x, y, x, y + 20);

                y += 20; // move down

                // size of break = (l-1)(b + g), where b = box width (120) and g = gap size (80)

                int lineLen = (len - 1) * (220); // 220 = 120 + 100
                // top layer has bigger gaps

                g.drawLine(x - lineLen / 2, y, x + lineLen / 2, y);

                x -= lineLen / 2;
                for (int i = 0; i < len; i++) {
                    g.drawLine(x, y, x, y + 20);
                    drawTree(g, childs.get(i), x - 60, y + 20);
                    // draw node for x
                    x += 220;
                }
            } // else do nothing



        } else {
            g.drawString("No Tasks Found", 200, 200); // leave error message
        }
    }

    public void run() {
        WBTRender panel = new WBTRender(wbt);                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(width, height);
        application.setVisible(true);

    }
}
