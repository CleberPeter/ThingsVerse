/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Src.CustomWidgets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenuBar;

/**
 *
 * @author cleber
 */
public class BackgroundMenuBar extends JMenuBar {
    Color bgColor=Color.WHITE;

    public void setColor(Color color) {
        bgColor=color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
