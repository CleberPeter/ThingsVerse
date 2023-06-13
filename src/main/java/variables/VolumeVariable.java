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
public class VolumeVariable extends Block {
 
    private static final Dimension DEFAULT_DIMESION = new Dimension(300, 100);
        
    public VolumeVariable(Context parentContext)
    {   
        super("Volume", parentContext);

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        setOutput("Volume");
        setInput("dV/dt");
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
