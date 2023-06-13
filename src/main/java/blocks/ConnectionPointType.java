/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blocks;

import java.awt.Color;

/**
 *
 * @author cleber
 */
public enum ConnectionPointType 
{
    INPUT(new Color(48, 189, 68)),
    OUTPUT(new Color(240, 178, 61)),
    UNUSED(new Color(192, 192, 192));

    private Color color;

    ConnectionPointType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
