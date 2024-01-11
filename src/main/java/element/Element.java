/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package element;

import customWidgets.PanelRound;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentListener;
import javax.swing.JLayeredPane;

/**
 *
 * @author cleber
 */
public abstract class Element extends JLayeredPane implements ComponentListener
{
    public PanelRound main_panel;
    protected PanelRound header_panel;
    
    protected String name;
    
    protected Dimension dimension;
    public Insets insets;  
    
    protected Boolean selected = false;
}
