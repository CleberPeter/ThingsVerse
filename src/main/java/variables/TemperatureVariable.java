/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package variables;

import blocks.Block;
import contexts.Context;
import java.awt.Dimension;

/**
 *
 * @author cleber
 */
public class TemperatureVariable extends Block
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(300, 100);
        
    public TemperatureVariable(Context parentContext)
    {   
        super("Temperatura", parentContext);

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        setOutput("Temperatura");
        setInput("dT/dt");
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
