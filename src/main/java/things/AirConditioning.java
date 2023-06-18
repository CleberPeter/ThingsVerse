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
        setConnectionPoint(new PropertyConnectionPoint(this, "powerConsumption", GridBagConstraints.NORTHWEST, true));
        setConnectionPoint(new PropertyConnectionPoint(this, "temperature", GridBagConstraints.NORTHWEST, true));
        setConnectionPoint(new ActionConnectionPoint(this, "do-On/Off", GridBagConstraints.NORTHWEST));
        setConnectionPoint(new EventConnectionPoint(this, "on-temperatureReached", GridBagConstraints.NORTHWEST));
        
        setConnectionPoint(new SensingConnectionPoint(this, "temperature", GridBagConstraints.NORTHEAST));
        setConnectionPoint(new ActuatorConnectionPoint(this, "air", GridBagConstraints.NORTHEAST));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
