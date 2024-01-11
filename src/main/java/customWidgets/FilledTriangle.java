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
public class FilledTriangle extends JPanel
{    
    private double angle;
    
    public FilledTriangle(Color color, int size, double angle)
    {        
        setOpaque(false);
        setBackground(color);
        setAngle(angle);
        setSize(size, size);
    }
    
    public void setColor(Color color)
    {
        setBackground(color);
        
        repaint();
    }
    
    public void setAngle(double angle)
    {
        this.angle = angle;
        
        repaint();
    }
        
    @Override
    public void paintComponent(Graphics graphics) 
    {    
        Graphics2D graphics_2d = (Graphics2D) graphics.create();
        graphics_2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics_2d.setColor(this.getBackground());
        
        Dimension d = getSize();
        int size = d.width;
        
        // 0 rad
        int[] xPoints = {0, 0, size};
        int[] yPoints = {0, size, size/2};
        
        int centerX = size/2;
        int centerY = size/2;

        for (int i = 0; i < xPoints.length; i++) 
        {
            int translatedX = xPoints[i] - centerX;
            int translatedY = yPoints[i] - centerY;

            double rotatedX = translatedX * Math.cos(angle) + translatedY * Math.sin(angle);
            double rotatedY = -translatedX * Math.sin(angle) + translatedY * Math.cos(angle);

            xPoints[i] = (int) (rotatedX + centerX);
            yPoints[i] = (int) (rotatedY + centerY);
        }
        
        graphics_2d.fillPolygon(xPoints, yPoints, 3);
        graphics_2d.dispose();
        
        super.paintComponent(graphics_2d);
    }
}
