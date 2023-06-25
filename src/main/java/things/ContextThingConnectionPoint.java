/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things;

import contexts.Context;
import things.Thing;
import things.connectionPoints.ConnectionPoint;
import java.awt.Point;

/**
 *
 * @author cleber
 */
public class ContextThingConnectionPoint
{
    private Context context;
    private Thing thing;
    private ConnectionPoint connectionPoint;

    public ContextThingConnectionPoint(Context context, Thing thing, ConnectionPoint connectionPoint)
    {
        this.context = context;
        this.thing = thing;
        this.connectionPoint = connectionPoint;
    }
    
    public Point getLocation()
    {
        return this.getContext().getMainFrameRelativeLocation(this.getThing(), this.getConnectionPoint());
    }

    /**
     * @return the thing
     */
    public Thing getThing() {
        return thing;
    }
    
    public Context getContext() {
        return context;
    }

    /**
     * @return the connectionPoint
     */
    public ConnectionPoint getConnectionPoint() {
        return connectionPoint;
    }
}
