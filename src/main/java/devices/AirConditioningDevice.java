/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devices;

import blocks.Block;
import contexts.Context;
import java.awt.Dimension;

/**
 *
 * @author cleber
 */
public class AirConditioningDevice extends Block
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(400, 150);
        
    public AirConditioningDevice(Context parentContext)
    {   
        super("Ar Condicionado", parentContext);

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        setOutput("Consumo Energético");
        setOutput("Ar");
        
        setInput("On/Off");
        setInput("Temperatura");
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
