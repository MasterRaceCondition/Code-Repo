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

public class PERTRender extends JPanel {
    
    private Chart pert; // the gantt to render

    public PERTRender(Chart pert) // set up graphics window
    {
        super();
        //setBackground(Color.WHITE);
        this.pert = pert;
    }

    public void paintComponent(Graphics g) // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels



        super.paintComponent(g);
        
        
        drawNode(g, 100, 100);
    }
    
    public void drawNode(Graphics g, int x, int y){
        g.drawRect(x, y, 120, 80); // default node size
        g.drawString("PERT task", x + 30, y + 20);
        g.drawString("Task 3.7", x + 30, y + 40);
    }
    

    public void drawChart(Graphics g){
        // All 'next node' calculations are handled in here
        //TODO
    }
    
     public void run() {
        PERTRender panel = new PERTRender(pert);                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(801, 469);         // window is 801 pixels wide, 469 high (size of panel in GUI)
        application.setVisible(true);

    }
}
