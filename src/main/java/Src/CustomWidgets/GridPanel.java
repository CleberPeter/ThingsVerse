/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Src.CustomWidgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 *
 * @author cleber
 */
public class GridPanel extends JPanel {
    
    public int getcellSize() {
        return cellSize;
    }

    public void setcellSize(int cellSize) {
        this.cellSize = cellSize;
        repaint();
    }
    
    public void paint(Graphics graphics) 
    {
        super.paint(graphics);  
        
        Graphics2D graphics_2d = (Graphics2D) graphics;
        graphics_2d.setColor(new Color(66, 66, 66));
        
        Dimension dimension = getSize();
        int n_columns = dimension.width/cellSize;
        int n_rows = dimension.height/cellSize;
        
        for (int j = 1; j <= n_columns; j++)
        {
            Line2D lin = new Line2D.Float(j*cellSize, 0, j*cellSize, dimension.height);
            graphics_2d.draw(lin);
        }
        
        for (int i = 1; i <= n_rows; i++)
        {
            Line2D lin = new Line2D.Float(0, i*cellSize, dimension.width, i*cellSize);
            graphics_2d.draw(lin);
        }
    }
    
    private int cellSize = 10;
}