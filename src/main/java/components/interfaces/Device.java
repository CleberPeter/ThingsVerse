/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.interfaces;

import components.basic.Input;
import components.basic.Output;
import customWidgets.PanelRound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;

/**
 *
 * @author cleber
 */
public abstract class Device extends PanelRound implements ComponentListener
{
    private static final Color DEFAULT_COLOR = new Color(35, 35, 35, 164);

    private PanelRound header_panel;
    private String name;
    private List<Input> inputs;
    private List<Output> outputs;
    
    public Device(String name)
    {   
        setLayout(new GridBagLayout());
        
        header_panel = new PanelRound();
        
        header_panel.setRoundTopLeft(20);
        header_panel.setRoundTopRight(20);
        header_panel.setBackground(Color.white);
        
        JLabel titleLabel = new JLabel();
        titleLabel.setText(name);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
        
        header_panel.setLayout(new java.awt.GridBagLayout());
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        
        header_panel.add(titleLabel, gridBagConstraints);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(header_panel, gridBagConstraints);
        
        setBackground(DEFAULT_COLOR);
        setRoundDefault(20);
        setName(name);
        
        ComponentMover componentMover = new ComponentMover();
        componentMover.registerComponent(this);
        componentMover.setDragInsets(new Insets(10, 10, 10, 10));
        
        ComponentResizer componentResizer = new ComponentResizer(new Insets(10, 10, 10, 10), this);
        componentResizer.setSnapSize(new Dimension(15, 15));
        
        addComponentListener(this);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the inputs
     */
    public List<Input> getInputs() {
        return inputs;
    }

    /**
     * @param inputs the inputs to set
     */
    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        
        int top_padding = 50;
        for (Input input : inputs) 
        {
            gridBagConstraints.insets = new Insets(top_padding, 10, 0, 0);
            add(input, gridBagConstraints);
            
            top_padding += 40;
        }
    }

    /**
     * @return the outputs
     */
    public List<Output> getOutputs() {
        return outputs;
    }

    /**
     * @param outputs the outputs to set
     */
    public void setOutputs(List<Output> outputs) 
    {
        this.outputs = outputs;
    
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        
        int top_padding = 50;
        for (Output output : outputs) 
        {
            gridBagConstraints.insets = new Insets(top_padding, 0, 0, 10);
            add(output, gridBagConstraints);
            
            top_padding += 40;
        }
    }
    
    public void recalculateSizes()
    {   
        Dimension context_panel_header_dimension = new Dimension(this.getWidth(), 30);
        header_panel.setPreferredSize(context_panel_header_dimension);
        header_panel.setMinimumSize(context_panel_header_dimension);
        
        header_panel.setLayout(new java.awt.GridBagLayout());
    }
    
    @Override
    public void componentResized(ComponentEvent ce) 
    {
        recalculateSizes();
    }
    
    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
}
