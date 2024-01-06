/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author cleber
 */
public class ToolsEnabled {
    private boolean select;
    private boolean wire;
    private boolean move;
    private boolean scale;

    /**
     * @return the select
     */
    public boolean selectIsEnabled() {
        return select;
    }

    /**
     * @param select the select to set
     */
    public void setSelect(boolean select) {
        this.select = select;
    }

    /**
     * @return the wire
     */
    public boolean wireIsEnabled() {
        return wire;
    }

    /**
     * @param wire the wire to set
     */
    public void setWire(boolean wire) {
        this.wire = wire;
    }

    /**
     * @return the move
     */
    public boolean moveIsEnabled() {
        return move;
    }

    /**
     * @param move the move to set
     */
    public void setMove(boolean move) {
        this.move = move;
    }

    /**
     * @return the scale
     */
    public boolean scaleIsEnabled() {
        return scale;
    }

    /**
     * @param scale the scale to set
     */
    public void setScale(boolean scale) {
        this.scale = scale;
    }
    
}
