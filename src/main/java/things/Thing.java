/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things;

import things.connectionPoints.UnusedConnectionPoint;
import things.connectionPoints.ActuatorConnectionPoint;
import things.connectionPoints.EventConnectionPoint;
import things.connectionPoints.ConnectionPoint;
import things.connectionPoints.ActionConnectionPoint;
import things.connectionPoints.PropertyConnectionPoint;
import contexts.Context;
import customWidgets.PanelRound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;
import mouseAdapters.ConnectionPointsMover;

/**
 *
 * @author cleber
 */
public abstract class Thing extends JLayeredPane implements ComponentListener
{
    private static final Color BACKGROUND_COLOR = new Color(60,60,60, 128);
    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);

    private PanelRound header_panel;
    private JLabel titleLabel;
    private PanelRound main_panel;
    private String name;
    private Context parentContext;
    
    private List<ConnectionPoint> connectionPointsList;
    private ComponentMover componentMover;
    private ConnectionPointsMover connectionPointsMover;
    
    public Thing(String name, Context parentContext)
    {   
        this.parentContext = parentContext;
        
        initComponents(name);
        setUpLayout();
        initListeners();
    }
    
    private void initComponents(String name) 
    {
        connectionPointsList = new ArrayList<>();
        
        header_panel = new PanelRound();    
        header_panel.setRoundTopLeft(20);
        header_panel.setRoundTopRight(20);
        header_panel.setBackground(Color.white);
        
        titleLabel = new JLabel();
        titleLabel.setText(name);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        main_panel = new PanelRound();
        main_panel.setRoundDefault(20);
        main_panel.setBackground(BACKGROUND_COLOR);
        
        setBackground(TRANSPARENT_COLOR);
        setName(name);
    }
    
    private void setUpLayout()
    {
        setLayout(new GridBagLayout());
        
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
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(main_panel, gridBagConstraints, 1);
    }
    
    private void initListeners()
    {
        componentMover = new ComponentMover();
        componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        componentMover.registerComponent(this);
        
        connectionPointsMover = new ConnectionPointsMover(this);
        
        ComponentResizer componentResizer = new ComponentResizer(new Insets(10, 10, 10, 10), this);
        componentResizer.setSnapSize(new Dimension(15, 15));
        
        addComponentListener(this);
    }
    
    protected void setConnectionPoint(ConnectionPoint connectionPoint) 
    {   
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = connectionPoint.getAnchor();
        
        int topInset = (getConnectionPointsCount(gridBagConstraints.anchor) + 1)*50;
        gridBagConstraints.insets = new Insets(topInset, 0, 0, 0);
        
        connectionPointsList.add(connectionPoint);
        add(connectionPoint, gridBagConstraints, 1);
        
        connectionPointsMover.registerComponent(connectionPoint);
    }
    
    private int getConnectionPointsCount(int anchor)
    {
        int count = 0;
        
        for (ConnectionPoint connectionPoint : connectionPointsList)
        {
            if (connectionPoint.getAnchor() == anchor) count++;
        }
        
        return count;
    }
    
    private void removeInvisibleConnectionPoints(int usable_height)
    {
        // iterator prevents java.util.ConcurrentModificationException
        for (Iterator<ConnectionPoint> iterator = connectionPointsList.iterator(); iterator.hasNext();) 
        {
            ConnectionPoint connectionPoint = iterator.next();
            
            if (connectionPoint instanceof UnusedConnectionPoint)
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
    
    public void swapConnectionPoints(ConnectionPoint cp1, ConnectionPoint cp2)
    {
        GridBagLayout layout = (GridBagLayout) getLayout();
        
        GridBagConstraints cp2Constraints = layout.getConstraints(cp2);
        GridBagConstraints cp1Constraints = layout.getConstraints(cp1);
        
        int cp2Anchor = cp2.getAnchor();
        int cp1Anchor = cp1.getAnchor();
        
        if (cp2Anchor != cp1Anchor)
        {
            cp1.setAnchor(cp2Anchor);
            cp2.setAnchor(cp1Anchor);
        }
        
        layout.setConstraints(cp1, cp2Constraints);
        layout.setConstraints(cp2, cp1Constraints);
        
        validate();
        
        parentContext.onBlockConnectionPointMoved();
    }
    
    private void fillWithUnusedConnectionPoints(int connectionPointsLen, int anchor)
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

                ConnectionPoint unusedConnectionPoint = new UnusedConnectionPoint(this, anchor);
                unusedConnectionPoint.setAnchor(gridBagConstraints.anchor);
                
                connectionPointsList.add(unusedConnectionPoint);
                add(unusedConnectionPoint, gridBagConstraints, 1);
            }
        }
    }
    
    private void populateConnectionPoints()
    {   
        int usable_height = this.getHeight() - 50;
        int connectionPointsLen = usable_height/50;
        
        removeInvisibleConnectionPoints(usable_height);
        
        fillWithUnusedConnectionPoints(connectionPointsLen, java.awt.GridBagConstraints.NORTHWEST);
        fillWithUnusedConnectionPoints(connectionPointsLen,java.awt.GridBagConstraints.NORTHEAST);
        
        validate();
    }
    
    public List<ConnectionPoint> getConnectionPointsList()
    {
        return this.connectionPointsList;
    }
    
    public Point getConnectionPointContextRelativeLocation(ConnectionPoint connectionPoint)
    {
        Point blockLocation = getLocation();
        Point blockRelativeLocationClicked = connectionPoint.getConnectionPanelThingRelativeLocation();
        
        return new Point(blockRelativeLocationClicked.x + blockLocation.x, blockRelativeLocationClicked.y + blockLocation.y);
    }
    
    public ConnectionPoint getConnectionPoint(String name)
    {
        for (ConnectionPoint connectionPoint : connectionPointsList)
        {
            if (connectionPoint.getName().equals(name)) return connectionPoint;
        }
        
        return null;
    }
    
    public void onConnectionPointPressed(ConnectionPoint connectionPoint)
    {
        this.parentContext.onBlockConnectionPointPressed(this, connectionPoint);
    }
    
    public void onConnectionPointEntered(ConnectionPoint connectionPoint)
    {
        this.parentContext.onBlockConnectionPointEntered(this, connectionPoint);
    }
    
    public void onConnectionPointReleased()
    {
        this.parentContext.onBlockConnectionPointReleased();
    }
    
    public void onConnectionPointDragged(Point relativeMouseLocation)
    {
        this.parentContext.onBlockConnectionPointDragged(relativeMouseLocation);
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
