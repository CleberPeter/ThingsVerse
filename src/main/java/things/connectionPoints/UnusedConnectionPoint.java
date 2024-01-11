/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things.connectionPoints;

import customWidgets.FilledCircle;
import things.connectionPoints.ConnectionPoint;
import java.awt.Color;
import java.awt.GridBagConstraints;
import things.Thing;

/**
 *
 * @author cleber
 */
public class UnusedConnectionPoint extends ConnectionPoint
{    
    private static final Color DEFAULT_COLOR = new Color(192, 192, 192); 

    public UnusedConnectionPoint(Thing parentThing, GridBagConstraints constraints) {
        super(parentThing, null, constraints, new FilledCircle(DEFAULT_COLOR, 20));
    }

    @Override
    public void onConstraintsUpdated() {
    }
    
    public Color getColor()
    {
        return DEFAULT_COLOR;
    }
    
    public void setColor(Color color) {
    }
}
