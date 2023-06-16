/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things;

import things.Thing;
import things.connectionPoints.ConnectionPoint;
import java.awt.Point;

/**
 *
 * @author cleber
 */
public class ThingConnectionPoint
{
    private Thing thing;
    private ConnectionPoint connectionPoint;

    public ThingConnectionPoint(Thing thing, ConnectionPoint connectionPoint)
    {
        this.thing = thing;
        this.connectionPoint = connectionPoint;
    }
    
    public Point getContextRelativeLocation()
    {
        return this.getThing().getConnectionPointContextRelativeLocation(getConnectionPoint());
    }

    /**
     * @return the thing
     */
    public Thing getThing() {
        return thing;
    }

    /**
     * @return the connectionPoint
     */
    public ConnectionPoint getConnectionPoint() {
        return connectionPoint;
    }
}
