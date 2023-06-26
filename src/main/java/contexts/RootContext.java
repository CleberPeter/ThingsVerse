/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contexts;

import adapters.AirToTemperatureAdapter;
import agents.Agent;
import customWidgets.GridBackground;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;
import objects.DoorObject;
import things.AirConditioning;
import things.ContextThingConnectionPoint;
import things.DoorController;
import things.Thing;
import things.ThingConnectionCurve;
import things.connectionPoints.ConnectionPoint;
import things.connectionPoints.UnusedConnectionPoint;
import variables.TemperatureVariable;
import variables.VolumeVariable;

/**
 *
 * @author cleber
 */
public class RootContext extends JLayeredPane implements ComponentListener
{
    private ThingConnectionCurve routingCurve;
    private Point routingCurveEndPointPreview;
    private List<ThingConnectionCurve> connectionCurveList;
    private Boolean isRouting;
    
    private GridBackground gridBackground;
    
    public RootContext()
    {
        this.connectionCurveList = new ArrayList<>();
        this.routingCurve = new ThingConnectionCurve(null);
        this.isRouting = false;
        
        setLayout(new GridBagLayout());
        setBackground(new java.awt.Color(42, 42, 42));
        setOpaque(true);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        
        gridBackground = new GridBackground();
        gridBackground.setcellSize(50);
        gridBackground.setBackground(new java.awt.Color(0, 0, 0));
        
        add(gridBackground, gridBagConstraints, JLayeredPane.DEFAULT_LAYER);
        gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
        
        // HOUSE CONTEXT
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Context houseContext = new Context(this, null);
        houseContext.setTitle("House");
        houseContext.setPreferredSize(new Dimension(1700, 850));
        houseContext.setMinimumSize(new Dimension(1700, 850));
        houseContext.setColor(Color.white);
        
        DoorController doorController = new DoorController(houseContext);
        
        gridBagConstraints.insets = new java.awt.Insets(30, 1200, 0, 0);
        houseContext.addThing(doorController, gridBagConstraints);
        
        Agent agent = new Agent(houseContext, "Bob");
        
        gridBagConstraints.insets = new java.awt.Insets(400, 1450, 0, 0);
        houseContext.addThing(agent, gridBagConstraints);
        
        DoorObject doorObject = new DoorObject(houseContext);
        
        gridBagConstraints.insets = new java.awt.Insets(400, 1200, 0, 0);
        houseContext.addThing(doorObject, gridBagConstraints);
        

        // LIVING ROOM CONTEXT
        Context livingRoomContext = new Context(this, houseContext);
        livingRoomContext.setTitle("Living Room");
        livingRoomContext.setPreferredSize(new Dimension(1000, 768));
        livingRoomContext.setMinimumSize(new Dimension(1000, 768));
        livingRoomContext.setColor(Color.white);
        
        VolumeVariable volume = new VolumeVariable(livingRoomContext);
        
        gridBagConstraints.insets = new java.awt.Insets(50, 400, 0, 0);
        livingRoomContext.addThing(volume, gridBagConstraints);
        
        AirConditioning airConditioning = new AirConditioning(livingRoomContext);
        
        gridBagConstraints.insets = new java.awt.Insets(200, 100, 0, 0);
        livingRoomContext.addThing(airConditioning, gridBagConstraints);
        
        AirToTemperatureAdapter air_to_temp = new AirToTemperatureAdapter(livingRoomContext);
        
        gridBagConstraints.insets = new java.awt.Insets(200, 600, 0, 0);
        livingRoomContext.addThing(air_to_temp, gridBagConstraints);
        
        TemperatureVariable temperature = new TemperatureVariable(livingRoomContext);
        
        gridBagConstraints.insets = new java.awt.Insets(500, 400, 0, 0);
        livingRoomContext.addThing(temperature, gridBagConstraints);
        
        
        gridBagConstraints.insets = new java.awt.Insets(50, 50, 0, 0);
        houseContext.addContext(livingRoomContext, gridBagConstraints);
        
        houseContext.addComponentListener(this);
        
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        add(houseContext, gridBagConstraints, JLayeredPane.DEFAULT_LAYER);
    }
    
    public void onThingConnectionPointPressed(Context context, Thing thing, ConnectionPoint connectionPoint)
    {
        ContextThingConnectionPoint contextThingConnectionPoint = new ContextThingConnectionPoint(context, thing, connectionPoint);
        
        if (!this.isRouting)
        {
            this.isRouting = true;
            routingCurve = new ThingConnectionCurve(contextThingConnectionPoint);
        }
    }
    
    public void onThingConnectionPointEntered(Context context, Thing thing, ConnectionPoint connectionPoint)
    {
        ContextThingConnectionPoint contextThingConnectionPoint = new ContextThingConnectionPoint(context, thing, connectionPoint);
        
        if (this.isRouting)
        {
            if (!routingCurve.getStartPoint().equals(contextThingConnectionPoint))
            {
                routingCurve.setEndPoint(contextThingConnectionPoint);
            }
        }
    }
    
