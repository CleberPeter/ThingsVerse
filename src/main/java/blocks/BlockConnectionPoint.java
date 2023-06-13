/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blocks;

import blocks.Block;
import blocks.ConnectionPoint;
import java.awt.Point;

/**
 *
 * @author cleber
 */
public class BlockConnectionPoint
{
    private Block block;
    private ConnectionPoint connectionPoint;

    public BlockConnectionPoint(Block block, ConnectionPoint connectionPoint)
    {
        this.block = block;
        this.connectionPoint = connectionPoint;
    }
    
    public Point getContextRelativeLocation()
    {
        return this.getBlock().getConnectionPointContextRelativeLocation(getConnectionPoint());
    }

    /**
     * @return the block
     */
    public Block getBlock() {
        return block;
    }

    /**
     * @return the connectionPoint
     */
    public ConnectionPoint getConnectionPoint() {
        return connectionPoint;
    }
}
