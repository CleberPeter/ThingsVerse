/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapters;

import blocks.Block;
import contexts.Context;
import java.awt.Dimension;

/**
 *
 * @author cleber
 */
public class AirToTemperatureAdapter extends Block
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(400, 150);
        
    public AirToTemperatureAdapter(Context parentContext)
    {   
        super("Ar Condicionado -> Temperatura", parentContext);

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        setOutput("dT/dt");
        
        setInput("Volume");
        setInput("Ar");
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
