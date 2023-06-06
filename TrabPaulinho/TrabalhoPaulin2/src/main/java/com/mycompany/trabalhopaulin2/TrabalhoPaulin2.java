package com.mycompany.trabalhopaulin2;

import javax.swing.JOptionPane;
import model.ContaBancaria;
import services.Ordenacoes;
import services.Pesquisas;

public class TrabalhoPaulin2 {

    public static void main(String[] args) {

        int continuar = 1;
        ContaBancaria[] contas = null;
        do {

            int menu = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação que gostaria de efetuar:"
                    + "\n1-Cadastro de Conta"
                    + "\n2-Ordenar contas cadastradas"
                    + "\n3-Efetuar Depósito"
                    + "\n4-Efetuar Saque"
                    + "\n5-Calcular saldo total do banco"
                    + "\n6-Verificar conta com saldo negativo\n-------------------------------------------------------"));

            switch (menu) {

                case 1:

                    int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de contas que você deseja cadastrar:"));

                    contas = new ContaBancaria[tamanho];

                    for (int i = 0; i < tamanho; i++) {
                        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
                        String titular = JOptionPane.showInputDialog("Digite o nome do titular:");
                        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial:"));

                        contas[i] = new ContaBancaria(n, saldo, titular);

                    }

                    String resultado = "Contas cadastradas:\n";

                    for (ContaBancaria conta : contas) {
                        resultado += "Número: " + conta.getN();
                        resultado += ", Titular: " + conta.getTitular();
                        resultado += ", Saldo: " + conta.getSaldo();
                        resultado += "\n";
                    }
                    System.out.println("oi, teste");
                    break;
                case 2:

                    int esc_ordena = Integer.parseInt(JOptionPane.showInputDialog("Informe como gostaria de ordenar as contas:"
                            + "\n1-Ordenar por número da conta"
                            + "\n2-Ordenar pelo saldo da conta"));

                    if (esc_ordena == 1) {

                        Ordenacoes.ordenarPorNumero(contas);
                        exibirContasOrdenadas(contas);

                    } else if (esc_ordena == 2) {

                        Ordenacoes.ordenarPorSaldo(contas);
                        exibirContasOrdenadas(contas);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                    }
                    break;
                case 3:

                    int esc_pesquisa = Integer.parseInt(JOptionPane.showInputDialog("Gostaria de pesquisar a conta pelo nome "
                            + "ou pelo nº da conta?"
                            + "\n1 - Nome \n 2- Nº da conta "));

                    Ordenacoes.ordenarPorNumero(contas);
                    Ordenacoes.ordenarPorSaldo(contas);

                    if (esc_pesquisa == 1) {

                        String nome_pesquisa = JOptionPane.showInputDialog("Informe o nome do titular da conta: ");
                        Pesquisas.pesquisaLinearNome(nome_pesquisa, contas);

                            String resultado_nm = "Conta selecionada: ";
                            
                            for (ContaBancaria contaNome : contas) {
                                
                                resultado_nm += "Número: " + contaNome.getN();
                                resultado_nm += ", Titular: " + contaNome.getTitular();
                                resultado_nm += ", Saldo: " + contaNome.getSaldo();
                                resultado_nm += "\n";
                                JOptionPane.showMessageDialog(null, resultado_nm);

                                double valor_depositado = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor "
                                        + "que gostaria de depositar: "));
                                contaNome.depositar(valor_depositado);
                                break;
                            }
                             JOptionPane.showMessageDialog(null, resultado_nm);

                        

                    } else if (esc_pesquisa == 2) {

                        int numero_pesquisa = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
                        Pesquisas.pesquisaLinearNumeroConta(numero_pesquisa, contas);

                        String resultado_conta = "Conta selecionada:\n";
                        for (ContaBancaria contaNum : contas) {
                            resultado_conta += "Número: " + contaNum.getN();
                            resultado_conta += ", Titular: " + contaNum.getTitular();
                            resultado_conta += ", Saldo: " + contaNum.getSaldo();
                            resultado_conta += "\n";
                            JOptionPane.showMessageDialog(null,resultado_conta);
                            double valor_deposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor "
                                    + "que gostaria de depositar: "));
                            contaNum.depositar(valor_deposito);
                            String resultado_conta_depositada = "Conta pós depósito:\n";
                            resultado_conta_depositada += "Número: " + contaNum.getN();
                            resultado_conta_depositada += ", Titular: " + contaNum.getTitular();
                            resultado_conta_depositada += ", Saldo: " + contaNum.getSaldo();
                            resultado_conta_depositada += "\n";
                            JOptionPane.showMessageDialog(null, resultado_conta_depositada);
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor inválido");

                    }
                    break;
                case 4:
                    int numero_pesquisa = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
                    Ordenacoes.ordenarPorNumero(contas);
                    Pesquisas.pesquisaBinaria(numero_pesquisa, contas);
                    String resultado_nm = "Conta selecionada: ";
                    for (ContaBancaria contaSaque : contas) {
                        resultado_nm += "Número: " + contaSaque.getN();
                        resultado_nm += ", Titular: " + contaSaque.getTitular();
                        resultado_nm += ", Saldo: " + contaSaque.getSaldo();
                        resultado_nm += "\n";
                        JOptionPane.showMessageDialog(null, resultado_nm);

                        double valor_saque = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor "
                                + "que gostaria de sacar: "));
                        contaSaque.sacar(valor_saque);
                        JOptionPane.showMessageDialog(null, "O saldo atual é de: " + contaSaque.getSaldo());
                        break;
                    }
                    break;
                case 5:

                    double saldoTotal = calcularSaldoTotal(contas, 0, 0.0);
                    JOptionPane.showMessageDialog(null, "O Saldo total das contas do banco é: " + saldoTotal);
                    break;
                case 6:
                    String resultadoSaldoNegativo = verificaSaldoNegativo(contas, 0);
                    JOptionPane.showMessageDialog(null, resultadoSaldoNegativo);
                    break;
            }

            //pesquisa parte 3 **implentação do menu somente após ajustar as funcionalidades**
            continuar = Integer.parseInt(JOptionPane.showInputDialog("Gostaria de fazer nova ação? "
                    + "\n1- Sim"
                    + "\n2- Não"));

        } while (continuar != 2);

    } //método

    private static void exibirContasOrdenadas(ContaBancaria[] contas) {
        String resultado = "Contas ordenadas:\n";

        for (ContaBancaria conta : contas) {
            resultado += "Número: " + conta.getN();
            resultado += ", Titular: " + conta.getTitular();
            resultado += ", Saldo: " + conta.getSaldo();
            resultado += "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    private static double calcularSaldoTotal(ContaBancaria[] contas, int i, double somaSaldo) {

        if (i < contas.length) {

            somaSaldo = somaSaldo + contas[i].getSaldo();
            return calcularSaldoTotal(contas, i + 1, somaSaldo);

        } else {
            return somaSaldo;
        }
    }

    private static String verificaSaldoNegativo(ContaBancaria[] contas, int i) {
        String resultado = "Contas Negativas: \n";
        boolean saldoEncontrado = false;

        for (ContaBancaria conta : contas) {
            if (conta.getSaldo() < 0) {
                resultado += "Número: " + conta.getN();
                resultado += ", Titular: " + conta.getTitular();
                resultado += ", Saldo:" + conta.getSaldo();
                resultado += "\n";
                saldoEncontrado = true;
            }
        }
        if (!saldoEncontrado) {
            resultado = "Nenhuma conta com saldo negativo encontrada";
        }
        return resultado;

    }
    public static ContaBancaria pesquisaLinearNome(String nome_pesquisado, ContaBancaria[] contas) {
            String resultado_nome = "Conta Encontrada: \n";
            for(ContaBancaria conta : contas){
            if (conta.getTitular().equals(nome_pesquisado)) {
                return conta;
                
            }
        }
        return null;// se a conta não for encontrada
    }
}
