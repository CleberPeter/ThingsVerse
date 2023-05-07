/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Src.CustomWidgets;

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
public class SensorNode extends JPanel {

    public SensorNode() {
        setOpaque(false);
        Dimension dimension = new Dimension(diameter, diameter);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
    }
    
    public int getRadius()
    {
        return this.radius;
    }
    
    public void setRadius(int radius)
    {
        this.radius = radius;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics_2d = (Graphics2D) graphics.create();
        graphics_2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        drawCircle(graphics_2d, 30, 30, this.radius);
        
        graphics_2d.dispose();
        super.paintComponent(graphics_2d);
    }

    public void drawCircle(Graphics2D graphics_2d, int xCenter, int yCenter, int r) {
        graphics_2d.setColor(Color.white);
        graphics_2d.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }
    
    private int radius = 25;
    private int diameter = 100;
} 
