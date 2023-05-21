/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Src.CustomWidgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JLabel;

/**
 *
 * @author cleber
 */
public class ContextPanel extends PanelRound implements ComponentListener {
    public ContextPanel() {
        
        gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        
        header_panel = new PanelRound();
        header_panel.setName("header_panel");
        header_panel.setLayout(new java.awt.GridBagLayout());
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        
        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        header_panel.add(titleLabel, gridBagConstraints);
        
        header_panel.setRoundTopLeft(20);
        header_panel.setRoundTopRight(20);
        header_panel.setBackground(this.color);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(header_panel, gridBagConstraints);
        
        ComponentMover componentMover = new ComponentMover();
        componentMover.registerComponent(this);
        componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        
        ComponentResizer componentResizer = new ComponentResizer(new Insets(10, 10, 10, 10), this);
        componentResizer.setSnapSize(new Dimension(15, 15));
        
        addComponentListener(this);
        
        setColor(this.color);
        setTitle(title);
        setRoundDefault(20);
    }
    
    public void addSensorNode(String name, int radius, Color color, Insets insets)
    {
        Src.CustomWidgets.SensorNode sensorNode = new Src.CustomWidgets.SensorNode();
        
        sensorNode.setName(name);
        sensorNode.setRadius(radius);
        sensorNode.setColor(color);
        sensorNode.addComponentListener(this);
        sensorNode.setLocation(insets.left, insets.top);
        
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        
        gridBagConstraints.insets = insets;
        add(sensorNode, gridBagConstraints);
    }
    
    public Color getColor()
    {
        return this.color;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
        setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
       
        repaint();
    }
    
    public void setTitle(String title)
    {
        this.title = title;
        
        titleLabel.setText(title);
        
        repaint();
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void recalculateSizes()
    {   
        Dimension context_panel_header_dimension = new Dimension(this.getWidth(), 30);
        header_panel.setPreferredSize(context_panel_header_dimension);
        header_panel.setMinimumSize(context_panel_header_dimension);
        
        header_panel.setLayout(new java.awt.GridBagLayout());
    }
    
    @Override
    public void componentResized(ComponentEvent ce) 
    {
        recalculateSizes();
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        
        gridBagConstraints.insets = new Insets(ce.getComponent().getY(), ce.getComponent().getX(), 0, 0);
        
        gridBagLayout.setConstraints(ce.getComponent(), gridBagConstraints);
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        System.out.println("Src.CustomWidgets.ContextPanel.componentShown(): " + ce.getComponent().getName());
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        System.out.println("Src.CustomWidgets.ContextPanel.componentHidden(): " + ce.getComponent().getName());
    }
    
    private GridBagLayout gridBagLayout;
    private PanelRound header_panel;
    private Color color = Color.WHITE;
    private JLabel titleLabel = new JLabel();
    private String title = "Contexto A";
}
