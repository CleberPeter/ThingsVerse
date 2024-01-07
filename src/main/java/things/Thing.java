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
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;
import mouseAdapters.ConnectionPointsMover;
import things.connectionPoints.SensingConnectionPoint;

/**
 *
 * @author cleber
 */
public abstract class Thing extends JLayeredPane implements ComponentListener
{
    private static final Color BACKGROUND_COLOR = new Color(30,30,30, 220);
    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
    private static final Color SELECTED_COLOR = new Color(240, 178, 61);

    private PanelRound main_panel;
    private PanelRound header_panel;
    private PanelRound panel;
    private JLabel titleLabel;
    private Context parentContext;
    private JButton expandBtn;
    
    private Boolean expanded;
    private Boolean selected = false;
    private String name;

    private List<ConnectionPoint> connectionPointsList;
    private ComponentMover componentMover;
    private ComponentResizer componentResizer;
    private ConnectionPointsMover connectionPointsMover;
    
    public Thing(String name, Context parentContext)
    {   
        this.parentContext = parentContext;
        this.expanded = true;
        this.componentMover = new ComponentMover();
        this.componentResizer = new ComponentResizer();
        
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
        
        /*
        expandBtn = new javax.swing.JButton();
        expandBtn.setBackground(new java.awt.Color(0, 0, 0));
        expandBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/expand_less_thing.png"))); // NOI18N
        expandBtn.setToolTipText("");
        expandBtn.setBorderPainted(false);
        expandBtn.setContentAreaFilled(false);
        expandBtn.setFocusPainted(false);
        expandBtn.setFocusable(false);
        expandBtn.setMaximumSize(new java.awt.Dimension(25, 25));
        expandBtn.setMinimumSize(new java.awt.Dimension(25, 25));
        expandBtn.setPreferredSize(new java.awt.Dimension(30, 25));
        
        expandBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expandBtnActionPerformed(evt);
            }
        });
        */
        
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
        
        /*gridBagConstraints.insets = new java.awt.Insets(2, 10, 0, 0);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        header_panel.add(expandBtn, gridBagConstraints);*/
        
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
    
    public void enableMove(boolean enable)
    {        
        if (enable)
        {
            Function onMovedEnd = (Object t) -> {
                if (this.parentContext != null) this.parentContext.onChildMoved(this);
                return null;
            };

            componentMover.registerComponent(onMovedEnd, this);
            componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        }
        else componentMover.deregisterComponent(this);   
    }
    public void enableResize(boolean enable)
    {        
        if (enable)
        {
            componentResizer.registerComponent(this);
            componentResizer.setDragInsets(new Insets(10, 10, 10, 10));
        }
        else componentResizer.deregisterComponent(this);   
    }
    
    /*
    private void expandLess(GridBagLayout layout, GridBagConstraints gridBagConstraintsHeaderPanel, int connectionPointsCountNorthWest, int connectionPointsCountNorthEast, int connectionPointsCount)
    {   
        int expandedLessHeight = connectionPointsCount*25 + 30;
        gridBagConstraintsHeaderPanel.anchor = java.awt.GridBagConstraints.CENTER;
        layout.setConstraints(header_panel, gridBagConstraintsHeaderPanel);
        header_panel.setBackground(Color.blue);

        setPreferredSize(new Dimension(getWidth(), expandedLessHeight));
        setMinimumSize(new Dimension(getWidth(), expandedLessHeight));

        main_panel.setVisible(false);
        
        int radiusArc = (expandedLessHeight - 20)/2;
        double leftAngle = Math.PI/2;
        double leftAngleStep = Math.PI/(connectionPointsCountNorthWest + 1);

        double rightAngle = Math.PI/2;
        double rightAngleStep = Math.PI/(connectionPointsCountNorthEast + 1);

        // sort from lowest to highest topInset to ensure that the vertical order is respected
        connectionPointsList.sort(new Comparator<ConnectionPoint>() {
            @Override
            public int compare(ConnectionPoint lhs, ConnectionPoint rhs) {
                return lhs.getConstraints().insets.top > rhs.getConstraints().insets.top ? 1 : -1;
            }
        });
        
        for (ConnectionPoint connectionPoint: connectionPointsList)
        {
            GridBagConstraints constraints = (GridBagConstraints) connectionPoint.getConstraints().clone(); // not dirty expanded constraints
                
            if (constraints.anchor == GridBagConstraints.NORTHWEST)
            {    
                leftAngle += leftAngleStep;
                constraints.insets.top = (radiusArc - ((int) (radiusArc * Math.sin(Math.PI - leftAngle))));
                constraints.insets.left = (radiusArc - ((int) (radiusArc * Math.cos(Math.PI - leftAngle))));

                layout.setConstraints(connectionPoint, constraints);
            }
            else if (constraints.anchor == GridBagConstraints.NORTHEAST)
            {
                rightAngle -= rightAngleStep;

                constraints.insets.top = (radiusArc - ((int) (radiusArc * Math.sin(Math.PI - rightAngle))));
                constraints.insets.right = (radiusArc - ((int) (radiusArc * -Math.cos(Math.PI - rightAngle))));

                layout.setConstraints(connectionPoint, constraints);
            }

            connectionPointsMover.deregisterComponent(connectionPoint);
            connectionPoint.hiddenName();
        }

        expandBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/expand_more_thing.png"))); // NOI18N
        this.expanded = false;
    }
    
    private void expandMore(GridBagLayout layout, GridBagConstraints gridBagConstraintsHeaderPanel, int connectionPointsCount)
    {
        main_panel.setVisible(true);
        componentMover.registerComponent(this);

        gridBagConstraintsHeaderPanel.anchor = java.awt.GridBagConstraints.NORTHWEST;
        layout.setConstraints(header_panel, gridBagConstraintsHeaderPanel);
        header_panel.setBackground(Color.white);

        int highestTopInset = 0;
        for (ConnectionPoint connectionPoint : connectionPointsList)
        {
            int connectionPointTopInset = connectionPoint.getConstraints().insets.top;
            if (connectionPointTopInset > highestTopInset) highestTopInset = connectionPointTopInset;
            
            layout.setConstraints(connectionPoint, connectionPoint.getConstraints());

            connectionPointsMover.registerComponent(connectionPoint);
            connectionPoint.showName();
        }
        
        setPreferredSize(new Dimension(getWidth(), highestTopInset + 50));
        setMinimumSize(new Dimension(getWidth(), highestTopInset + 50));

        expandBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/expand_less_thing.png"))); // NOI18N
        this.expanded = true;
    }
    */
    
    public void setSelected(boolean selected)
    {
        this.selected = selected;
        Border border = null;
        
        // if (this.selected) border = new LineBorder(SELECTED_COLOR, 3);
        
        if (this.selected) border = new RoundedLineBorder(SELECTED_COLOR, 3, 20);
            
        this.panel.setBorder(border);
    }
    
    /*private void expandBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        GridBagLayout layout = (GridBagLayout) getLayout();
        GridBagConstraints gridBagConstraintsHeaderPanel = layout.getConstraints(header_panel);
        
        removeUnusedConnectionPoints();

        int connectionPointsCountNorthWest = getConnectionPointsCount(GridBagConstraints.NORTHWEST);
        int connectionPointsCountNorthEast = getConnectionPointsCount(GridBagConstraints.NORTHEAST);
        int connectionPointsCount = Math.max(connectionPointsCountNorthWest, connectionPointsCountNorthEast);
        
        if (this.expanded)
        {
            expandLess(layout, gridBagConstraintsHeaderPanel, connectionPointsCountNorthWest, connectionPointsCountNorthEast, connectionPointsCount);
        }
        else
        {
            expandMore(layout, gridBagConstraintsHeaderPanel, connectionPointsCount);
        }
        
        parentContext.onThingConnectionPointMoved();
    }   */  
    
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
        if (this.expanded)
        {
            int usable_height = this.getHeight() - 50;
            int connectionPointsLen = usable_height/50;

            removeInvisibleConnectionPoints(usable_height);

            fillWithUnusedConnectionPoints(connectionPointsLen, java.awt.GridBagConstraints.NORTHWEST);
            fillWithUnusedConnectionPoints(connectionPointsLen,java.awt.GridBagConstraints.NORTHEAST);

            validate();
        }
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
    
    @Override
    public void paintComponent(Graphics graphics) {
        
        super.paintComponent(graphics);
        Graphics2D graphics_2d = (Graphics2D) graphics.create();
                
        if (!this.expanded)
        {
            graphics_2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics_2d.setColor(Color.white);
            
            int width = getWidth();
            int height = getHeight();
            int radiusArc = (height - 20)/2;
                        
            graphics_2d.fillArc(10, 10, radiusArc * 2, height-20, 90, 180); // left arc
            graphics_2d.fillArc(width - 10 - radiusArc * 2, 10, radiusArc * 2, height-20, 90, -180); // right arc

            graphics_2d.fillRect(radiusArc + 10, 10, width - 20 - radiusArc*2, height-20);
        }
    }
    
    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);

        if (e.getID() == MouseEvent.MOUSE_CLICKED) 
        {    
            if (this.parentContext.rootContext.toolsEnabled.selectIsEnabled())
            {
                setSelected(!selected);
            }
        }
    }
}
