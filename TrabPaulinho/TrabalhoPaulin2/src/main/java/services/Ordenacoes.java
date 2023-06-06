/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import model.ContaBancaria;

/**
 *
 * @author Samuel
 */
public class Ordenacoes {

    public static void ordenarPorNumero(ContaBancaria[] contas) {
        for (int i = 1; i < contas.length; i++) {
            ContaBancaria chave = contas[i];
            int j = i - 1;

            while (j >= 0 && contas[j].getN() > chave.getN()) {
                contas[j + 1] = contas[j];
                j--;
            }

            contas[j + 1] = chave;
        }
    }

    public static void ordenarPorSaldo(ContaBancaria[] contas) {
        for (int i = 1; i < contas.length; i++) {
            ContaBancaria chave = contas[i];
            int j = i - 1;

            while (j >= 0 && contas[j].getSaldo() > chave.getSaldo()) {
                contas[j + 1] = contas[j];
                j--;
            }

            contas[j + 1] = chave;
        }
    }
    
    
    
}
