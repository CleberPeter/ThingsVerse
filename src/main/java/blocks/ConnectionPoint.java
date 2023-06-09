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
enum ConnectionPointType {
    INPUT(new Color(48, 189, 68)),
    OUTPUT(new Color(240, 178, 61)),
    UNUSED(new Color(192, 192, 192));

    private Color color;

    ConnectionPointType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

public class ConnectionPoint extends JPanel
{
    private String name;
    private ConnectionPointType type;
    private int anchor;
    private FilledCircle filledCircle;
    JLabel name_label;
            
    public ConnectionPoint(String name, ConnectionPointType type, int anchor)
    {
        this.name = name;
        this.type = type;
        this.anchor = anchor;
        
        setLayout(new GridBagLayout());
        
        filledCircle = new FilledCircle(this.type.getColor());
        
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = anchor;
        
        add(filledCircle, gridBagConstraints);
        
        if (this.type != ConnectionPointType.UNUSED)
        {
            name_label = new JLabel();
            name_label.setFont(new Font("Arial", Font.BOLD, 16));
            name_label.setForeground(Color.white);
            name_label.setText(this.name);

            if (this.anchor == java.awt.GridBagConstraints.NORTHEAST) gridBagConstraints.insets = new Insets(0, 0, 0, 30);
            else if (this.anchor == java.awt.GridBagConstraints.NORTHWEST) gridBagConstraints.insets = new Insets(0, 30, 0, 0);

            add(name_label, gridBagConstraints);

            setName(this.name);
        }
        
        setOpaque(false);    
    }
    
    public ConnectionPointType getType()
    {
        return this.type;
    }
    
    public int getAnchor()
    {
        return this.anchor;
    }
    
    public void setAnchor(int anchor)
    {
        if (anchor != getAnchor() && getType() != ConnectionPointType.UNUSED)
        {
            GridBagLayout gridBagLayout = (GridBagLayout) getLayout();
        
            GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.weighty = 0.5;
            gridBagConstraints.anchor = anchor;
            
            gridBagLayout.setConstraints(filledCircle, gridBagConstraints);
            
            if (anchor == java.awt.GridBagConstraints.NORTHEAST) gridBagConstraints.insets = new Insets(0, 0, 0, 30);
            else if (anchor == java.awt.GridBagConstraints.NORTHWEST) gridBagConstraints.insets = new Insets(0, 30, 0, 0);
            
            gridBagLayout.setConstraints(name_label, gridBagConstraints);
            
            revalidate();
        }
        
        this.anchor = anchor;
    }
}
