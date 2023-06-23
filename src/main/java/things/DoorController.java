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
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets.top = 50;
        
        setConnectionPoint(new ActuatorConnectionPoint(this, "dV/dt", gridBagConstraints));
        gridBagConstraints.insets.top += 50;
        setConnectionPoint(new ActuatorConnectionPoint(this, "dY/dt", gridBagConstraints));

        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets.top = 50;
        setConnectionPoint(new ActionConnectionPoint(this, "do-Open/Close", gridBagConstraints));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
