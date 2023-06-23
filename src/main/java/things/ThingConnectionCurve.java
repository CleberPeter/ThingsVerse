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
    private ThingConnectionPoint startPoint;
    private ThingConnectionPoint endPoint;
    
    public ThingConnectionCurve(ThingConnectionPoint startPoint)
    {
        this.startPoint = startPoint;
        endPoint = null;
    }
    
    public void setEndPoint(ThingConnectionPoint endPoint)
    {
        this.endPoint = endPoint;
    }

    /**
     * @return the startPoint
     */
    public ThingConnectionPoint getStartPoint() {
        return startPoint;
    }

    /**
     * @return the endPoint
     */
    public ThingConnectionPoint getEndPoint() {
        return endPoint;
    }
    
    public Boolean isFilled()
    {
        return startPoint != null && endPoint != null;
    }
}
