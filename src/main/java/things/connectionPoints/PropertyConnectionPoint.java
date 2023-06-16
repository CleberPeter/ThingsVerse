/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things.connectionPoints;

import customWidgets.FilledCircle;
import java.awt.Color;
import things.Thing;

/**
 *
 * @author cleber
 */
public class PropertyConnectionPoint extends ConnectionPoint
{
    private static final Color DEFAULT_COLOR = new Color(248, 120, 16); 

    private boolean observable;
    
    public PropertyConnectionPoint(Thing parentThing, String name, int anchor, boolean observable) {
        super(parentThing, name, DEFAULT_COLOR, anchor, new FilledCircle(DEFAULT_COLOR));
        
        this.observable = observable;
    }

    @Override
    public void onAnchorUpdated() {
    }
    
}
