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
    private static final int DEFAULT_RADIUS = 10;
    
    private int radius;
    
    public FilledCircle(Color color)
    {
        setOpaque(false);
        setBackground(color);
        setRadius(DEFAULT_RADIUS);
    }
    
    public void setRadius(int radius)
    {
        this.radius = radius;
        
        Dimension dimension = new Dimension(this.radius*2, this.radius*2);
        setPreferredSize(dimension);
        
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics graphics) 
    {    
        Graphics2D graphics_2d = (Graphics2D) graphics.create();
        graphics_2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        drawCircle(graphics_2d, this.radius, this.radius, this.radius);
        
        graphics_2d.dispose();
        super.paintComponent(graphics_2d);
    }

    public void drawCircle(Graphics2D graphics_2d, int xCenter, int yCenter, int r) {
        graphics_2d.setColor(this.getBackground());
        graphics_2d.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }
}
