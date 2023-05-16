/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Src.CustomWidgets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cleber
 */
public class SensorNode extends JPanel {

    public SensorNode() {
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());
        
        this.name_label = new JLabel();
        this.name_label.setFont(new Font("Arial", Font.BOLD, 16));
        this.name_label.setForeground(Color.white);
        
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        
        ComponentMover componentMover = new ComponentMover();
        componentMover.registerComponent(this);
        
        add(this.name_label, gridBagConstraints);
    }
    
    public int getRadius()
    {
        return this.radius;
    }
    
    public void setRadius(int radius)
    {
        this.radius = radius;
        
        Dimension dimension = new Dimension(radius*2, radius*2);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        
        repaint();
    }
    
    public Color getColor()
    {
        return this.color;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
        
        repaint();
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
        name_label.setText(name);
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        
        Graphics2D graphics_2d = (Graphics2D) graphics.create();
        graphics_2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        drawCircle(graphics_2d, this.radius, this.radius, this.radius);
        
        graphics_2d.dispose();
        super.paintComponent(graphics_2d);
    }

    public void drawCircle(Graphics2D graphics_2d, int xCenter, int yCenter, int r) {
        graphics_2d.setColor(this.color);
        graphics_2d.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }
    
    private JLabel name_label;
    private Color color = Color.WHITE;
    private String name = "S1";
    private int radius = 25;
} 
