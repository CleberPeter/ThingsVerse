/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Src.CustomWidgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cleber
 */
public class ContextPanel extends PanelRound {
    public ContextPanel() {
        
        setLayout(new java.awt.GridBagLayout());
        
        header_panel = new PanelRound();
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
        
        setSize();
        setColor(this.color);
        setTitle(title);
        setRoundDefault(20);
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
    
    public int getWidth()
    {
        return width;
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
    
    public void setWidth(int width)
    {
        this.width = width;
        
        setSize();
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
        
        setSize();
    }
    
    private void setSize()
    {
        Dimension context_panel_dimension = new Dimension(this.width, this.height);
        setPreferredSize(context_panel_dimension);
        setMinimumSize(context_panel_dimension);
        
        Dimension context_panel_header_dimension = new Dimension(this.width, 30);
        header_panel.setPreferredSize(context_panel_header_dimension);
    }
    
    private PanelRound header_panel;
    private Color color = Color.WHITE;
    private int width = 640;
    private int height = 320;
    private JLabel titleLabel = new JLabel();
    private String title = "Contexto A";
}
