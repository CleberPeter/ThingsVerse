/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customWidgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author cleber
 */
public class FilledCircle extends JPanel
{        
    public FilledCircle(Color color, int size)
    {
        setOpaque(false);
        setBackground(color);
        
        setSize(size, size);
    }
    
    public void setColor(Color color)
    {
        setBackground(color);
        
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics graphics) 
    {    
        Graphics2D graphics_2d = (Graphics2D) graphics.create();
        graphics_2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Dimension d = getSize();
        System.out.println("customWidgets.FilledCircle.paintComponent(): " + d);
        int radius = d.width/2;
        
        drawCircle(graphics_2d, radius, radius, radius);
        
        graphics_2d.dispose();
        super.paintComponent(graphics_2d);
    }

    public void drawCircle(Graphics2D graphics_2d, int xCenter, int yCenter, int r) {
        graphics_2d.setColor(this.getBackground());
        graphics_2d.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }
}
