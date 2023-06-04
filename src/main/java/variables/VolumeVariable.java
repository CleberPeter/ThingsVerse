/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package variables;

import blocks.Block;
import blocks.Input;
import blocks.Output;
import java.awt.Dimension;

/**
 *
 * @author cleber
 */
public class VolumeVariable extends Block {
 
    private static final Dimension DEFAULT_DIMESION = new Dimension(300, 100);
        
    public VolumeVariable()
    {   
        super("Volume");

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        addOutput(new Output("Volume", 26));
        addInput(new Input("dV/dt", 0));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
    }
}
