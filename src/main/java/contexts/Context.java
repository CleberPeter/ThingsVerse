/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contexts;

import things.Thing;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;
import customWidgets.PanelRound;
import customWidgets.RoundedLineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import mouseAdapters.ComponentSelect;
import things.connectionPoints.ConnectionPoint;

/**
 *
 * @author cleber
 */
public class Context extends JLayeredPane implements ComponentListener {
    
    private static final String DEFAULT_TITLE = "Contexto A";
    private static final Color DEFAULT_COLOR = Color.WHITE;
    private static final Color SELECTED_COLOR = new Color(240, 178, 61);

    private PanelRound header_panel;
    private PanelRound main_panel;
    private Color color;
    
    private JLabel titleLabel;
    private String title;
    private Boolean selected = false;
    
    private List<Thing> thingList;
    private List<Context> contextList;
    public RootContext rootContext;
    private Context parentContext;

    private ComponentSelect componentSelect;
    private ComponentMover componentMover;
    private ComponentResizer componentResizer;

    public Context(RootContext rootContext, Context parentContext)
    {    
        this.thingList = new ArrayList<>();
        this.contextList = new ArrayList<>();
        this.rootContext = rootContext;
        this.parentContext = parentContext;
        
        this.componentMover = new ComponentMover();
        this.componentResizer = new ComponentResizer();
        this.componentSelect = new ComponentSelect();
        
        initComponents();
        initListeners();
        setUpLayout();    
    }
   
    private void initComponents()
    {
        // setBackground(new Color(DEFAULT_COLOR.getRed(), DEFAULT_COLOR.getGreen(), DEFAULT_COLOR.getBlue(), 100));
        //setRoundDefault(20);
        
        header_panel = new PanelRound();
        header_panel.setRoundTop(20);
        header_panel.setBackground(DEFAULT_COLOR);
        
        main_panel = new PanelRound();
        main_panel.setRoundBottom(20);
        main_panel.setBackground(new Color(DEFAULT_COLOR.getRed(), DEFAULT_COLOR.getGreen(), DEFAULT_COLOR.getBlue(), 100));
        
        titleLabel = new JLabel();
        titleLabel.setText(DEFAULT_TITLE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));   
    }
    
    private void initListeners()
    {
        addComponentListener(this);
    }
    
    public void enableMove(boolean enable)
    {        
        if (enable)
        {
            Function onMoved = (Object t) -> {
                if (this.parentContext != null) this.parentContext.onChildMoved(this);
                else this.rootContext.onChildMoved(this);
                
                return null;
            };

            componentMover.registerComponent(onMoved, this);
            componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        }
        else componentMover.deregisterComponent(this);
        
        for (Thing thing : thingList)
        {
            thing.enableMove(enable);
        }
        
        for (Context context : contextList)
        {
            context.enableMove(enable);
        }
    }
    
    public void enableResize(boolean enable)
    {       
        componentResizer.setSnapSize(new Dimension(15, 15));
        
        if (enable)
        {
            Function onResized = (Object t) -> {
                setPreferredSize(new Dimension(getWidth(), getHeight()));
                revalidate();
                
                // insets can be changed after resize
                if (this.parentContext != null) this.parentContext.onChildMoved(this);
                else this.rootContext.onChildMoved(this);
                
                return null;
            };
            
            componentResizer.registerComponent(onResized, this);
            componentResizer.setDragInsets(new Insets(10, 10, 10, 10));
        }
        else componentResizer.deregisterComponent(this);
        
        for (Thing thing : thingList)
        {
            thing.enableResize(enable);
        }
        
        for (Context context : contextList)
        {
            context.enableResize(enable);
        }
    }
    
    public void enableSelect(boolean enable)
    {       
        if (enable)
        {
            Function onSelect = (Object t) -> {
                setSelected(!selected);
                
                return null;
            };
            
            componentSelect.registerComponent(onSelect, this);
        }
        else componentSelect.deregisterComponent(this);
        
        for (Thing thing : thingList)
        {
            thing.enableSelect(enable);
        }
        
        for (Context context : contextList)
        {
            context.enableSelect(enable);
        }
    }
    
    public void setSelected(boolean selected)
    {
        this.selected = selected;
        
        Border border = null;
                
        if (this.selected) border = new RoundedLineBorder(SELECTED_COLOR, 3, 20);
        
        this.setBorder(border);
        
        for (Thing thing : thingList)
        {
            thing.setSelected(this.selected);
        }
        
        for (Context context : contextList)
        {
            context.setSelected(this.selected);
        }
    }
    
    private void setUpLayout()
    {
        setLayout(new GridBagLayout());
        
        header_panel.setLayout(new GridBagLayout());
        
        Dimension header_dimension = new Dimension(0, 30); // width = 0 will be repleaced by fill horizontal on gridBagConstraints
        header_panel.setPreferredSize(header_dimension);
        header_panel.setMinimumSize(header_dimension);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        
        header_panel.add(titleLabel, gridBagConstraints);
        
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(header_panel, gridBagConstraints);
        
        
        main_panel.setLayout(new GridBagLayout());
        
        gridBagConstraints.insets = new Insets(30, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
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
    
    public void onChildMoved(Component child)
    {        
        GridBagLayout layout = (GridBagLayout) main_panel.getLayout();
        GridBagConstraints thingConstraints = layout.getConstraints(child); 
                
        thingConstraints.insets.top = child.getY();
        thingConstraints.insets.left = child.getX();
        
        layout.setConstraints(child, thingConstraints);
        
        revalidate();
        rootContext.onThingConnectionPointMoved();
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
        rootContext.onThingConnectionPointMoved(); 
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }

}
