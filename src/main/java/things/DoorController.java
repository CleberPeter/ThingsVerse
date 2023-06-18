/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things;

import contexts.Context;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import things.connectionPoints.ActionConnectionPoint;
import things.connectionPoints.ActuatorConnectionPoint;

/**
 *
 * @author cleber
 */
public class DoorController extends Thing
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(300, 150);
        
    public DoorController(Context parentContext)
    {   
        super("Door Controller", parentContext);

        setUpLayout();
        initComponents();
    }
    
    public void initComponents()
    {
        setConnectionPoint(new ActuatorConnectionPoint(this, "dV/dt", GridBagConstraints.NORTHWEST));
        setConnectionPoint(new ActuatorConnectionPoint(this, "dY/dt", GridBagConstraints.NORTHWEST));

        setConnectionPoint(new ActionConnectionPoint(this, "do-Open/Close", GridBagConstraints.NORTHEAST));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
