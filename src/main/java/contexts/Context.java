/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contexts;

import things.ThingConnectionCurve;
import things.ThingConnectionPoint;
import things.Thing;
import things.connectionPoints.ConnectionPoint;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;
import customWidgets.PanelRound;
import java.awt.BasicStroke;
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
import java.awt.Stroke;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import things.connectionPoints.UnusedConnectionPoint;

/**
 *
 * @author cleber
 */
public class Context extends PanelRound implements ComponentListener {
    
    private static final String DEFAULT_TITLE = "Contexto A";
    private static final Color DEFAULT_COLOR = Color.WHITE;

    private PanelRound header_panel;
    private Color color;
    
    private JLabel titleLabel;
    private String title;
    
    private Boolean isRouting;
    private ThingConnectionCurve routingCurve;
    private Point routingCurveEndPointPreview;
    
    private List<ThingConnectionCurve> connectionCurveList;
    private List<Thing> blockList;
    
    public Context() 
    {    
        this.isRouting = false;
        this.routingCurve = new ThingConnectionCurve(null);
        this.connectionCurveList = new ArrayList<>();
        this.blockList = new ArrayList<>();
        
        initComponents();
        initListeners();
        setUpLayout();    
    }
   
    private void initComponents()
    {
        setBackground(new Color(DEFAULT_COLOR.getRed(), DEFAULT_COLOR.getGreen(), DEFAULT_COLOR.getBlue(), 100));
        setRoundDefault(20);
        
        header_panel = new PanelRound();
        header_panel.setRoundTopLeft(20);
        header_panel.setRoundTopRight(20);
        header_panel.setBackground(DEFAULT_COLOR);
        
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
    
    public void onBlockConnectionPointPressed(Thing block, ConnectionPoint connectionPoint)
    {
        ThingConnectionPoint blockConnectionPoint = new ThingConnectionPoint(block, connectionPoint);
        
        if (!this.isRouting)
        {
            this.isRouting = true;
            routingCurve = new ThingConnectionCurve(blockConnectionPoint);
        }
    }
    
    public void onBlockConnectionPointEntered(Thing block, ConnectionPoint connectionPoint)
    {
        ThingConnectionPoint blockConnectionPoint = new ThingConnectionPoint(block, connectionPoint);
        
        if (this.isRouting)
        {
            if (!routingCurve.getStartPoint().equals(blockConnectionPoint))
            {
                routingCurve.setEndPoint(blockConnectionPoint);
            }
        }
    }
    
    public void onBlockConnectionPointReleased()
    {
        this.isRouting = false;
        
        ThingConnectionPoint endPoint = routingCurve.getEndPoint();
        if (endPoint != null)
        {
            ConnectionPoint endConnectionPoint = endPoint.getConnectionPoint();
            if (endConnectionPoint instanceof UnusedConnectionPoint)
            {
                Thing thing = endPoint.getThing();
                thing.UpdateConnectionPoint(endConnectionPoint, routingCurve.getStartPoint().getConnectionPoint());
            }
            
            
            connectionCurveList.add(routingCurve);
        }   
        
        repaint(); // always repaint to clean preview curve
    }
    
    public void addBlock(Thing block, GridBagConstraints gridBagConstraints)
    {
        add(block, gridBagConstraints);
        block.addComponentListener(this);
        
        this.blockList.add(block);
        
//        if (connectionCurveList.isEmpty())
//        {
//            Thing b1 = getThing("Ar Condicionado -> Temperatura");
//            if (b1 != null)
//            {
//                ConnectionPoint cp1 = b1.getConnectionPoint("dT/dt");
//                if (cp1 != null)
//                {
//                    Thing b2 = getThing("Temperatura");
//                    if (b2 != null)
//                    {
//                        ConnectionPoint cp2 = b2.getConnectionPoint("dT/dt");
//                        if (cp2 != null)
//                        {
//                            routingCurve = new ThingConnectionCurve(new ThingConnectionPoint(b1, cp1));
//                            routingCurve.setEndPoint(new ThingConnectionPoint(b2, cp2));
//
//                            connectionCurveList.add(routingCurve);
//                            repaint();
//                        }
//                    }
//                }
//            }
//        }
    }
    
    public void onBlockConnectionPointMoved()
    {
        repaint();
    }
    
    public void onBlockConnectionPointDragged(Point relativeMouseLocation)
    {        
        ThingConnectionPoint routingCurveStartPoint = routingCurve.getStartPoint();
        
        if (routingCurveStartPoint != null)
        {
            Point startPointContextRelativeLocation = routingCurveStartPoint.getContextRelativeLocation();
            relativeMouseLocation.x += startPointContextRelativeLocation.x;
            relativeMouseLocation.y += startPointContextRelativeLocation.y;

            routingCurveEndPointPreview = relativeMouseLocation;
            repaint();
        }
    }
    
    public Thing getBlock(String name)
    {
        for (Thing block : blockList)
        {
            if (block.getName().equals(name)) return block;
        }
        
        return null;
    }
    
    @Override
    public void componentResized(ComponentEvent ce) 
    {
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
        
        repaint();
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
    
     @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        float strokeWidth = 3;
        Stroke stroke = new BasicStroke(strokeWidth);
        g2d.setStroke(stroke);
        
        for (ThingConnectionCurve connectionCurve : this.connectionCurveList)
        {
            g2d.setColor(connectionCurve.getStartPoint().getConnectionPoint().getColor());
            
            Point startPoint = connectionCurve.getStartPoint().getContextRelativeLocation();
            Point endPoint = connectionCurve.getEndPoint().getContextRelativeLocation();

            int cp1_dx = connectionCurve.getStartPoint().getConnectionPoint().getAnchor() ==  java.awt.GridBagConstraints.NORTHWEST ? -200 : 200;
            int cp2_dx = connectionCurve.getEndPoint().getConnectionPoint().getAnchor() ==  java.awt.GridBagConstraints.NORTHWEST ? -200 : 200;

            drawCurve(g2d, startPoint, endPoint, cp1_dx, cp2_dx);
        }
        
        if (this.isRouting)
        {
            Point startPoint = routingCurve.getStartPoint().getContextRelativeLocation();
            Point endPoint = routingCurveEndPointPreview;
            
            g2d.setColor(routingCurve.getStartPoint().getConnectionPoint().getColor());

            int cp1_dx = routingCurve.getStartPoint().getConnectionPoint().getAnchor() ==  java.awt.GridBagConstraints.NORTHWEST ? -200 : 200;
            int cp2_dx = startPoint.x < endPoint.x ? -200 : 200;
            
            drawCurve(g2d, startPoint, endPoint, cp1_dx, cp2_dx);
        }
    }
    
    private void drawCurve(Graphics2D g2d, Point startPoint, Point endPoint, int cp1_dx, int cp2_dx) 
    {
        Point controlPoint1 = new Point(startPoint.x + cp1_dx, startPoint.y);
        Point controlPoint2 = new Point(endPoint.x + cp2_dx, endPoint.y);

        g2d.draw(new CubicCurve2D.Float(startPoint.x, startPoint.y, controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, endPoint.x, endPoint.y));
        //drawArrowHead(g2d, endPoint, controlPoint2);
    }
    
    private void drawArrowHead(Graphics2D g2d, Point endPoint, Point intermediatePoint) 
    {
        /* clone to not dirty */
        Point tail = (Point) intermediatePoint.clone();
        Point head = (Point) endPoint.clone(); 
        
        double angle = Math.atan2(head.y - tail.y, head.x - tail.x);
        int arrowSize = 24;
        
        head.x -= (arrowSize*0.4) * Math.cos(angle);
        head.y -= (arrowSize*0.4) * Math.sin(angle);
        
        int x1 = (int) (head.x - (arrowSize) * Math.cos(angle + Math.PI / 6));
        int y1 = (int) (head.y - (arrowSize) * Math.sin(angle + Math.PI / 6));
        int x2 = (int) (head.x - (arrowSize) * Math.cos(angle - Math.PI / 6));
        int y2 = (int) (head.y - (arrowSize) * Math.sin(angle - Math.PI / 6));

        int[] xPoints = {head.x, x1, x2};
        int[] yPoints = {head.y, y1, y2};
        
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}
