/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.exerc1;

import javax.swing.JOptionPane;

/**
 *
 * @author samuk
 */
public class Exerc1 {

    public static void main(String[] args) {

        double resultado = somatoria(0, 50);
        JOptionPane.showMessageDialog(null, "O resultado é:" + resultado);

    }

    public static double somatoria(double ni, double nf) {
        if (ni == nf) {
            return nf;
        } else {
            return ni + somatoria(ni + 1, nf);
        }

    }
}
