/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mouseAdapters;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Function;

/**
 *
 * @author cleber
 */
public class ComponentSelect extends MouseAdapter
{
    private Function callbackOnSelect;
    private boolean moving = false;
    
    public void registerComponent(Function callbackOnSelect, Component... components)
    {
        this.callbackOnSelect = callbackOnSelect;

        for (Component component : components)
        {
            component.addMouseListener( this );
            component.addMouseMotionListener(this);
        }
            
    }
    
    public void deregisterComponent(Component... components)
    {
        for (Component component : components)
        {
            component.removeMouseListener( this );
            component.removeMouseMotionListener(this);
        }
            
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (!moving && this.callbackOnSelect != null) callbackOnSelect.apply(null);
        moving = false;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        moving = true; // prevent select when object is moved
    }
}
