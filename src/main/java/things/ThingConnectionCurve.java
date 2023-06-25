/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things;

import things.Thing;
import things.connectionPoints.ConnectionPoint;
import helper.Helper;
import java.awt.Point;

/**
 *
 * @author cleber
 */

public class ThingConnectionCurve 
{    
    private ContextThingConnectionPoint startPoint;
    private ContextThingConnectionPoint endPoint;
    
    public ThingConnectionCurve(ContextThingConnectionPoint startPoint)
    {
        this.startPoint = startPoint;
        endPoint = null;
    }
    
    public void setEndPoint(ContextThingConnectionPoint endPoint)
    {
        this.endPoint = endPoint;
    }

    /**
     * @return the startPoint
     */
    public ContextThingConnectionPoint getStartPoint() {
        return startPoint;
    }

    /**
     * @return the endPoint
     */
    public ContextThingConnectionPoint getEndPoint() {
        return endPoint;
    }
    
    public Boolean isFilled()
    {
        return startPoint != null && endPoint != null;
    }
}
