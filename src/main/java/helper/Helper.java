/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.awt.Point;

/**
 *
 * @author cleber
 */
public class Helper 
{
    public static double distanceBetweenPoints(Point p1, Point p2)
    {
        double dx_2 = Math.pow(p1.x - p2.x, 2);
        double dy_2 = Math.pow(p1.y - p2.y, 2);
        
        return Math.sqrt(dx_2 + dy_2);
    }
}
