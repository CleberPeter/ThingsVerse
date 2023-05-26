/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.interfaces;

import components.basic.Input;
import components.basic.Output;
import java.awt.Insets;
import java.util.List;

/**
 *
 * @author cleber
 */
public abstract class Variable {
    private String name;
    private List<Input> inputs;
    private Output output;
    private Insets insets;

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
    }

    /**
     * @return the output
     */
    public Output getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(Output output) {
        this.output = output;
    }

    /**
     * @return the insets
     */
    public Insets getInsets() {
        return insets;
    }

    /**
     * @param insets the insets to set
     */
    public void setInsets(Insets insets) {
        this.insets = insets;
    }
}