    public void onThingConnectionPointExited()
    {
        if (this.isRouting) routingCurve.setEndPoint(null);
    }
    
    public void onThingConnectionPointReleased()
    {
        this.isRouting = false;
        
        if (routingCurve.isFilled())
        {
            ContextThingConnectionPoint endPoint = routingCurve.getEndPoint();
        
            ConnectionPoint endConnectionPoint = endPoint.getConnectionPoint();
            if (endConnectionPoint instanceof UnusedConnectionPoint)
            {
                Context context = endPoint.getContext();
                Thing thing = endPoint.getThing();
                
                ConnectionPoint newEndConnectionPoint = thing.UpdateConnectionPoint(endConnectionPoint, routingCurve.getStartPoint().getConnectionPoint());
                routingCurve.setEndPoint(new ContextThingConnectionPoint(context, thing, newEndConnectionPoint));
            }
            
            connectionCurveList.add(routingCurve);
        }   
        
        repaint(); // always repaint to clean preview curve
    }
    
    public void onThingConnectionPointMoved()
    {
        repaint();
    }
    
    public void onThingConnectionPointDragged(Point relativeMouseLocation)
    {        
        ContextThingConnectionPoint routingCurveStartPoint = routingCurve.getStartPoint();
        
        if (routingCurveStartPoint != null)
        {
            Point startPointContextRelativeLocation = routingCurveStartPoint.getLocation();
            
            relativeMouseLocation.x += startPointContextRelativeLocation.x;
            relativeMouseLocation.y += startPointContextRelativeLocation.y;

            routingCurveEndPointPreview = relativeMouseLocation;
            repaint();
        }
    }
     
    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        float strokeWidth = 3;
        Stroke stroke = new BasicStroke(strokeWidth);
        g2d.setStroke(stroke);
        
        for (ThingConnectionCurve connectionCurve : this.connectionCurveList)
        {
            drawConnectionCurve(g2d, connectionCurve);
        }
        
        if (this.isRouting)
        {
            if (routingCurve.isFilled())
            {
                drawConnectionCurve(g2d, routingCurve);
            }
            else
            {
                drawConnectionCurve(g2d, routingCurve.getStartPoint(), routingCurveEndPointPreview);
            }
        }
    }
    
    private void drawConnectionCurve(Graphics2D g2d, ContextThingConnectionPoint startThingConnectionPoint, Point endPoint) 
    {
        g2d.setColor(startThingConnectionPoint.getConnectionPoint().getColor());
                        
        Point startPoint = startThingConnectionPoint.getLocation();

        int dx = Math.abs(endPoint.x - startPoint.x);
        dx = Math.max(75, dx);

        int cp1_dx = startThingConnectionPoint.getConnectionPoint().getConstraints().anchor ==  java.awt.GridBagConstraints.NORTHWEST ? -dx : dx;
        int cp2_dx = startPoint.x < endPoint.x ? -dx : dx;
        
        drawConnectionCurve(g2d, startPoint, endPoint, cp1_dx, cp2_dx);
    }
    
    private void drawConnectionCurve(Graphics2D g2d, ThingConnectionCurve connectionCurve) 
    {
        ContextThingConnectionPoint startThingConnectionPoint = connectionCurve.getStartPoint();
        ContextThingConnectionPoint endThingConnectionPoint = connectionCurve.getEndPoint();
        
        g2d.setColor(startThingConnectionPoint.getConnectionPoint().getColor());
                        
        Point startPoint = startThingConnectionPoint.getLocation();
        Point endPoint = endThingConnectionPoint.getLocation();

        int dx = Math.abs(endPoint.x - startPoint.x);
        dx = Math.max(75, dx);

        int cp1_dx = startThingConnectionPoint.getConnectionPoint().getConstraints().anchor ==  java.awt.GridBagConstraints.NORTHWEST ? -dx : dx;
        int cp2_dx = endThingConnectionPoint.getConnectionPoint().getConstraints().anchor ==  java.awt.GridBagConstraints.NORTHWEST ? -dx : dx;

        drawConnectionCurve(g2d, startPoint, endPoint, cp1_dx, cp2_dx);
    }
    
    private void drawConnectionCurve(Graphics2D g2d, Point startPoint, Point endPoint, int cp1_dx, int cp2_dx) 
    {        
        Point controlPoint1 = new Point(startPoint.x + cp1_dx, startPoint.y);
        Point controlPoint2 = new Point(endPoint.x + cp2_dx, endPoint.y);

        CubicCurve2D curve = new CubicCurve2D.Float(startPoint.x, startPoint.y, controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, endPoint.x, endPoint.y); 
        g2d.draw(curve);
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

    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        
        gridBagConstraints.insets = new Insets(ce.getComponent().getY(), ce.getComponent().getX(), 0, 0);
        
        GridBagLayout layout = (GridBagLayout) getLayout();
        layout.setConstraints(ce.getComponent(), gridBagConstraints);    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
}
