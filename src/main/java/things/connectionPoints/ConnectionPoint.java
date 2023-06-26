/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things.connectionPoints;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import things.Thing;

/**
 *
 * @author cleber
 */
public abstract class ConnectionPoint extends JPanel implements MouseListener, MouseMotionListener
{
    private String name;
    private JPanel connectionPanel;
    private JLabel name_label;
    private Thing parentThing;
    private GridBagConstraints constraints;
    
    public abstract void onConstraintsUpdated();
    public abstract Color getColor();
    public abstract void setColor(Color color);
    
    public ConnectionPoint(Thing parentThing, String name, GridBagConstraints constraints, JPanel connectionPanel)
    {
        this.parentThing = parentThing;
        this.name = name;
        
        setLayout(new GridBagLayout());
        
        this.connectionPanel = connectionPanel;
        this.connectionPanel.addMouseListener(this);
        this.connectionPanel.addMouseMotionListener(this);
        add(this.connectionPanel);
        
        if (name != null)
        {
            name_label = new JLabel();
            name_label.setFont(new Font("Arial", Font.BOLD, 14));
            name_label.setForeground(Color.white);
            name_label.setText(this.name);

            add(name_label);

            setName(this.name);
        }
        
        setConstraints(constraints);
        setOpaque(false);    
    }
    
    public Thing getParentThing()
    {
        return this.parentThing;
    }
    
    public GridBagConstraints getConstraints()
    {
        return this.constraints;
    }
    
    public void hiddenName()
    {
        if (name_label != null) name_label.setText("");
    }
    
    public void showName()
    {
        if (this.name != null) name_label.setText(this.name);
    }
    
    public JPanel getConnectionPanel()
    {
        return connectionPanel;
    }
    
    public void setConstraints(GridBagConstraints constraints)
    {
        if ((this.constraints == null || constraints.anchor != this.constraints.anchor) && name != null)
        {
            GridBagLayout gridBagLayout = (GridBagLayout) getLayout();
        
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.weighty = 0.5;
            gridBagConstraints.anchor = constraints.anchor;
            
            gridBagLayout.setConstraints(this.connectionPanel, gridBagConstraints);
            
            if (constraints.anchor == java.awt.GridBagConstraints.NORTHEAST) gridBagConstraints.insets = new Insets(3, 0, 0, 30);
            else if (constraints.anchor == java.awt.GridBagConstraints.NORTHWEST) gridBagConstraints.insets = new Insets(3, 30, 0, 0);
            
            gridBagLayout.setConstraints(this.name_label, gridBagConstraints);
            
            revalidate();
        }
        
        this.constraints = (GridBagConstraints) constraints.clone();
        onConstraintsUpdated();
    }
    
    public Point getConnectionPanelThingRelativeLocation()
    {
        Point connectionPanelRelativeLocation = this.connectionPanel.getLocation();
        Point ConnectionPointLocation = getLocation();
        
        int thingRelativeLocationX = connectionPanelRelativeLocation.x + ConnectionPointLocation.x + this.connectionPanel.getWidth()/2;
        int thingRelativeLocationY = connectionPanelRelativeLocation.y + ConnectionPointLocation.y + this.connectionPanel.getHeight()/2;
        
        // if (getAnchor() == java.awt.GridBagConstraints.NORTHEAST) blockRelativeLocationX += filledCircle.getWidth();

        return new Point(thingRelativeLocationX, thingRelativeLocationY); 
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        this.parentThing.onConnectionPointPressed(this);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        this.parentThing.onConnectionPointReleased();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.parentThing.onConnectionPointEntered(this);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.parentThing.onConnectionPointExited();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        this.parentThing.onConnectionPointDragged(me.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}
