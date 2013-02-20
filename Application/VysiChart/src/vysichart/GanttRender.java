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

    public GanttRender(Chart gantt) // set up graphics window
    {
        super();
        //setBackground(Color.WHITE);
        this.gantt = gantt;
    }

    public void paintComponent(Graphics g) // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels



        super.paintComponent(g);
        
        g.drawLine(50, 200, 250, 200);
        g.drawString("GANTT CHART RENDER", 150, 150);
    }
    
     public void run() { // for debug
        GanttRender panel = new GanttRender(gantt);                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(801, 469);         // window is 801 pixels wide, 469 high (size of panel in GUI)
        application.setVisible(true);

    }
}
