/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapters;

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
public class AirToTemperatureAdapter extends Thing
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(400, 200);
        
    public AirToTemperatureAdapter(Context parentContext)
    {   
        super("Air Conditioner -> Temperature", parentContext);

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {        
        setConnectionPoint(new ActuatorConnectionPoint(this, "dT/dt", GridBagConstraints.NORTHEAST));
        
        setConnectionPoint(new SensingConnectionPoint(this, "volume", GridBagConstraints.NORTHWEST));
        setConnectionPoint(new SensingConnectionPoint(this, "air", GridBagConstraints.NORTHWEST));
        setConnectionPoint(new SensingConnectionPoint(this, "temperature", GridBagConstraints.NORTHWEST));

    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
