/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moead;

import java.util.Random;

/**
 *
 * @author ashcrok
 */
public class main {
    
    public static void main(String[] args) {
        double z[] = new double[2];
        z[0] = z[1] = Integer.MAX_VALUE;
        
        // optimize f1
        for (int i=0; i<10000; i++) {
            double x = (new Random()).nextDouble() * 20 - 10;
            if (f1(x) < z[0])
                z[0] = f1(x);
        }
        // optimize f2
        for (int i=0; i<10000; i++) {
            double x = (new Random()).nextDouble() * 20 - 10;
            if (f2(x) < z[1])
                z[1] = f2(x);
        }
        
        for (int k=0; k<=10; k++) {
            double l[] = new double[2];
            double min = Integer.MAX_VALUE;
            double sol = Integer.MIN_VALUE;
            l[0] = k * 0.1;
            l[1] = 1 - l[0];
            for (int i=0; i<10000; i++) {
                double x = (new Random()).nextDouble() * 20 - 10;
                if (gte(x,l,z) < min) {
                    sol = x;
                    min = gte(x,l,z);
                }
            }
            System.out.println(sol);
        }
    }
    
    public static double gws(double x, double[] l) { return -f1(x) * l[0] + -f2(x) * l[1]; }
    public static double gte(double x, double[] l, double[] z) { 
        double gte1 = l[0] * Math.abs(f1(x) - z[0]);
        double gte2 = l[1] * Math.abs(f2(x) - z[1]);
        if (gte1 > gte2) return gte1; else return gte2;
    }
    
    public static double f1(double x) { return Math.pow((x+2),2) - 10; }
    public static double f2(double x) { return Math.pow((x-2),2) + 20; }
    
}
