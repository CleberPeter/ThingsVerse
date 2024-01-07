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
    private boolean resize;

    /**
     * @return the select
     */
    public boolean selectIsEnabled() {
        return select;
    }

    /**
     * @param select the select to set
     */
    public void enableSelect(boolean enable) {
        this.select = enable;
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
    public void enableWire(boolean enable) {
        this.wire = enable;
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
    public void enableMove(boolean enable) {
        this.move = enable;
    }

    /**
     * @return the resize
     */
    public boolean resizeIsEnabled() {
        return resize;
    }

    /**
     * @param scale the resize to set
     */
    public void enableResize(boolean enable) {
        this.resize = enable;
    }
    
}
