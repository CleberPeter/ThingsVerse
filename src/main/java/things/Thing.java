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
import customWidgets.RoundedLineBorder;
import element.Element;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;
import mouseAdapters.ComponentSelect;
import mouseAdapters.ConnectionPointsMover;
import things.connectionPoints.SensingConnectionPoint;

/**
 *
 * @author cleber
 */
public abstract class Thing extends Element
{
    private static final Color BACKGROUND_COLOR = new Color(30,30,30, 220);
    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
    private static final Color SELECTED_COLOR = new Color(240, 178, 61);

    private PanelRound panel;
    private JLabel titleLabel;
    private Context parentContext;

    private List<ConnectionPoint> connectionPointsList;
    
    private ComponentSelect componentSelect;
    private ComponentMover componentMover;
    private ComponentResizer componentResizer;
    private ConnectionPointsMover connectionPointsMover;
    
    public Thing(String name, Context parentContext)
    {   
        this.parentContext = parentContext;
        this.componentMover = new ComponentMover();
        this.componentResizer = new ComponentResizer();
        this.componentSelect = new ComponentSelect();
        
        initComponents(name);
        setUpLayout();
        initListeners();
    }
    
    private void initComponents(String name) 
    {
        connectionPointsList = new ArrayList<>();
        
        header_panel = new PanelRound();    
        header_panel.setRoundTop(20);
        header_panel.setBackground(Color.white);
                
        titleLabel = new JLabel();
        titleLabel.setText(name);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        main_panel = new PanelRound();
        main_panel.setRoundBottom(20);
        main_panel.setBackground(BACKGROUND_COLOR);
        
        panel = new PanelRound();    
        panel.setRoundDefault(20);
        panel.setBackground(TRANSPARENT_COLOR);
        
        setBackground(TRANSPARENT_COLOR);
        setName(name);
    }
    
    private void setUpLayout()
    {
        setLayout(new GridBagLayout());
        
        panel.setLayout(new GridBagLayout());
        
        header_panel.setLayout(new GridBagLayout());
        header_panel.setPreferredSize(new Dimension(0, 30));
        header_panel.setMinimumSize(new Dimension(0, 30));
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
                
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        header_panel.add(titleLabel, gridBagConstraints);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        panel.add(header_panel, gridBagConstraints);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        panel.add(main_panel, gridBagConstraints, 1);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(panel, gridBagConstraints, 1);
    }
    
    private void initListeners()
    {        
        connectionPointsMover = new ConnectionPointsMover(this);
        
        addComponentListener(this);
    }
    
    public void setScale(double factor)
    {
        Dimension d = this.dimension;
        Dimension scaled_d = new Dimension((int)(d.width*factor), (int)(d.height*factor));
        this.setPreferredSize(scaled_d);
        this.setSize(scaled_d);
        
        this.parentContext.onChildScaled(this, factor);
        
        for (ConnectionPoint connectionPoint : connectionPointsList) 
        {
            connectionPoint.setScale(factor);
        }
    }
    
    public void enableSelect(boolean enable)
    {        
        if (enable)
        {
            Function onSelected = (Object t) -> {
                setSelected(!selected);
                                
                return null;
            };
            
            componentSelect.registerComponent(onSelected, this);
        }
        else componentSelect.deregisterComponent(this);   
    }
    
    public void enableMove(boolean enable)
    {        
        if (enable)
        {
            Function onMoved = (Object t) -> {
                if (this.parentContext != null) this.parentContext.onChildMoved(this);
                
                return null;
            };

            componentMover.registerComponent(onMoved, this);
            componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        }
        else componentMover.deregisterComponent(this);   
    }
    
    public void enableResize(boolean enable)
    {        
        if (enable)
        {
            Function onResized = (Object t) -> {
                Dimension newDimension = new Dimension(getWidth(), getHeight());
                        
                this.dimension = newDimension;
                setPreferredSize(this.dimension);
                revalidate();
                
                // insets can be changed after resize
                if (this.parentContext != null) this.parentContext.onChildMoved(this);
                
                return null;
            };
            
            componentResizer.registerComponent(onResized, this);
            componentResizer.setDragInsets(new Insets(10, 10, 10, 10));
        }
        else componentResizer.deregisterComponent(this);   
    }
        
    public void setSelected(boolean selected)
    {
        this.selected = selected;
        Border border = null;
        
        // if (this.selected) border = new LineBorder(SELECTED_COLOR, 3);
        
        if (this.selected) border = new RoundedLineBorder(SELECTED_COLOR, 3, 20);
            
        this.panel.setBorder(border);
    }
    
    protected void setConnectionPoint(ConnectionPoint connectionPoint) 
    {           
        connectionPointsList.add(connectionPoint);
        add(connectionPoint, connectionPoint.getConstraints(), 0);
        
        connectionPointsMover.registerComponent(connectionPoint);
    }
    
