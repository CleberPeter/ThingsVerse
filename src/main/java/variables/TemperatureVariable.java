/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package variables;

import blocks.Input;
import blocks.Output;
import blocks.Block;
import java.awt.Dimension;

/**
 *
 * @author cleber
 */
public class TemperatureVariable extends Block
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(300, 100);
        
    public TemperatureVariable()
    {   
        super("Temperatura");

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        addOutput(new Output("Temperatura", 26));
        addInput(new Input("dT/dt", 0));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
