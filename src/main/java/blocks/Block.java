/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blocks;

import customWidgets.PanelRound;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;

/**
 *
 * @author cleber
 */
public abstract class Block extends JLayeredPane implements ComponentListener
{
    private static final Color BACKGROUND_COLOR = new Color(60,60,60);
    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);

    private PanelRound header_panel;
    private PanelRound main_panel;
    private String name;
    
    private List<ConnectionPoint> connectionPointsList;
    
    public Block(String name)
    {   
        setLayout(new GridBagLayout());
        
        connectionPointsList = new ArrayList<>();
        
        header_panel = new PanelRound();
        
        header_panel.setRoundTopLeft(20);
        header_panel.setRoundTopRight(20);
        header_panel.setBackground(Color.white);
        
        JLabel titleLabel = new JLabel();
        titleLabel.setText(name);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
        
        header_panel.setLayout(new java.awt.GridBagLayout());
        header_panel.setPreferredSize(new Dimension(0, 30));
        header_panel.setMinimumSize(new Dimension(0, 30));
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        header_panel.add(titleLabel, gridBagConstraints);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(header_panel, gridBagConstraints);
        
        main_panel = new PanelRound();
        main_panel.setRoundDefault(20);
        main_panel.setBackground(BACKGROUND_COLOR);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(main_panel, gridBagConstraints, 1);
        
        setBackground(TRANSPARENT_COLOR);
        setName(name);
        
        ComponentMover componentMover = new ComponentMover();
        componentMover.registerComponent(this);
        componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        
        ComponentResizer componentResizer = new ComponentResizer(new Insets(10, 10, 10, 10), this);
        componentResizer.setSnapSize(new Dimension(15, 15));
        
        addComponentListener(this);
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
    
    public void setInput(String name) 
    {   
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets((getConnectionPointsCount(gridBagConstraints.anchor) + 1)*50, 0, 0, 0);
        
        ConnectionPoint inputConnectionPoint = new ConnectionPoint(name, ConnectionPointType.INPUT, gridBagConstraints.anchor);
        connectionPointsList.add(inputConnectionPoint);
        add(inputConnectionPoint, gridBagConstraints, 1);
    }

    public void setOutput(String name) 
    {   
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets((getConnectionPointsCount(gridBagConstraints.anchor) + 1)*50, 0, 0, 0);
        
        ConnectionPoint outputConnectionPoint = new ConnectionPoint(name, ConnectionPointType.OUTPUT, gridBagConstraints.anchor);
        connectionPointsList.add(outputConnectionPoint);
        add(outputConnectionPoint, gridBagConstraints, 1);
    }
    
    public int getConnectionPointsCount(int anchor)
    {
        int count = 0;
        
        for (ConnectionPoint connectionPoint : connectionPointsList)
        {
            if (connectionPoint.getAnchor() == anchor) count++;
        }
        
        return count;
    }
    
    public void removeInvisibleConnectionPoints(int usable_height)
    {
        // iterator prevents java.util.ConcurrentModificationException
        for (Iterator<ConnectionPoint> iterator = connectionPointsList.iterator(); iterator.hasNext();) 
        {
            ConnectionPoint connectionPoint = iterator.next();
            
            if (connectionPoint.getType() == ConnectionPointType.UNUSED)
            {
                GridBagLayout layout = (GridBagLayout) getLayout();                
                GridBagConstraints gridBagConstraints = layout.getConstraints(connectionPoint);
                
                if (gridBagConstraints.insets.top >= usable_height)
                {
                    remove(connectionPoint);
                    iterator.remove();
                }
            }
        }
    }
    
    public void fillWithUnusedConnectionPoints(int connectionPointsLen, int anchor)
    {
        int filledConnectionPoints = getConnectionPointsCount(anchor);
        
        if (filledConnectionPoints < connectionPointsLen)
        {
            GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.weighty = 0.5;

            while(filledConnectionPoints++ != connectionPointsLen)
            {
                gridBagConstraints.insets = new Insets(filledConnectionPoints*50, 0, 0, 0);
                gridBagConstraints.anchor = anchor;

                ConnectionPoint unusedConnectionPoint = new ConnectionPoint("unused", ConnectionPointType.UNUSED, gridBagConstraints.anchor);
                connectionPointsList.add(unusedConnectionPoint);
                add(unusedConnectionPoint, gridBagConstraints, 1);
            }
        }
    }
    
    public void populateConnectionPoints()
    {   
        int usable_height = this.getHeight() - 50;
        int connectionPointsLen = usable_height/50;
        
        removeInvisibleConnectionPoints(usable_height);
        
        fillWithUnusedConnectionPoints(connectionPointsLen, java.awt.GridBagConstraints.NORTHWEST);
        fillWithUnusedConnectionPoints(connectionPointsLen,java.awt.GridBagConstraints.NORTHEAST);
        
        validate();
    }
    
    @Override
    public void componentResized(ComponentEvent ce) 
    {
        populateConnectionPoints();
    }
    
    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
}
