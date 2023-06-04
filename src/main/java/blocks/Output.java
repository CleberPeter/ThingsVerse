/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blocks;

import customWidgets.FilledCircle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cleber
 */
public class Output extends JPanel
{
    private static final Color DEFAULT_COLOR = new Color(240, 178, 61);
    
    private String name;
    private double value;
    FilledCircle connectionPoint;
    
    public Output(String name, double value) 
    {
        setLayout(new GridBagLayout());
        
        connectionPoint = new FilledCircle(DEFAULT_COLOR);
        
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(connectionPoint, gridBagConstraints);
        
        JLabel name_label = new JLabel();
        name_label.setFont(new Font("Arial", Font.BOLD, 16));
        name_label.setForeground(Color.white);
        name_label.setText(name);
        
        gridBagConstraints.insets = new Insets(0, 0, 0, 30);
        add(name_label, gridBagConstraints);
        
        setOpaque(false);
        setName(name);
        setPreferredSize(new Dimension(220, 20));
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }
}
