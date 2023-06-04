/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blocks;

import customWidgets.PanelRound;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import mouseAdapters.ComponentMover;
import mouseAdapters.ComponentResizer;

/**
 *
 * @author cleber
 */
public abstract class Block extends JLayeredPane implements ComponentListener
{
    private static final Color DEFAULT_COLOR = new Color(60,60,60);
    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);

    private PanelRound header_panel;
    private PanelRound main_panel;
    private String name;
    private List<Input> inputs = new ArrayList<>();
    private List<Output> outputs = new ArrayList<>();
    
    private int inputs_top_padding = 50;
    private int outputs_top_padding = 50;
    
    public Block(String name)
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
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(header_panel, gridBagConstraints);
        
        main_panel = new PanelRound();
        main_panel.setRoundDefault(20);
        main_panel.setBackground(DEFAULT_COLOR);
        
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(main_panel, gridBagConstraints, 1);
        
        setBackground(TRANSPARENT_COLOR);
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
    
    public void addInput(Input input) 
    {   
        this.inputs.add(input);
    
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        
        gridBagConstraints.insets = new Insets(inputs_top_padding, 0, 0, 0);
        add(input, gridBagConstraints, 1);
        
        inputs_top_padding += 50;
    }

    /**
     * @return the outputs
     */
    public List<Output> getOutputs() {
        return outputs;
    }

    public void addOutput(Output output) 
    {   
        this.outputs.add(output);
    
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        
        gridBagConstraints.insets = new Insets(outputs_top_padding, 0, 0, 0);
        add(output, gridBagConstraints, 1);
        
        outputs_top_padding += 50;
    }
    
    public void recalculateSizes()
    {   
        Dimension header_panel_dimension = new Dimension(this.getWidth() - 20, 30);
        header_panel.setPreferredSize(header_panel_dimension);
        header_panel.setMinimumSize(header_panel_dimension);
        header_panel.setLayout(new java.awt.GridBagLayout());
        
        Dimension main_panel_dimension = new Dimension(header_panel_dimension.width, this.getHeight());
        main_panel.setPreferredSize(main_panel_dimension);
        main_panel.setMinimumSize(main_panel_dimension);
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
