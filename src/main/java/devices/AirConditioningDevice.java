/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devices;

import blocks.Input;
import blocks.Output;
import blocks.Block;
import java.awt.Dimension;

/**
 *
 * @author cleber
 */
public class AirConditioningDevice extends Block
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(400, 150);
        
    public AirConditioningDevice()
    {   
        super("Ar Condicionado");

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        addOutput(new Output("Consumo Energético", 0.0));
        addOutput(new Output("Ar", 0.0));
        
        addInput(new Input("On/Off", 0.0));
        addInput(new Input("Temperatura", 0.0));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
