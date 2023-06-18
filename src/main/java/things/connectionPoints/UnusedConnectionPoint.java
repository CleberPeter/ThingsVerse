/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things.connectionPoints;

import customWidgets.FilledCircle;
import things.connectionPoints.ConnectionPoint;
import java.awt.Color;
import things.Thing;

/**
 *
 * @author cleber
 */
public class UnusedConnectionPoint extends ConnectionPoint
{    
    private static final Color DEFAULT_COLOR = new Color(192, 192, 192); 

    public UnusedConnectionPoint(Thing parentThing, int anchor) {
        super(parentThing, null, anchor, new FilledCircle(DEFAULT_COLOR));
    }

    @Override
    public void onAnchorUpdated() {
    }
    
    public Color getColor()
    {
        return DEFAULT_COLOR;
    }
    
    public void setColor(Color color) {
    }
    
}
