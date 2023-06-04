/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapters;

import blocks.Block;
import blocks.Input;
import blocks.Output;
import java.awt.Dimension;

/**
 *
 * @author cleber
 */
public class AirToTemperatureAdapter extends Block
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(400, 150);
        
    public AirToTemperatureAdapter()
    {   
        super("Ar Condicionado -> Temperatura");

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        addOutput(new Output("dT/dt", 0));
        
        addInput(new Input("Volume", 0));
        addInput(new Input("Ar", 0));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
