/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blocks;

import customWidgets.FilledCircle;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cleber
 */
public class ConnectionPoint extends JPanel implements MouseListener, MouseMotionListener
{
    private String name;
    private ConnectionPointType type;
    private int anchor;
    private FilledCircle filledCircle;
    private JLabel name_label;
    private Block parentBlock;
            
    public ConnectionPoint(Block parentBlock, String name, ConnectionPointType type, int anchor)
    {
        this.parentBlock = parentBlock;
        this.name = name;
        this.type = type;
        this.anchor = anchor;
        
        setLayout(new GridBagLayout());
        
        filledCircle = new FilledCircle(this.type.getColor());
        filledCircle.addMouseListener(this);
        filledCircle.addMouseMotionListener(this);
        
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = anchor;
        
        add(filledCircle, gridBagConstraints);
        
        if (this.type != ConnectionPointType.UNUSED)
        {
            name_label = new JLabel();
            name_label.setFont(new Font("Arial", Font.BOLD, 16));
            name_label.setForeground(Color.white);
            name_label.setText(this.name);

            if (this.anchor == java.awt.GridBagConstraints.NORTHEAST) gridBagConstraints.insets = new Insets(0, 0, 0, 30);
            else if (this.anchor == java.awt.GridBagConstraints.NORTHWEST) gridBagConstraints.insets = new Insets(0, 30, 0, 0);

            add(name_label, gridBagConstraints);

            setName(this.name);
        }
        
        setOpaque(false);    
    }
    
    public ConnectionPointType getType()
    {
        return this.type;
    }
    
    public int getAnchor()
    {
        return this.anchor;
    }
    
    public void setAnchor(int anchor)
    {
        if (anchor != getAnchor() && getType() != ConnectionPointType.UNUSED)
        {
            GridBagLayout gridBagLayout = (GridBagLayout) getLayout();
        
            GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 0.5;
            gridBagConstraints.weighty = 0.5;
            gridBagConstraints.anchor = anchor;
            
            gridBagLayout.setConstraints(filledCircle, gridBagConstraints);
            
            if (anchor == java.awt.GridBagConstraints.NORTHEAST) gridBagConstraints.insets = new Insets(0, 0, 0, 30);
            else if (anchor == java.awt.GridBagConstraints.NORTHWEST) gridBagConstraints.insets = new Insets(0, 30, 0, 0);
            
            gridBagLayout.setConstraints(name_label, gridBagConstraints);
            
            revalidate();
        }
        
        this.anchor = anchor;
    }
    
    public Point getFilledCircleBlockRelativeLocation()
    {
        Point circleFilledRelativeLocation = filledCircle.getLocation();
        Point ConnectionPointLocation = getLocation();
        
        int blockRelativeLocationX = circleFilledRelativeLocation.x + ConnectionPointLocation.x + filledCircle.getWidth()/2;;
        int blockRelativeLocationY = circleFilledRelativeLocation.y + ConnectionPointLocation.y + filledCircle.getHeight()/2;
        
        // if (getAnchor() == java.awt.GridBagConstraints.NORTHEAST) blockRelativeLocationX += filledCircle.getWidth();
        
        return new Point(blockRelativeLocationX, blockRelativeLocationY); 
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        this.parentBlock.onConnectionPointPressed(this);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        this.parentBlock.onConnectionPointReleased();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.parentBlock.onConnectionPointEntered(this);
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        this.parentBlock.onConnectionPointDragged(me.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}