    private int getConnectionPointsCount(int anchor)
    {
        return getConnectionPointsList(anchor).size();
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
    
    private void removeUnusedConnectionPoints()
    {
        // iterator prevents java.util.ConcurrentModificationException
        for (Iterator<ConnectionPoint> iterator = connectionPointsList.iterator(); iterator.hasNext();) 
        {
            ConnectionPoint connectionPoint = iterator.next();
            
            if (connectionPoint instanceof UnusedConnectionPoint)
            {
                remove(connectionPoint);
                iterator.remove();
            }
        }
    }
    
    public void swapConnectionPoints(ConnectionPoint cp1, ConnectionPoint cp2)
    {
        GridBagLayout layout = (GridBagLayout) getLayout();
        
        GridBagConstraints cp1Constraints = cp1.getConstraints();
        GridBagConstraints cp2Constraints = cp2.getConstraints();
        
        layout.setConstraints(cp1, cp2Constraints);
        cp1.setConstraints(cp2Constraints);
        
        layout.setConstraints(cp2, cp1Constraints);
        cp2.setConstraints(cp1Constraints);
                
        revalidate();
        parentContext.onThingConnectionPointMoved();
    }
    
    public ConnectionPoint UpdateConnectionPoint(ConnectionPoint connectionPointToUpdate, ConnectionPoint connectionPointToCopy)
    {
        ConnectionPoint newConnectionPoint = null;

        if (connectionPointToCopy instanceof EventConnectionPoint)
        {
            newConnectionPoint = new ActionConnectionPoint(connectionPointToUpdate.getParentThing(), connectionPointToCopy.getName(), connectionPointToUpdate.getConstraints());
        }
        else if (connectionPointToCopy instanceof ActionConnectionPoint)
        {
            newConnectionPoint = new EventConnectionPoint(connectionPointToUpdate.getParentThing(), connectionPointToCopy.getName(), connectionPointToUpdate.getConstraints());
        }
        else if (connectionPointToCopy instanceof PropertyConnectionPoint)
        {
            newConnectionPoint = new PropertyConnectionPoint(connectionPointToUpdate.getParentThing(), connectionPointToCopy.getName(), connectionPointToUpdate.getConstraints(), true);
        }
        else if (connectionPointToCopy instanceof SensingConnectionPoint)
        {
            newConnectionPoint = new ActuatorConnectionPoint(connectionPointToUpdate.getParentThing(), connectionPointToCopy.getName(), connectionPointToUpdate.getConstraints());
        }
        else if (connectionPointToCopy instanceof ActuatorConnectionPoint)
        {
            newConnectionPoint = new SensingConnectionPoint(connectionPointToUpdate.getParentThing(), connectionPointToCopy.getName(), connectionPointToUpdate.getConstraints());
        }
        newConnectionPoint.setColor(connectionPointToCopy.getColor());
        connectionPointsList.remove(connectionPointToUpdate);
        connectionPointsList.add(newConnectionPoint);

        GridBagLayout layout = (GridBagLayout) getLayout();
        GridBagConstraints connectionPointToUpdateConstraints = layout.getConstraints(connectionPointToUpdate);

        remove(connectionPointToUpdate);

        connectionPointsMover.registerComponent(newConnectionPoint);
        add(newConnectionPoint, connectionPointToUpdateConstraints, 0);

        validate();

        parentContext.onThingConnectionPointMoved();
     
        return newConnectionPoint;
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

            for (int i = 1; i <= connectionPointsLen; i++)
            {
                boolean filled = false;
                int topInset = i*50;
                
                List<ConnectionPoint> connectionPointList = getConnectionPointsList(anchor);
                
                for (ConnectionPoint connectionPoint : connectionPointList)
                {
                    if (connectionPoint.getConstraints().insets.top == topInset) 
                    {
                        filled = true;
                        break;
                    }
                }
                
                if (!filled) 
                {
                    gridBagConstraints.insets = new Insets(topInset, 0, 0, 0);
                    gridBagConstraints.anchor = anchor;

                    ConnectionPoint unusedConnectionPoint = new UnusedConnectionPoint(this, gridBagConstraints);

                    connectionPointsList.add(unusedConnectionPoint);
                    add(unusedConnectionPoint, gridBagConstraints, 0);
                }
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
    
    public List<ConnectionPoint> getConnectionPointsList(int anchor)
    {
        List<ConnectionPoint> retList = new ArrayList<>();
        for (ConnectionPoint connectionPoint : connectionPointsList)
        {            
            if (connectionPoint.getConstraints().anchor == anchor) retList.add(connectionPoint);
        }
        return retList;
    }
    
    public Point getConnectionPointContextRelativeLocation(ConnectionPoint connectionPoint)
    {
        Point thingLocation = getLocation();
        Point thingRelativeLocationClicked = connectionPoint.getConnectionPanelThingRelativeLocation();
        
        return new Point(thingRelativeLocationClicked.x + thingLocation.x, thingRelativeLocationClicked.y + thingLocation.y + header_panel.getHeight());
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
        this.parentContext.onThingConnectionPointPressed(this, connectionPoint);
    }
    
    public void onConnectionPointEntered(ConnectionPoint connectionPoint)
    {
        this.parentContext.onThingConnectionPointEntered(this, connectionPoint);
    }
    
    public void onConnectionPointReleased()
    {
        this.parentContext.onThingConnectionPointReleased();
    }
    
    public void onConnectionPointExited()
    {
        this.parentContext.onThingConnectionPointExited();
    }
    
    public void onConnectionPointDragged(Point relativeMouseLocation)
    {
        this.parentContext.onThingConnectionPointDragged(relativeMouseLocation);
    }
    
    @Override
    public void componentResized(ComponentEvent ce) 
    {
        populateConnectionPoints();
        if (this.dimension == null) 
        {
            this.dimension = this.getPreferredSize();
            if (this.parentContext != null)
            {
                GridBagConstraints constraints = this.parentContext.getConstraints(this); 
                
                this.insets = constraints.insets;
            }
        }
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
