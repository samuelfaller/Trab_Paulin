/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.exerc2;

import javax.swing.JOptionPane;

/**
 *
 * @author samuk
 */
public class Exerc2 {

    public static void main(String[] args) {

        String numero = JOptionPane.showInputDialog("Informe um número para ser calculado seu fatorial");
        double numeroo = Integer.parseInt(numero);

        double resultado = fatorial(numeroo);
        JOptionPane.showMessageDialog(null, "O fatorial do numero " + numero + " é: " + resultado);
    }

    public static double fatorial(double num) {
        if (num == 0) {
            return 1;
        } else {
            return num * fatorial(num - 1);
        }
    }

}
    