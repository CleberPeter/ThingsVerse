/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package things;

import things.Thing;
import contexts.Context;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import things.connectionPoints.ActionConnectionPoint;
import things.connectionPoints.ActuatorConnectionPoint;
import things.connectionPoints.EventConnectionPoint;
import things.connectionPoints.PropertyConnectionPoint;
import things.connectionPoints.SensingConnectionPoint;

/**
 *
 * @author cleber
 */
public class AirConditioning extends Thing
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(450, 250);
        
    public AirConditioning(Context parentContext)
    {   
        super("Air Conditioner", parentContext);

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
        
        setConnectionPoint(new PropertyConnectionPoint(this, "powerConsumption", gridBagConstraints, true));
        gridBagConstraints.insets.top += 50;
        setConnectionPoint(new PropertyConnectionPoint(this, "temperature", gridBagConstraints, true));
        gridBagConstraints.insets.top += 50;
        setConnectionPoint(new ActionConnectionPoint(this, "do-On/Off", gridBagConstraints));
        gridBagConstraints.insets.top += 50;
        setConnectionPoint(new EventConnectionPoint(this, "on-temperatureReached", gridBagConstraints));
        
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets.top = 50;
        setConnectionPoint(new SensingConnectionPoint(this, "temperature", gridBagConstraints));
        gridBagConstraints.insets.top += 50;
        setConnectionPoint(new ActuatorConnectionPoint(this, "air", gridBagConstraints));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
