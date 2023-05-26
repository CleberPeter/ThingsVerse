/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import components.basic.Input;
import components.basic.Output;
import components.interfaces.Device;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mouseAdapters.ComponentMover;

/**
 *
 * @author cleber
 */
public class AirConditioning extends Device
{
    private static final Dimension DEFAULT_DIMESION = new Dimension(400, 170);
    
    private List<Output> outputs = new ArrayList<>();
    private List<Input> inputs = new ArrayList<>();
        
    public AirConditioning()
    {   
        super("Ar Condicionado");

        initComponents();
        setUpLayout();
    }
    
    public void initComponents()
    {
        outputs.add(new Output("Vento", 0.0));
        outputs.add(new Output("Consumo Energético", 0.0));
        
        inputs.add(new Input("Temperatura", 0.0));
        inputs.add(new Input("On/Off", 0.0));
    }
    
    private void setUpLayout()
    {                
        setPreferredSize(DEFAULT_DIMESION);
        setMinimumSize(DEFAULT_DIMESION);
        
        setOutputs(outputs);
        setInputs(inputs);
    }
}
