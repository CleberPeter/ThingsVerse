/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things.connectionPoints;

import customWidgets.FilledTriangle;
import java.awt.Color;
import java.awt.GridBagConstraints;
import things.Thing;

/**
 *
 * @author cleber
 */
public class ActionConnectionPoint extends ConnectionPoint
{
    private static final Color DEFAULT_COLOR = new Color(48, 189, 68); 

    public ActionConnectionPoint(Thing parentThing, String name, GridBagConstraints constraints) {
        super(parentThing, name, constraints, new FilledTriangle(DEFAULT_COLOR, 20, constraints.anchor == GridBagConstraints.NORTHEAST ? Math.PI : 0));
    }

    @Override
    public void onConstraintsUpdated() {
        FilledTriangle filledTriangle = (FilledTriangle) this.getConnectionPanel();
        
        filledTriangle.setAngle(this.getConstraints().anchor == GridBagConstraints.NORTHEAST ? Math.PI : 0);
    }
    
    public Color getColor()
    {
        return DEFAULT_COLOR;
    }
    
    public void setColor(Color color)
    {
        FilledTriangle filledTriangle = (FilledTriangle) this.getConnectionPanel();
        
        filledTriangle.setColor(color);
    }
}
