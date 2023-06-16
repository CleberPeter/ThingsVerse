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
public class TemperatureVariable extends Thing
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(300, 100);
        
    public TemperatureVariable(Context parentContext)
    {   
        super("Temperature", parentContext);

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        setConnectionPoint(new SensingConnectionPoint(this, "dT/dt", GridBagConstraints.NORTHWEST));
        
        setConnectionPoint(new ActuatorConnectionPoint(this, "temperature", GridBagConstraints.NORTHEAST));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
