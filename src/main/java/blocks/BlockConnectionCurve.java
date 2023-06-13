/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blocks;

import blocks.Block;
import blocks.ConnectionPoint;
import helper.Helper;
import java.awt.Point;

/**
 *
 * @author cleber
 */

public class BlockConnectionCurve 
{    
    private BlockConnectionPoint startPoint;
    private BlockConnectionPoint endPoint;
    
    public BlockConnectionCurve(BlockConnectionPoint startPoint)
    {
        this.startPoint = startPoint;
        endPoint = null;
    }
    
    public void setEndPoint(BlockConnectionPoint endPoint)
    {
        this.endPoint = endPoint;
    }

    /**
     * @return the startPoint
     */
    public BlockConnectionPoint getStartPoint() {
        return startPoint;
    }

    /**
     * @return the endPoint
     */
    public BlockConnectionPoint getEndPoint() {
        return endPoint;
    }
}
