/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contexts;

import things.Thing;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;
import customWidgets.PanelRound;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import main.MainFrame;
import things.connectionPoints.ConnectionPoint;

/**
 *
 * @author cleber
 */
public class Context extends JLayeredPane implements ComponentListener {
    
    private static final String DEFAULT_TITLE = "Contexto A";
    private static final Color DEFAULT_COLOR = Color.WHITE;

    private PanelRound header_panel;
    private PanelRound main_panel;
    private Color color;
    
    private JLabel titleLabel;
    private String title;
    
    private List<Thing> thingList;
    private List<Context> contextList;
    private RootContext rootContext;
    private Context parentContext;
    
    public Context(RootContext rootContext, Context parentContext)
    {    
        this.thingList = new ArrayList<>();
        this.contextList = new ArrayList<>();
        this.rootContext = rootContext;
        this.parentContext = parentContext;
        
        initComponents();
        initListeners();
        setUpLayout();    
    }
   
    private void initComponents()
    {
        // setBackground(new Color(DEFAULT_COLOR.getRed(), DEFAULT_COLOR.getGreen(), DEFAULT_COLOR.getBlue(), 100));
        //setRoundDefault(20);
        
        header_panel = new PanelRound();
        header_panel.setRoundTopLeft(20);
        header_panel.setRoundTopRight(20);
        header_panel.setBackground(DEFAULT_COLOR);
        
        main_panel = new PanelRound();
        main_panel.setRoundBottomLeft(20);
        main_panel.setRoundBottomRight(20);
        main_panel.setBackground(new Color(DEFAULT_COLOR.getRed(), DEFAULT_COLOR.getGreen(), DEFAULT_COLOR.getBlue(), 100));
        
        titleLabel = new JLabel();
        titleLabel.setText(DEFAULT_TITLE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));   
    }
    
    private void initListeners()
    {
        ComponentMover componentMover = new ComponentMover();
        componentMover.registerComponent(this);
        componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        
        ComponentResizer componentResizer = new ComponentResizer(new Insets(10, 10, 10, 10), this);
        componentResizer.setSnapSize(new Dimension(15, 15));
        
        addComponentListener(this);
    }
    
    private void setUpLayout()
    {
        setLayout(new GridBagLayout());
        
        header_panel.setLayout(new java.awt.GridBagLayout());
        
        Dimension header_dimension = new Dimension(0, 30); // width = 0 will be repleaced by fill horizontal on gridBagConstraints
        header_panel.setPreferredSize(header_dimension);
        header_panel.setMinimumSize(header_dimension);
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
        add(header_panel, gridBagConstraints);
        
        
        main_panel.setLayout(new java.awt.GridBagLayout());
        
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(main_panel, gridBagConstraints);
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
    
    public void addContext(Context context, GridBagConstraints gridBagConstraints)
    {
        main_panel.add(context, gridBagConstraints);
        context.addComponentListener(this);
        
        this.contextList.add(context);
    }
    
    public void addThing(Thing thing, GridBagConstraints gridBagConstraints)
    {
        main_panel.add(thing, gridBagConstraints);
        thing.addComponentListener(this);
        
        this.thingList.add(thing);
    }
    
    
    public Thing getBlock(String name)
    {
        for (Thing block : thingList)
        {
            if (block.getName().equals(name)) return block;
        }
        
        return null;
    }
    
    public Point getMainFrameRelativeLocation(Point childrenLocation)
    {
        Point contextLocation = this.getLocation();
        Point parentRelativeLocation = new Point(childrenLocation.x + contextLocation.x, childrenLocation.y + contextLocation.y);
        
        if (this.parentContext == null) return parentRelativeLocation;
        else 
        {
            parentRelativeLocation.y += this.header_panel.getHeight();
            return this.parentContext.getMainFrameRelativeLocation(parentRelativeLocation);
        }
    }
    
    public Point getMainFrameRelativeLocation(Thing thing, ConnectionPoint connectionPoint)
    {
        Point connectionPointContextRelativeLocation = thing.getConnectionPointContextRelativeLocation(connectionPoint);
        return getMainFrameRelativeLocation(connectionPointContextRelativeLocation);
    }
    
    public void onThingConnectionPointPressed(Thing thing, ConnectionPoint connectionPoint)
    {
        this.rootContext.onThingConnectionPointPressed(this, thing, connectionPoint);
    }
    
    public void onThingConnectionPointEntered(Thing thing, ConnectionPoint connectionPoint)
    {
        this.rootContext.onThingConnectionPointEntered(this, thing, connectionPoint);
    }
    
    public void onThingConnectionPointExited()
    {
        this.rootContext.onThingConnectionPointExited();
    }
    
    public void onThingConnectionPointReleased()
    {
        this.rootContext.onThingConnectionPointReleased();
    }
    
    public void onThingConnectionPointMoved()
    {
        this.rootContext.onThingConnectionPointMoved();
    }
    
    public void onThingConnectionPointDragged(Point relativeMouseLocation)
    {        
        this.rootContext.onThingConnectionPointDragged(relativeMouseLocation);
    }
    
    @Override
    public void componentResized(ComponentEvent ce) 
    {       
//        System.out.println("PreferredSize: " + ce.getComponent().getPreferredSize());
//        System.out.println("width: " + ce.getComponent().getWidth());
//        System.out.println("HEIGHT: " + ce.getComponent().getHeight());
//        System.out.println("#######################");
//        // ce.getComponent().setPreferredSize(new Dimension(ce.getComponent().getWidth(),ce.getComponent().getHeight()));
    }

    @Override
    public void componentMoved(ComponentEvent ce) 
    {           
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        
        gridBagConstraints.insets = new Insets(ce.getComponent().getY(), ce.getComponent().getX(), 0, 0);
        
        GridBagLayout layout = (GridBagLayout) getLayout();
        layout.setConstraints(ce.getComponent(), gridBagConstraints);
        
        rootContext.onThingConnectionPointMoved();
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
}
