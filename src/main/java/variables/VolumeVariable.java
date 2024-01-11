/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package variables;

import things.Thing;
import contexts.Context;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import things.connectionPoints.ActuatorConnectionPoint;
import things.connectionPoints.PropertyConnectionPoint;
import things.connectionPoints.SensingConnectionPoint;

/**
 *
 * @author cleber
 */
public class VolumeVariable extends Thing {
 
    private static final Dimension DEFAULT_DIMESION = new Dimension(300, 100);
        
    public VolumeVariable(Context parentContext)
    {   
        super("Volume", parentContext);

        initComponents();
        setUpLayout();
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
        
        setConnectionPoint(new SensingConnectionPoint(this, "dV/dt", gridBagConstraints));
        
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        setConnectionPoint(new ActuatorConnectionPoint(this, "volume", gridBagConstraints));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
    }
}
